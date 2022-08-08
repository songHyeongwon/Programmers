package lavel2;

import java.util.Arrays;

public class Solution36 {
	//https://school.programmers.co.kr/learn/courses/30/lessons/12923
	public static void main(String[] args) {
		Solution36 sol = new Solution36();
		long begin =1;
		long end =10;
		System.out.println(Arrays.toString(sol.solution(begin, end)));
	}
	
    int max = 10000000;

    public int getArrNum(int k){
        if(k == 1) return 0; //소수 없음 1 리턴

        for(int i=2; i<=Math.sqrt(k); i++) {
            if(k % i == 0 && (k/i) <= max) return k/i; 
        }
        return 1;
    }
   
    public int[] solution(long begin, long end) {
        int s = (int)begin;
        int e = (int)end;
        int[] answer = new int[e-s+1];
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = getArrNum(s + i); 
		}
        return answer;
    }
}
