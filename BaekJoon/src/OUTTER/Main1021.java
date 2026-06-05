package OUTTER;

import java.util.LinkedList;
import java.util.Scanner;

public class Main1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] seq = new int[M];

		int count = 0; // ��ȯ ī��Ʈ
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			deque.add(i + 1);
		}

		for (int i = 0; i < seq.length; i++) {
			seq[i] = sc.nextInt();
		}
		// ã�Ƽ� ������
		for (int i = 0; i < seq.length; i++) {
			int idx = deque.indexOf(seq[i]); // ã�ƾߵ� ��� ��ġ 
			int findIdx = 0; // �߾���
			if (deque.size() % 2 == 0) {
				findIdx = deque.size() / 2 - 1;
			} else {
				findIdx = deque.size() / 2;
			}

			if (idx <= findIdx) {
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
			deque.pollFirst(); // ������ ������ �� �� ���Ҹ� ����
		}
		System.out.println(count);
		sc.close();
	}
}
