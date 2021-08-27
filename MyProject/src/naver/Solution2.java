package naver;

import java.util.HashMap;

public class Solution2 {
public int solution(String[] T, String[] R) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		for (int i = 0; i < R.length; i++) {
			int tCase = Integer.parseInt(T[i].replaceAll("[^0-9]", ""));
			//같은 테스트케이스 있는지
			if(map.containsKey(tCase)) {
				//OK일경우 덮어씌움
				if(map.get(tCase).equals("OK")) {
					map.put(tCase, R[i]);
				}
			} else {
				map.put(tCase, R[i]);
			}
		}
		
		int okCnt = 0;
		int result = map.size();
		for(int k : map.keySet()) {
			if(map.get(k).equals("OK")) okCnt++;
		}
		return (int) ((okCnt*100)/result);
    }
}
