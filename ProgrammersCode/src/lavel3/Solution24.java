package lavel3;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/49191?language=java
public class Solution24 {
	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		System.out.println(new Solution24().solution(n, results));
	}
	public void print(boolean[][] arr) {
		for(boolean[] k : arr) {
			System.out.println(Arrays.toString(k));
		}
	}
	public int solution(int n, int[][] results) {
		boolean[][] graph = new boolean[n+1][n+1];
		
		for (int i = 0; i < results.length; i++) {
			graph[results[i][0]][results[i][1]] = true;
		}
		//print(graph);
		for(int k=1; k<=n;k++){ 
			for(int i=1; i<=n;i++){ 
				for(int j=1; j<=n; j++){ 
					if(graph[i][k] && graph[k][j]) { 
						graph[i][j] =true; 
					}
				}
			}
		}
		//print(graph);
        int answer = 0;
		for (int i = 1; i <= n; i++) {
			int count = 0;//아는 시합횟수
			for (int j = 0; j <= n; j++) {
				if(graph[i][j] || graph[j][i]) {
					count++;
				}
			}
			//모든 사람과의 시합 결과를 알면
			if(count == n-1) {
				answer++;
			}
		}
        return answer;
    }
}
