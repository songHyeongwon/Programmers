package lavel2;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/86048?language=java
public class Solution26 {
	public static void main(String[] args) {
		int[] enter = {1,4,2,3};
		int[] leave = {2,1,3,4};
		System.out.println(Arrays.toString(new Solution26().solution(enter, leave)));
	}
    public int[] solution(int[] enter, int[] leave) {
        int len = enter.length;
        int[] answer = new int[len];
        int[] idx = new int[len + 1];
        for(int i = 0; i < len; i++) {
        	idx[enter[i]] = i;
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0, late = idx[enter[i]]; j < len; j++) {
                int e = enter[i], l = leave[j];
                if(e == l) break;
                if(idx[l] > late || (late > idx[e] && idx[l] < late)) {
                    answer[l-1]++;
                    answer[e-1]++;
                    late = Math.max(idx[l], late);
                }
            }
        }
        return answer;
    }

}
