package lavel3;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42861
public class Solution11 {
	public static void main(String[] args) {
		int n = 5;
		int[][] costs = {{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}};
		
		System.out.println(new Solution11().solution(n, costs));
	}
	int[] parent = null;//최상이 노드 배열
	
	public int solution(int n, int[][] costs) {
		//크루스칼 알고리즘(Kruskal Algorithm) 가장 적은 비용으로 모든 노드를 연결하기 위해서 사용하는 알고리즘이다.
		Arrays.sort(costs, (a,b)-> a[2]-b[2]);//금액순 정렬
		parent = new int[n];
		for(int i =0; i<n; i++) {
			parent[i] = i;//최상의 노드 초기화 처음은 자기 자신
		}
		int answer = 0;
		for(int[] row : costs) {
			int fisrtParent = getParent(row[0]);
			int lastParent = getParent(row[1]);
			//연결이 안된 섬
			if(fisrtParent != lastParent) {
				parent[lastParent] = fisrtParent;
				answer += row[2];
			}
		}
        return answer;
    }

	private int getParent(int i) {
		if(parent[i] == i) {
			return parent[i];
		} else {
			parent[i] = getParent(parent[i]);
			return parent[i];
		}
	}
}
