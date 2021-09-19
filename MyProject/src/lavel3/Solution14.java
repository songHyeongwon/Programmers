package lavel3;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/43238
public class Solution14 {
	public static void main(String[] args) {
		int[] times = {7,10};
		
		System.out.println(new Solution14().solution(6, times));
	}
	//이진탐색
	public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = times[0];
		long max = (long) n * times[times.length-1];
        long answer = max;
        
        while(min <= max) {//최소가 최대보다 작을동안만
        	long mid = (max + min)/2;
        	long check = isCheck(mid , times);
        	if(check < n) {
        		//시간 늘이기
            	min = mid + 1; //(max + min)/2 +1;
        	} else {
        		//시간 줄이기
        		max = mid - 1; //(max + min)/2 -1;
        		answer = Math.min(mid, answer); //최소값으로 항상 갱신
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
