package step11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}
		int temp = 1;
		int queueNum = 0;
		int arrIndex = 0;
		while (!queue.isEmpty()) {
			queueNum = queue.poll();
			if (temp++ % K == 0) {
				arr[arrIndex++] = queueNum;
			} else {
				queue.add(queueNum);
			}
		}
		System.out.println(Arrays.toString(arr).replaceAll("\\[", "<").replaceAll("\\]", ">"));
	}
}
