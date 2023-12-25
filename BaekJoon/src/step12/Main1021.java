package step12;

import java.util.LinkedList;
import java.util.Scanner;

public class Main1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] seq = new int[M];
		
		int count = 0; //반환 카운트
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			deque.add(i+1);
		}
		for (int i = 0; i < seq.length; i++) {
			seq[i] = sc.nextInt();
		}
		//찾아서 빼내기
		for (int i = 0; i < seq.length; i++) {
			int idx = deque.indexOf(seq[i]); //찾아야될 요소 위치
			int findIdx = 0; //중앙점
			if(deque.size() % 2 == 0) {
				findIdx = deque.size() / 2 -1;
			} else {
				findIdx = deque.size() / 2;
			}
			
			if(idx <= findIdx) {
				for (int j = 0; j < idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			} else {
				for (int j = 0; j < deque.size() - idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			deque.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
		}
		System.out.println(count);
		sc.close();
	}
}
