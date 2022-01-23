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
	//���� ���� �ؽü� ����
	private static Map<String, Integer> apiKey = new HashMap<String, Integer>();
	private static Map<String, Integer> apiServiceId = new HashMap<String, Integer>();
	private static Map<String, Integer> browser = new HashMap<String, Integer>();
	final static String mainUrl = "http://apis.daum.net/search/"; //���� URL
	
	public static void main(String[] args) throws Exception {
		MainProcess process = new MainProcess();
		//���� ��������
		FileInputStream inputStream = new FileInputStream(new File("./input.log"));
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String temp = "";
		int totalCnt = 0;
		int okCnt = 0;
		while((temp = br.readLine()) != null) {
			String[] arr = process.getParseLog(temp);
			//apikey ã�� ���Խ�
			Pattern pattern = Pattern.compile("(\\bapikey=\\b)([A-Za-z0-9]{4})");
			Matcher matcher = pattern.matcher(arr[1]);
			//200���ϰ�츸 && ���� URL�� ��츸 && apiKey�� ������츸
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
		StringBuffer buf = process.getPrintBuf(okCnt); //�ۼ�Ʈ ����� ���� �����־���
		process.printFile(buf);
		// ������
		System.out.println(apiKey.toString());
		System.out.println(apiServiceId.toString());
		System.out.println(browser.toString());
		System.out.println("���� ���� = " + okCnt);
		System.out.println("���� ���� = " + totalCnt);
		System.out.println(buf);
		
	}
	
	//�α׸� �迭�� �и�
	private String[] getParseLog(String temp) {
		String[] arr = temp.split("\\]");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].replaceFirst("\\[", "");
		}
		return arr;
	}
	
	//�� ��ü�� ������ ����
	private void addMap(Map<String, Integer> map , String key) {
		if(map.containsKey(key)) 
			map.put(key, map.get(key) + 1);
		else 
			map.put(key, 1);
	}
	
	//�־��� ���� �������� ����Ʈ ��ȯ
	private List<Entry<String, Integer>> mapSortReverseOrder(Map<String, Integer> map ) {
		List<Entry<String, Integer>> mapList = new ArrayList<>(map.entrySet());
		mapList.sort(((o1, o2) -> o2.getValue() - o1.getValue()));
		return mapList;
	}
	
	//��� ���� ����
	private StringBuffer getPrintBuf(int okCnt) {
		//apiKey ������
		List<Entry<String, Integer>> apiKeyList = mapSortReverseOrder(apiKey);
		//apiServiceId ������
		List<Entry<String, Integer>> apiServiceIdList = mapSortReverseOrder(apiServiceId);
		//������ ���� ������
		List<Entry<String, Integer>> browserList = mapSortReverseOrder(browser);
		
		StringBuffer buf = new StringBuffer();
		buf.append("�ִ�ȣ�� APIKEY")
		.append("\n")
		.append(apiKeyList.get(0).getKey())
		.append("\n")
		.append("\n")
		.append("���� 3���� API Service ID�� ������ ��û��")
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
		.append("���������� ��� ����")
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
	
	//���� ���
	private void printFile(StringBuffer buf) throws Exception{
		OutputStream output = new FileOutputStream("./output.log");
	    byte[] by = buf.toString().getBytes();
	    output.write(by);
	    output.close();
	}
}
