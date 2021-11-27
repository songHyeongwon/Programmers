package lineFintech;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution1 {
	public static void main(String[] args) {
		String[] record = {"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"};
		System.out.println(Arrays.toString(new Solution1().solution(record)));
	}
	
	public int[] solution(String[] record) {
		
		int sumA = 0;//선입 선출법
		int sumB = 0;//후입 선출법
		
		Queue<Good> queue = new LinkedList<Good>(); //선입선출
		Stack<Good> stack = new Stack<Good>(); //후입 선출
		
		for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");
			if(arr[0].equals("P")) {
				//구매
				Good good1 = new Good();
				good1.price = Integer.parseInt(arr[1]);
				good1.count = Integer.parseInt(arr[2]);
				stack.add(good1);//선입선출 리스트에담기
				
				Good good2 = new Good();
				good2.price = Integer.parseInt(arr[1]);
				good2.count = Integer.parseInt(arr[2]);
				queue.add(good2);//후입선출 리스트에 담기
			} else {
				//판매
				int selCnt = Integer.parseInt(arr[2]);//판매갯수
				Good good1 = queue.peek();
				Good good2 = stack.peek();
				//선입선출부터
				while(selCnt > 0) {
					if(good1.count - selCnt > 0) {
						sumA += (selCnt * good1.price);
						good1.count = good1.count - selCnt;
						break;
					} else {
						sumA += (good1.count * good1.price);
						selCnt -= good1.count;
						queue.poll();
						good1 = queue.peek();
					}
				}
				
				selCnt = Integer.parseInt(arr[2]);//판매갯수
				while(selCnt > 0) {
					if(good2.count - selCnt > 0) {
						sumB += (selCnt * good2.price);
						good2.count = good2.count - selCnt;
						break;
					} else {
						sumB += (good2.count * good2.price);
						selCnt -= good2.count;
						stack.pop();
						good2 = stack.peek();
					}
				}
			}
		}
		
		
        int[] answer = new int[2];
        
        answer[0] = sumA;
        answer[1] = sumB;
        return answer;
    }
	class Good {
		//int index;
		int price;
		int count;
	}
}
