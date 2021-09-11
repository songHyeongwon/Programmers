package kakao;

import java.util.*;

public class Solution5 {
	
	public static void main(String[] args) {
		int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		System.out.println(new Solution5().solution(info, edges));
	}
	static int didCnt = 1;//양의 수는 1부터 시작
	public int solution(int[] info, int[][] edges) {
		int answer = 0;
		boolean[] isChekc = new boolean[info.length];
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(edges[0]);
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int startNode = node[0];
			int goNoed = node[1];
			
		}
		
		return answer;
	}
}
