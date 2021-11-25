package lavel3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//https://programmers.co.kr/learn/courses/30/lessons/67258?language=java
public class Solution30 {
	public static void main(String[] args) {
		String [] arr = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(Arrays.toString(new Solution30().solution(arr)));
	}
	
	public int[] solution(String[] gems) {
		HashSet<String> set = new HashSet<String>();
		HashMap<String , Integer> map = new HashMap<String , Integer>();
 		Queue<String> q = new LinkedList<String>();
		for(String k : gems) {
			set.add(k);
		}
		int start = 0; //시작점
		int end = gems.length; //종료점
		
		int startPoint = 0;
		for (int i = 0; i < gems.length; i++) {
			map.put(gems[i], map.getOrDefault(gems[i], 0) +1);
			q.add(gems[i]);
			
			while(true) {
				String temp = q.peek();
				if(map.get(temp) > 1) {
					q.poll();
					startPoint++;
					map.put(temp, map.get(temp)-1);
				} else {
					break;
				}
			}
			if(map.size() == set.size() && end > q.size()) {
				end = q.size();
				start = startPoint;
			}
			
		}
		
		
        int[] answer = new int[2];
        answer[0] = start + 1;
        answer[1] = start + end;
        return answer;
    }
}
