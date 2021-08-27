package naver;

import java.util.HashMap;

public class Solution2 {
public int solution(String[] T, String[] R) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		for (int i = 0; i < R.length; i++) {
			int tCase = Integer.parseInt(T[i].replaceAll("[^0-9]", ""));
			//���� �׽�Ʈ���̽� �ִ���
			if(map.containsKey(tCase)) {
				//OK�ϰ�� �����
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
