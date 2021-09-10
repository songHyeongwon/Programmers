package lavel3;

//https://programmers.co.kr/learn/courses/30/lessons/12927
import java.util.Collections;
import java.util.PriorityQueue;
public class Solution4 {
	public static void main(String[] args) {
		int n = 4;
		int[] arr = {4, 3, 3};
		
		System.out.println(new Solution4().solution(n, arr));
	}
	
	public long solution(int n, int[] works) {
        long answer = 0;
        //우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : works) {
        	queue.add(i);
        }
        for(int i = 0; i < n; i++) {
        	int worksMax = queue.poll();
        	if(worksMax <= 0) {
        		break;
        	}
        	queue.add(worksMax -1);
        }       
        
        while(!queue.isEmpty()) {
        	int queueInt = queue.poll();
        	answer += (queueInt*queueInt);
        }
        return answer;
    }
}
