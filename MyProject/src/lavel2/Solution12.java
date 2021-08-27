package lavel2;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12978?language=java
//출처: https://bumbums.tistory.com/4 [범범스의 코딩놀이터]
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
		private int n; //노드들의 수
		private int maps[][]; //노드들간의 가중치 저장변수
		
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
	        int distance[] = new int[n+1];          //최단 거리를 저장할 변수
	        boolean[] check = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
			
	        //distance값 초기화.
	        for(int i=1;i<n+1;i++){
	            distance[i] = Integer.MAX_VALUE;
	        }
	        
	        //시작노드값 초기화
	        distance[v] = 0;
	        check[v] = true;
	        
	        //연결노드 distance갱신
	        for (int i = 1; i < n+1; i++) {
				if(!check[i] && maps[v][i] != 0) {
					distance[i] = maps[v][i];
				}
			}
	        
	        for(int a=0;a<n-1;a++) {
	            //원래는 모든 노드가 true될때까지 인데
	            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
	            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
	        	int min = Integer.MAX_VALUE;
	        	int min_index = -1;
	        	
	        	//최소값 찾기
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
