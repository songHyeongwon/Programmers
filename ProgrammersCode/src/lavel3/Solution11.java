package lavel3;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42861
public class Solution11 {
	public static void main(String[] args) {
		int n = 5;
		int[][] costs = {{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}};
		
		System.out.println(new Solution11().solution(n, costs));
	}
	int[] parent = null;//�ֻ��� ��� �迭
	
	public int solution(int n, int[][] costs) {
		//ũ�罺Į �˰���(Kruskal Algorithm) ���� ���� ������� ��� ��带 �����ϱ� ���ؼ� ����ϴ� �˰����̴�.
		Arrays.sort(costs, (a,b)-> a[2]-b[2]);//�ݾ׼� ����
		parent = new int[n];
		for(int i =0; i<n; i++) {
			parent[i] = i;//�ֻ��� ��� �ʱ�ȭ ó���� �ڱ� �ڽ�
		}
		int answer = 0;
		for(int[] row : costs) {
			int fisrtParent = getParent(row[0]);
			int lastParent = getParent(row[1]);
			//������ �ȵ� ��
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
