package lavel1;

import java.util.HashSet;
//https://programmers.co.kr/learn/courses/30/lessons/87389?language=java
public class Solution14 {
	public static void main(String[] args) {
		System.out.println(new Solution14().solution(12));
	}
	
	public int solution(int n) {
        int answer = 1;
        
        while(n % answer != 1){
            answer++;
        }
        return answer;
    }
}
