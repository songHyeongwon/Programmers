package dkTechin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainProcess {
	//각각 담을 해시셋 선언
	private static Map<String, Integer> apiKey = new HashMap<String, Integer>();
	private static Map<String, Integer> apiServiceId = new HashMap<String, Integer>();
	private static Map<String, Integer> browser = new HashMap<String, Integer>();
	final static String mainUrl = "http://apis.daum.net/search/"; //고정 URL
	
	public static void main(String[] args) throws Exception {
		MainProcess process = new MainProcess();
		//파일 가져오기
		FileInputStream inputStream = new FileInputStream(new File("./input.log"));
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String temp = "";
		int totalCnt = 0;
		int okCnt = 0;
		while((temp = br.readLine()) != null) {
			String[] arr = process.getParseLog(temp);
			//apikey 찾는 정규식
			Pattern pattern = Pattern.compile("(\\bapikey=\\b)([A-Za-z0-9]{4})");
			Matcher matcher = pattern.matcher(arr[1]);
			//200번일경우만 && 정상 URL일 경우만 && apiKey가 있을경우만
			if(arr[0].equals("200") && arr[1].indexOf(mainUrl) > -1 && matcher.find()) {				//200
				String findapiKey = matcher.group(2).trim();
				String serviceId = arr[1].substring(mainUrl.length() , arr[1].indexOf("?"));
				String browserName = arr[2];
				
				process.addMap(apiKey , findapiKey);
				process.addMap(apiServiceId, serviceId);
				process.addMap(browser, browserName);
				okCnt++;
			}
			totalCnt++;
		}
		inputStream.close();
		StringBuffer buf = process.getPrintBuf(okCnt); //퍼센트 계산을 위해 갯수넣어줌
		process.printFile(buf);
		// 디버깅용
		System.out.println(apiKey.toString());
		System.out.println(apiServiceId.toString());
		System.out.println(browser.toString());
		System.out.println("성공 갯수 = " + okCnt);
		System.out.println("읽은 갯수 = " + totalCnt);
		System.out.println(buf);
		
	}
	
	//로그를 배열로 분리
	private String[] getParseLog(String temp) {
		String[] arr = temp.split("\\]");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].replaceFirst("\\[", "");
		}
		return arr;
	}
	
	//맵 객체에 갯수를 누적
	private void addMap(Map<String, Integer> map , String key) {
		if(map.containsKey(key)) 
			map.put(key, map.get(key) + 1);
		else 
			map.put(key, 1);
	}
	
	//주어진 맵을 역정렬한 리스트 반환
	private List<Entry<String, Integer>> mapSortReverseOrder(Map<String, Integer> map ) {
		List<Entry<String, Integer>> mapList = new ArrayList<>(map.entrySet());
		mapList.sort(((o1, o2) -> o2.getValue() - o1.getValue()));
		return mapList;
	}
	
	//출력 내용 생성
	private StringBuffer getPrintBuf(int okCnt) {
		//apiKey 역정렬
		List<Entry<String, Integer>> apiKeyList = mapSortReverseOrder(apiKey);
		//apiServiceId 역정렬
		List<Entry<String, Integer>> apiServiceIdList = mapSortReverseOrder(apiServiceId);
		//브라우저 갯수 역정렬
		List<Entry<String, Integer>> browserList = mapSortReverseOrder(browser);
		
		StringBuffer buf = new StringBuffer();
		buf.append("최다호출 APIKEY")
		.append("\n")
		.append(apiKeyList.get(0).getKey())
		.append("\n")
		.append("\n")
		.append("상위 3개의 API Service ID와 각각의 요청수")
		.append("\n");
		
		/*apiServiceId.entrySet().stream()
		.sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
		.limit(3)
		.forEach(vo -> 
			buf.append(vo.getKey())
			.append(":")
			.append(vo.getValue())
			.append("\n")
		);*/
		for(int i = 0; i < 3 && i < apiServiceIdList.size(); i++) {
			buf.append(apiServiceIdList.get(i).getKey())
			.append(":")
			.append(apiServiceIdList.get(i).getValue())
			.append("\n");
		}
		buf.append("\n")
		.append("웹브라우저별 사용 비율")
		.append("\n");
		
		/*browser.entrySet().stream()
		.sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
		.forEach(vo -> 
			buf.append(vo.getKey())
			.append(":")
			.append((int) ((double)vo.getValue() / (double)okCnt * 100.0) ).append("%")
			.append("\n")
		);*/
		for(Entry<String, Integer> vo : browserList) {
			buf.append(vo.getKey())
			.append(":")
			.append((int) ((double)vo.getValue() / (double)okCnt * 100.0) ).append("%")
			.append("\n");
		}
		return buf;
	}
	
	//파일 출력
	private void printFile(StringBuffer buf) throws Exception{
		OutputStream output = new FileOutputStream("./output.log");
	    byte[] by = buf.toString().getBytes();
	    output.write(by);
	    output.close();
	}
}
