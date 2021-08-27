package naver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution3 {
	public static void main(String[] args) {
		int[] A = {8,8,4,3};
		int K = 2;
		System.out.println(new Solution3().solution(A, K));
	}
	
	public int solution(int[] A, int K) {
        // write your code in Java SE 8
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i < A.length-K+1; i++) {
			List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
			for(int j = K-1; j >= 0; j--) {
				list.remove(i+j);
			}
			result = Math.min(result, getGap(list));
		}
		
		return result;
    }
	//진폭을 구하는 함수먼저
	public int getGap(List<Integer> list) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < list.size(); i++) {
			max = Math.max(max, list.get(i));
			min = Math.min(min, list.get(i));
		}
		return max - min;
	}
}
