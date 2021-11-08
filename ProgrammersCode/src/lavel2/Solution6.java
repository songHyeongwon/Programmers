package lavel2;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/70129
public class Solution6 {
	public static void main(String[] args) {
		String s = "1111111";
		System.out.println(Arrays.toString(new Solution6().solution(s)));
	}
	
	static int processCnt = 0;	//프로세스 실행횟수
	static int zeroCnt = 0; 	//0의 갯수
	
	public int[] solution(String s) {
		//반복실행 반환
		if(s.equals("1")) return new int[]{processCnt , zeroCnt};
		//프로세스 증가 , 0의 갯수 +=
		processCnt++;
		zeroCnt += ((int)s.chars().filter(c -> c == '0').count());
		//0 치환후 길이 => 이진수 변환
		s = s.replaceAll("0", "");
		String s2 = Integer.toBinaryString(s.length());
        
        return solution(s2);
    }
}
