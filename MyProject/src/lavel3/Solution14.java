package lavel3;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/43238
public class Solution14 {
	public static void main(String[] args) {
		int[] times = {7,10};
		
		System.out.println(new Solution14().solution(6, times));
	}
	
	public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = times[0];
		long max = (long) n * times[times.length-1];
        long answer = max;
        
        while(min <= max) {
        	long mid = (max + min)/2;
        	
        	long check = isCheck(mid , times);
        	
        	if(check < n) {
        		//시간 늘이기
            	min = mid + 1;
        	} else {
        		//시간 줄이기
        		max = mid - 1;
        		answer = Math.min(mid, answer);
        	}
        }
        return answer;
    }
	
	private long isCheck(long mid, int[] times) {
		long result = 0;
		for(int i=0; i < times.length; i++) {
			result += mid / times[i];
		}
		return result;
	}
}
