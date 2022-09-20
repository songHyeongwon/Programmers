package lavel3;

import java.util.Arrays;
//https://school.programmers.co.kr/learn/courses/30/lessons/12938
public class Solution33 {
	public static void main(String[] args) {
		Solution33 sol = new Solution33();
		System.out.println(Arrays.toString(sol.solution(2, 9)));
		System.out.println(Arrays.toString(sol.solution(2, 1)));
		System.out.println(Arrays.toString(sol.solution(2, 8)));

	}
	
	public int[] solution(int n, int s) {
		if(n > s) return new int[] {-1};
		
		int[] result = new int[n];
		int basic = s / n;
		int extra = s % n;
		
		for (int i = 0; i < result.length; i++) {
			result[i] = basic;
			if(i >= n - extra) result[i]++;
			
		}
		//Arrays.sort(result);
		return result;
    }
}
