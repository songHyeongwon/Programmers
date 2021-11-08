package lavel1;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/86051?language=java
public class Solution7 {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,6,7,8,0};
		System.out.println(new Solution7().solution(numbers));
	}
	
	public int solution(int[] numbers) {
        int answer = 0;
        int index = 0;
        Arrays.sort(numbers);
        for(int i = 0; i <= 9; i++) {
        	if(index < numbers.length && numbers[index] <= i) {
        		index++;
        	} else {
        		answer += i;
        	}
        }
        
        return answer;
        /*
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
         * */
    }
}
