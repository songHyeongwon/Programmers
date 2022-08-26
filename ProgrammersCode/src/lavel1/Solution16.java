package lavel1;

import java.util.HashMap;
//https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class Solution16 {
	public static void main(String[] args) {
		Solution16 sol = new Solution16();
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		System.out.println(sol.solution(survey, choices));
	}
	
	
	static char[] mbtiArr = {'R','T'
			,'C','F'
			,'J','M'
			,'A','N'};
	
    public String solution(String[] survey, int[] choices) {
        //초기화
        HashMap<Character, Integer> resultMap = new HashMap<Character, Integer>();
        for(Character c : mbtiArr) {
        	resultMap.put(c, 0);
        }
        
        for (int i = 0; i < choices.length; i++) {
			char type1 = survey[i].charAt(0);
			char type2 = survey[i].charAt(1);
			if(choices[i] == 4) continue;
			if(choices[i] < 4) {
				int coust = 4 - choices[i];
				resultMap.put(type1, resultMap.get(type1) + coust);
			} else {
				int coust = choices[i] - 4;
				resultMap.put(type2, resultMap.get(type2) + coust);
			}
		}
        
        char[] resultArr = new char[4];
        for (int i = 0; i < resultArr.length; i++) {
        	char resultChar = mbtiArr[i*2];
        	int type1 = resultMap.get(mbtiArr[i*2]);
        	int type2 = resultMap.get(mbtiArr[i*2 + 1]);
        	
        	if(type2 > type1) {
        		resultChar = mbtiArr[i*2 + 1];
        	}
        	
        	resultArr[i] = resultChar;
		}
        return String.valueOf(resultArr);
    }
}
