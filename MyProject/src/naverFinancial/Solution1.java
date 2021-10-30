package naverFinancial;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1 {
	public static void main(String[] args) {
		String[] id = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
		
		
		System.out.println(new Solution1().solution(id, 3));
	}
	
	public int solution(String[] id_list, int k) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < id_list.length; i++) {
        	
        	String[] today = id_list[i].split(" ");
        	HashSet<String> toDaySet = new HashSet<String>();
        	
        	for (int j = 0; j < today.length; j++) {
        		if(!toDaySet.add(today[j])) continue;
				if(map.containsKey(today[j])) {
					if(map.get(today[j]) < k) {
						map.put(today[j], map.get(today[j]) +1);
						answer++;
					}
				} else {
					map.put(today[j], 1);
					answer++;
				}
			}
		}
        return answer;
    }
}
