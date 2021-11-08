package lavel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//https://programmers.co.kr/learn/courses/30/lessons/72412
public class Solution15 {
	public static void main(String[] args) {
		String[] info = {
				"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"};
		String[] query = {
				"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"};
		System.out.println(Arrays.toString(new Solution15().solution(info, query)));
	}
	String[] djsdj = {"cpp", "java", "python" ,"-"};
	String[] wlrrns = {"backend" , "frontend", "-"};
	String[] rudfur = {"junior" , "senior" , "-"};
	String[] vnem = {"chicken" , "pizza" , "-"};
	
	static HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	
	public void setMap() {
		for (int a = 0; a < djsdj.length; a++) {
			for (int b = 0; b < wlrrns.length; b++) {
				for (int c = 0; c < rudfur.length; c++) {
					for (int d = 0; d < vnem.length; d++) {
						map.put(djsdj[a] + wlrrns[b] + rudfur[c] + vnem[d], new ArrayList<Integer>());
					}
				}
			}
		}
	}
	
	public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        setMap();
        
        for(int a =0; a <info.length; a++) {
        	String[] split = info[a].split(" ");
    		//String djsdj = split[0];//언어
    		//String wlrrns = split[1];//직군
    		//String rudfur = split[2];//경력
    		//String vnem = split[3];//푸드
    		int wjatn = Integer.parseInt(split[4]);
	        for(int i = 1<<(split.length-1); i < 1<<split.length; i++) {
	        	String binary = Integer.toBinaryString(i);
	        	String key = "";
	        	for(int j = 1; j <binary.length(); j++) {
	        		if(binary.charAt(j) =='0') {
	        			key+="-";
	        		} else {
	        			key+=split[j-1];
	        		}
	        	}
	        	map.get(key).add(wjatn);
	        }
        }
        //맵 정렬
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
        	Collections.sort(entry.getValue());
        }

        for (int i=0; i < query.length; i++) {
        	//점수컷~
        	String[] split = query[i].split("and");
    		String djsdj = split[0].trim();//언어
    		String wlrrns = split[1].trim();//직군
    		String rudfur = split[2].trim();//경력
    		String[] temp = split[3].trim().split(" ");//푸드
    		String vnem = temp[0];
    		int value = Integer.parseInt(temp[1]);
        	String key = djsdj + wlrrns + rudfur + vnem;
        	
        	ArrayList<Integer> output = map.get(key);
        	
        	int idx = Collections.binarySearch(output, value);
        	if(idx >= 0) {
	        	for(int a=idx-1; a>=0; a--) {
		        	if(output.get(idx) - output.get(a) > 0) {
		        		break;
		        	} else {
		        		idx = a;
		        	}
	        	}
	        	answer[i] = output.size()-idx;
        	} else {
        		answer[i] = output.size()+idx+1;
        	}
        }
        return answer;
    }
	
	
	/*public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        ArrayList<Infomation> infoArr = new ArrayList<Infomation>();
        
        for (int i = 0; i < info.length; i++) {
        	String[] split = info[i].split(" ");
    		String djsdj = split[0];//언어
    		String wlrrns = split[1];//직군
    		String rudfur = split[2];//경력
    		String vnem = split[3];//푸드
    		int wjatn = Integer.parseInt(split[4]);
        	Infomation infoObject = new Infomation(djsdj, wlrrns , rudfur, vnem, wjatn);
        	infoArr.add(infoObject);
		}
        
        for (int i = 0; i < query.length; i++) {
        	int count = 0;
        	String[] split = query[i].split("and");
    		String djsdj = split[0].trim();//언어
    		String wlrrns = split[1].trim();//직군
    		String rudfur = split[2].trim();//경력
    		String[] temp = split[3].trim().split(" ");//푸드
    		String vnem = temp[0];
    		int wjatn = Integer.parseInt(temp[1]);
    		
        	for(int j =0; j <infoArr.size(); j++) {
        		if(infoArr.get(j).getCheck(djsdj, wlrrns, rudfur, vnem, wjatn)) count++;
        	}
        	answer[i] = count;
        }
        
        
        return answer;
    }*/
}
/*class Infomation{
	String djsdj = "";//언어
	String wlrrns = "";//직군
	String rudfur = "";//경력
	String vnem = "";//푸드
	int wjatn = 0;
	
	public Infomation(String djsdj, String wlrrns, String rudfur, String vnem, int wjatn) {
		this.djsdj = djsdj;
		this.wlrrns = wlrrns;
		this.rudfur = rudfur;
		this.vnem = vnem;
		this.wjatn = wjatn;
	}
	
	public boolean getCheck(String djsdj, String wlrrns, String rudfur, String vnem, int wjatn) {
		boolean result= true;
		
		if(!djsdj.equals("-") && !djsdj.equals(this.djsdj)) result = false;
		if(!wlrrns.equals("-") && !wlrrns.equals(this.wlrrns)) result = false;
		if(!rudfur.equals("-") && !rudfur.equals(this.rudfur)) result = false;
		if(!vnem.equals("-") && !vnem.equals(this.vnem)) result = false;
		if(wjatn != -1 && wjatn > this.wjatn ) result = false;
		
		return result;
	}
}*/
