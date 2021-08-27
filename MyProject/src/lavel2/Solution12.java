package lavel2;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12978?language=java
//��ó: https://bumbums.tistory.com/4 [�������� �ڵ�������]
public class Solution12 {
	public static void main(String[] args) {
		int N = 6;
		int K = 4;
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		System.out.println(new Solution12().solution(N, road, K));
	}
	
	public int solution(int n, int[][] road, int k) {
		Graph g= new Graph(n);
		for (int i = 0; i < road.length; i++) {
			g.input(road[i][0], road[i][1], road[i][2]);
		}
		
		int[] result = g.dijkstra(1);
		int answer = 0;
		for (int i = 1; i < result.length; i++) {
			if(result[i] <= k) answer++;
		}
		return answer;
    }
	class Graph {
		private int n; //������ ��
		private int maps[][]; //���鰣�� ����ġ ���庯��
		
		public Graph(int n) {
			this.n = n;
			maps= new int[n+1][n+1];
		}
		public void input(int i , int j, int w) {
			if(maps[i][j] > 0 && maps[j][i] > 0) {
				maps[i][j] = Math.min(maps[i][j], w);
				maps[j][i] = Math.min(maps[j][i], w);
			} else {
				maps[i][j] = w;
				maps[j][i] = w;
			}
		}
		public int[] dijkstra(int v) {
	        int distance[] = new int[n+1];          //�ִ� �Ÿ��� ������ ����
	        boolean[] check = new boolean[n+1];     //�ش� ��带 �湮�ߴ��� üũ�� ����
			
	        //distance�� �ʱ�ȭ.
	        for(int i=1;i<n+1;i++){
	            distance[i] = Integer.MAX_VALUE;
	        }
	        
	        //���۳�尪 �ʱ�ȭ
	        distance[v] = 0;
	        check[v] = true;
	        
	        //������ distance����
	        for (int i = 1; i < n+1; i++) {
				if(!check[i] && maps[v][i] != 0) {
					distance[i] = maps[v][i];
				}
			}
	        
	        for(int a=0;a<n-1;a++) {
	            //������ ��� ��尡 true�ɶ����� �ε�
	            //��尡 n�� ���� �� ���ͽ�Ʈ�� ���ؼ� �ݺ����� n-1���̸� �ȴ�.
	            //������ ������ ������ ��尡 ��� true���� Ȯ���ϴ� ������ �����ص� �ȴ�.
	        	int min = Integer.MAX_VALUE;
	        	int min_index = -1;
	        	
	        	//�ּҰ� ã��
	        	for(int i =1; i< n+1; i++) {
	        		if(!check[i] && distance[i] != Integer.MAX_VALUE) {
	        			if(distance[i] < min) {
	        				min = distance[i];
	        				min_index = i;
	        			}
	        		}
	        	}
	        	
	        	check[min_index] = true;
	        	for(int i =1; i< n+1; i++) {
	        		if(!check[i] && maps[min_index][i] != 0) {
	        			if(distance[i] > distance[min_index] + maps[min_index][i]) {
	        				distance[i] = distance[min_index] + maps[min_index][i];
	        			}
	        		}
	        	}
	        }
	        return distance;
		}
	}
}
