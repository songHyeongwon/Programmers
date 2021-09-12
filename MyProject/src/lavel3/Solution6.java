package lavel3;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/12907
public class Solution6 {
	public static void main(String[] args) {
		System.out.println(new Solution6().solution(5, new int[]{1,2,5}));
	}
	
	//√‚√≥: https://tosuccess.tistory.com/57 [EI_HJ]
	public int solution(int n, int[] money) {
        int[] answer = new int[100001];
        answer[0] = 1;
        for(int i : money) {
            for(int j = i; j <= n; j++) {
                answer[j] += answer[j-i] % 1000000007;
            }
        }
        return answer[n];
    }
}
