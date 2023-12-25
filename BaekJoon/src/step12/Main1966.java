package step12;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ROW = sc.nextInt();
		
		for (int i = 0; i < ROW; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Queue<int[]> queue = new LinkedList<int[]>();
			PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
			for (int j = 0; j < N; j++) {
				int[] temp = new int[2];
				int point = sc.nextInt();
				temp[0] = j;
				temp[1] = point;
				pQueue.add(point);
				queue.add(temp);
			}
			
			int count = 0;
			k : while(!queue.isEmpty()) {
				int point = pQueue.peek();
				int[] temp = queue.poll();
				//우선순위가 일치하면
				if(temp[1] == point) {
					pQueue.poll();	//해당우선순위 문서를 뽑아냈다.
					count++;	//출력문서 ++
					//원하는 문서라면 종료하고 끝
					if(temp[0] == M) {
						System.out.println(count);
						break k;
					}
				} else {
					queue.add(temp);
				}
			}
		}
		sc.close();
	}
}
