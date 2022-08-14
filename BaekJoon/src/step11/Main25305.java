package step11;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main25305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		int n = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 0; i < n; i++) {
			q.add(sc.nextInt());
		}
		int t = 0;
		for (int i = 0; i < k; i++) {
			t = q.poll();
		}
		sc.close();
		System.out.println(t);
	}
}
