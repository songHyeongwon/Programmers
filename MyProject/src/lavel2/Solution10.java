package lavel2;

import java.util.Arrays;
import java.util.HashMap;
//https://programmers.co.kr/learn/courses/30/lessons/42842
public class Solution10 {
	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		System.out.println(Arrays.toString(new Solution10().solution(brown, yellow)));
	}
	static int x = 0;
	static int y = 0;
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        //HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 3; i < sum; i++) {
			if(sum % i == 0) {
				if(i > 2 && sum/i>2) {
					int x = Math.max(i, sum/i);
					int y = Math.min(i, sum/i);
					if((x-2) * (y-2) == yellow) {
		        		answer[0] = x;
		        		answer[1] = y;
		        		break;
					}
					//map.put(Math.max(i, sum/i), Math.min(i, sum/i));
				}
			}
		}
        /*for(Integer key : map.keySet()) {
        	if(isCheck(key, map.get(key))) {
        		answer[0] = key;
        		answer[1] = map.get(key);
        		break;
        	}
        }*/
        return answer;
    }
}
