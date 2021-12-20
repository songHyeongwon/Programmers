package step19;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		Queue<Integer> queue = new LinkedList<Integer>();
		//�Է�
		for (int i = 0; i < N; i++) {
			queue.add(i+1);
		}
		
		int result = 0;//��ȯ
		boolean isCheck = true;//üũ
		while(!queue.isEmpty()) {
			if(isCheck) {
				result = queue.poll();
			} else {
				queue.add(queue.poll());
			}
			isCheck = !isCheck;
		}
		System.out.println(result);
	}
}
