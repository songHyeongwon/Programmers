package step33;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			queue.add(sc.nextInt());
		}
		int result = 0;
		int befor = 0;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			temp += befor;
			result += temp;
			befor = temp;
		}
		System.out.println(result);
		sc.close();
	}
}
