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
		
		int sumA = 0;//���� �����
		int sumB = 0;//���� �����
		
		Queue<Good> queue = new LinkedList<Good>(); //���Լ���
		Stack<Good> stack = new Stack<Good>(); //���� ����
		
		for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");
			if(arr[0].equals("P")) {
				//����
				Good good1 = new Good();
				good1.price = Integer.parseInt(arr[1]);
				good1.count = Integer.parseInt(arr[2]);
				stack.add(good1);//���Լ��� ����Ʈ�����
				
				Good good2 = new Good();
				good2.price = Integer.parseInt(arr[1]);
				good2.count = Integer.parseInt(arr[2]);
				queue.add(good2);//���Լ��� ����Ʈ�� ���
			} else {
				//�Ǹ�
				int selCnt = Integer.parseInt(arr[2]);//�ǸŰ���
				Good good1 = queue.peek();
				Good good2 = stack.peek();
				//���Լ������
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
				
				selCnt = Integer.parseInt(arr[2]);//�ǸŰ���
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
