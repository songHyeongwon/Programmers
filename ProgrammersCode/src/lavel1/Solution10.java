package lavel1;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/12954?language=java
public class Solution10 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution10().solution(20, 5)));
	}
	
	public long[] solution(long x, int n) {
	      
	      long[] answer=new long[n];
	       
	      for(int i=0; i<n; i++){
	         answer[i]=x*(i+1);
	      }
	      return answer;
	}
}
