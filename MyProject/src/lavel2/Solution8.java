package lavel2;

import java.util.ArrayList;
import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/77885?language=java
public class Solution8 {
	public static void main(String[] args) {
		long[] numbers = {2 ,7};
		System.out.println(Arrays.toString(new Solution8().solution(numbers)));
	}
	
	public long[] solution(long[] numbers) {
		//long[] answer = new long[numbers.length];
		/*for (int i = 0; i < answer.length; i++) {
			answer[i] = getResult(numbers[i]);
		}*/
		long[] answer = numbers.clone();
		
		for(int i = 0; i< answer.length; i++){
            answer[i]++;
            answer[i] += (answer[i]^numbers[i])>>>2;
        }
        return answer;
    }

	private Long getResult(long lon) {
		//짝수라면 +1해서 반환
		if(lon % 2 ==0) return lon+1;
		
		long result = 0L;
		
		String binaryString = Long.toBinaryString(lon);
		
		int lastIndex = binaryString.lastIndexOf("0");
		int fristIndex = binaryString.indexOf("1",lastIndex);
		if(lastIndex == -1) { // 111
			lon = lon+1;
			binaryString = Long.toBinaryString(lon);
			binaryString = binaryString.substring(0,2) + binaryString.substring(2,binaryString.length()).replaceAll("0","1");
			//1011
		} else {
			binaryString = binaryString.substring(0,lastIndex)+"1"+binaryString.substring(lastIndex+1,fristIndex)+"0"+binaryString.substring(fristIndex+1,binaryString.length());
		}
		return Long.parseLong(binaryString,2);
	}
}
