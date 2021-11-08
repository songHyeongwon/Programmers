package lavel3;
//https://programmers.co.kr/learn/courses/30/lessons/49189
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution25 {
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		System.out.println(new Solution25().solution(n, edge));
	}
	public int solution(int n, int[][] edge) {
		
		boolean[][] isConnect = new boolean[n+1][n+1];
		boolean[] check = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < edge.length; i++) {
			isConnect[edge[i][0]][edge[i][1]] = true;
			isConnect[edge[i][1]][edge[i][0]] = true;
		}
		
		check[1] = true;
		queue.add(1);
		
        int answer = 0;//가장 마지막 큐 사이즈
        while (!queue.isEmpty()) {
        	answer = queue.size();
			for (int i = 0; i < answer; i++) {
				int temp = queue.poll();
				for (int j = 1; j <= n; j++) {
					if(isConnect[j][temp] && !check[j]) {
						check[j] = true;
						queue.add(j);
					}
				}
			}
		}
        return answer;
    }
}
