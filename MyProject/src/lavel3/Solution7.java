package lavel3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
//https://programmers.co.kr/learn/courses/30/lessons/12987
public class Solution7 {
	public static void main(String[] args) {
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		
		System.out.println(new Solution7().solution(A, B));
	}
	
	public int solution(int[] A, int[] B) {
        int answer = 0; 
        PriorityQueue<Integer> queueA = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> queueB = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0; i < A.length; i++) {
        	queueA.add(A[i]);
        	queueB.add(B[i]);
        }
        while(!queueA.isEmpty()) {
        	int maxA = queueA.poll();
        	int maxB = queueB.peek();
        	//System.out.println(maxA + " / "+ maxB);
        	if(maxB > maxA) {
        		answer++;
        		queueB.poll();
        	}
        	
        }
        
        return answer;
    }
}
