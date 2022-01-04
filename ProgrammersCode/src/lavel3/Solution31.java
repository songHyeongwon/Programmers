package lavel3;

//https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
public class Solution31 {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		System.out.println(new Solution31().solution(n, computers));
	}
	public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				dfs(computers , i , visited);
				answer++;
			}
		}
        
        return answer;
    }
	private boolean[] dfs(int[][] computers, int i, boolean[] visited) {
		visited[i] = true;
		
		for (int j = 0; j < computers.length; j++) {
			if(i !=j && computers[i][j] == 1 && !visited[j]) {
				visited = dfs(computers , j , visited);
			}
		}
		return visited;
	}
}
