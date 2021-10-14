package lavel2;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/87390?language=java
public class Solution29 {
	public static void main(String[] args) {
		System.out.println(
			Arrays.toString(new Solution29().solution(4, 7 , 14))
		);
	}
	
	public int[] solution(int n, long left, long right) {
		int size = (int) (right - left) + 1;
        int[] arr = new int[size];
        long y = (left + 1)/n;
        int cnt = 0;
        for (long i = left; i <= right; i++) {
			if((i+1) % n == 0 ) {
				arr[cnt++] = n;
			} else {
				if((i + 1) % n > y) {
					arr[cnt++] = (int) ((i+1) % n);
				} else {
					arr[cnt++] = (int) ((i + 1)/n + 1);//n-k;
				}
			}
			if(y != (i + 1)/n) {
				y = (i + 1)/n;
			}
			
		}
        return arr;
    }
}
