package lavel3;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/72413?language=java
public class Solution16 {
	public static void main(String[] args) {
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		
		System.out.println(new Solution16().solution(6, 4, 6, 2, fares));
	}
	//��ó https://wellbell.tistory.com/101
	static final int MAX = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Node>> graph;
	//���ͽ�Ʈ�� �˰���
	public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        //����
        graph = new ArrayList<>();//�׷��� �ʱ�ȭ
        for(int i=0; i <= n; i++) {
        	graph.add(new ArrayList<>());
        }
        //��������� �Է�
        for(int[] i : fares) {
            graph.get(i[0]).add(new Node(i[1], i[2]));
            graph.get(i[1]).add(new Node(i[0], i[2]));
        }
        //��ȯ�迭 ����
        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] start = new int[n+1];
        //�迭���� �ƽ��� �ʱ�ȭ
        Arrays.fill(startA, MAX);
        Arrays.fill(startB, MAX);
        Arrays.fill(start, MAX);
        //���ͽ�Ʈ�� ��� ����
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
	//���ͽ�Ʈ�� �˰��� �켱���� ť�� ��
	private int[] dijkstra(int start, int[] costs) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		costs[start] = 0;
		
		while(!pq.isEmpty()) {
			Node row = pq.poll();
			int rowIndex = row.index;
			int rowCost = row.cost;
			//�ο����� �� ũ�� ������Ʈ�� �ʿ� ����
			if(rowCost > costs[rowIndex]) continue;
			
			ArrayList<Node> nodes = graph.get(rowIndex);
			for(Node node : nodes) {
				int cost = costs[rowIndex] + node.cost;
				//���� �ڽ�Ʈ���� ������ �迭�� ������Ʈ���ְ�, ť�� �Է�
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
		//��������
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
}
