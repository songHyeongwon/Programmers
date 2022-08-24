package lavel2;

import java.util.LinkedList;
import java.util.Queue;
//https://school.programmers.co.kr/learn/courses/30/lessons/118667
public class Solution37 {
	public static void main(String[] args) {
		Solution37 sol = new Solution37();
		//int[] arr1 = {3, 2, 7, 2};
		//int[] arr2 = {4, 6, 5, 1};
		
		//int[] arr1 = {1, 2, 1, 2};
		//int[] arr2 = {1, 10, 1, 2};
		
		int[] arr1 = {3, 3 ,3};
		int[] arr2 = {1, 3 ,3};
		
		System.out.println(sol.solution(arr1, arr2));
	}
	
    public long solution(int[] queue1, int[] queue2) {
    	long count = 0;
    	long sumBase = 0;
        long sum = 0;
        int max = 0;
        long q1sum = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        for (int i = 0; i < queue1.length; i++) {
        	sum += queue1[i];
        	q1sum += queue1[i];
        	q1.add(queue1[i]);
        	max = Math.max(max, queue1[i]);
		}
        for (int i = 0; i < queue2.length; i++) {
        	sum += queue2[i];
        	q2.add(queue2[i]);
        	max = Math.max(max, queue2[i]);
		}
        if(max > sum/2) return -1; 
        if(sum % 2 == 1) return -1;
        sumBase = sum/2;
        if(sumBase == q1sum) return 0;
        //여기까지가 준비
        while(sumBase != q1sum) {
        	if(q1.isEmpty() || q2.isEmpty()) return -1;
        	if(sumBase > q1sum) {
        		int temp = q2.poll();
        		q1sum += temp;
        		q1.add(temp);
        	} else {
        		int temp = q1.poll();
        		q1sum -= temp;
        		q2.add(temp);
        	}
        	count++;
        	if(count > 300000) return -1;
        }
        
        return count;
    }
}
