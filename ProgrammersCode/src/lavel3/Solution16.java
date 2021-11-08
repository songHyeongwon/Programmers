package lavel3;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/72413?language=java
public class Solution16 {
	public static void main(String[] args) {
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		
		System.out.println(new Solution16().solution(6, 4, 6, 2, fares));
	}
	//출처 https://wellbell.tistory.com/101
	static final int MAX = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Node>> graph;
	//다익스트라 알고리즘
	public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        //생성
        graph = new ArrayList<>();//그래프 초기화
        for(int i=0; i <= n; i++) {
        	graph.add(new ArrayList<>());
        }
        //양방향으로 입력
        for(int[] i : fares) {
            graph.get(i[0]).add(new Node(i[1], i[2]));
            graph.get(i[1]).add(new Node(i[0], i[2]));
        }
        //반환배열 생성
        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] start = new int[n+1];
        //배열값을 맥스로 초기화
        Arrays.fill(startA, MAX);
        Arrays.fill(startB, MAX);
        Arrays.fill(start, MAX);
        //다익스트라 방식 구현
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);
        
        System.out.println(Arrays.toString(startA));
        System.out.println(Arrays.toString(startB));
        System.out.println(Arrays.toString(start));
        
        for(int i = 1; i <= n ; i ++) {
        	answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        }
        
        return answer;
    }
	//다익스트라 알고리즘 우선순위 큐로 비교
	private int[] dijkstra(int start, int[] costs) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		costs[start] = 0;
		
		while(!pq.isEmpty()) {
			Node row = pq.poll();
			int rowIndex = row.index;
			int rowCost = row.cost;
			//로우쪽이 더 크면 업데이트할 필요 없음
			if(rowCost > costs[rowIndex]) continue;
			
			ArrayList<Node> nodes = graph.get(rowIndex);
			for(Node node : nodes) {
				int cost = costs[rowIndex] + node.cost;
				//현재 코스트보다 작으면 배열을 업데이트해주고, 큐에 입력
				if(cost < costs[node.index]) {
					costs[node.index] = cost;
					pq.offer(new Node(node.index, cost));
				}
			}
		}
		
		return costs;
	}

	class Node implements Comparable<Node>{
		int index;
		int cost;
		Node(int index , int cost) {
			this.index = index;
			this.cost = cost;
		}
		//정렬지정
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
}
