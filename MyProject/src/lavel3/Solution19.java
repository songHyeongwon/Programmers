package lavel3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
//https://programmers.co.kr/learn/courses/30/lessons/42628
public class Solution19 {
	public static void main(String[] args) {
		String[] arr = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"};
		
		System.out.println(Arrays.toString(new Solution19().solution(arr)));
	}
	
	public int[] solution(String[] operations) {
		PriorityQueue<Integer> orderQueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> reverseOrderQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int deleteCnt = 0;
		int insertCnt = 0;
		for(int i =0; i< operations.length; i++) {
			String[] split = operations[i].split(" ");
			if(split[0].equals("I")) {
				orderQueue.add(Integer.parseInt(split[1]));
				reverseOrderQueue.add(Integer.parseInt(split[1]));
				insertCnt++;
			} else {
				if(split[1].equals("-1")) {//최소값 삭제
					if(!orderQueue.isEmpty()) {
						orderQueue.poll();
						deleteCnt++;
					}
				} else {//최대값 삭제
					if(!reverseOrderQueue.isEmpty()) {
						reverseOrderQueue.poll();
						deleteCnt++;
					}
				}
				
			}
			
			if(deleteCnt == insertCnt) {
				orderQueue.clear();
				reverseOrderQueue.clear();
			}
		}

		//System.out.println(orderQueue.toString());
		//System.out.println(reverseOrderQueue.toString());
		int[] answer = new int[2];
		if(insertCnt > deleteCnt) {
			answer[0] = reverseOrderQueue.poll();
			answer[1] = orderQueue.poll();
		}
        return answer;
    }
}
