package lavel3;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/64062
public class Solution12 {
	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(new Solution12().solution(arr, 3));
	}
	
	public int solution(int[] stones, int k) {
		int answer = 0;
        
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < stones.length; i++) {
			min = Math.min(min, stones[i]);
			max = Math.max(max, stones[i]);
		}
		
		while(min <= max) {
			int mid = (min + max) / 2;
			
			if(isCheck(stones , k , mid)) {
				min = mid +1;
				answer = Math.max(mid, answer);
			} else {
				max = mid -1;
			}
		}
        return answer;
    }

	private boolean isCheck(int[] stones, int k, int mid) {
		int stack = 0;		
		
		for(int sto : stones) {
			if(sto - mid < 0) {
				stack++;
			} else {
				stack = 0;
			}
			if(stack == k) {
				return false;
			}
		}
		return true;
	}
}
