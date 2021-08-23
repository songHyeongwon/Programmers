package lavel2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42885
public class Solution7 {
	public static void main(String[] args) {
		int[] people = {70, 80, 50};
		int limit = 100;
		
		System.out.println(new Solution7().solution(people, limit));
	}
	
	public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int lastIndex = people.length-1;
        int fristIndex = 0;
        
        while(fristIndex <= lastIndex) {
        	if(people[lastIndex] + people[fristIndex]  <=limit) {
        		fristIndex++;
        		lastIndex--;
        	} else {
        		lastIndex--;
        	}
        	answer++;
        }
        
        return answer;
    }
}
