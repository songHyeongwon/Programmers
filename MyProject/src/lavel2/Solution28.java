package lavel2;

import java.util.LinkedList;
import java.util.Queue;
//https://programmers.co.kr/learn/courses/30/lessons/86971
public class Solution28 {
	public static void main(String[] args) {
		int[][] arr = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		System.out.println(new Solution28().solution(9, arr));
	}
	
	public int solution(int n, int[][] wires) {
        int answer = n;
        
        for(int i = 0; i < wires.length; i++) {
        	answer = Math.min(answer, getAnswer(i, wires , n));
        }
        
        return answer;
    }

	private int getAnswer(int index, int[][] wires, int n) {
		// TODO Auto-generated method stub
		int temp1 = wires[index][0];//4
		int temp2 = wires[index][1];//7
		int count1 = getBfs(new boolean[n+1], temp1 , wires , index);
		int count2 = getBfs(new boolean[n+1], temp2 , wires , index);
		return Math.abs(count1 - count2);
	}

	private int getBfs(boolean[] bs, int temp, int[][] wires, int index) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(temp);
		bs[temp] = true;
		
		while (!q.isEmpty()) {
			temp = q.poll();
			for (int i = 0; i < wires.length; i++) {
				if (wires[i][0] == temp && !bs[wires[i][1]] && i != index) {
					q.add(wires[i][1]);
					bs[wires[i][1]] = true;
				}
				if (wires[i][1] == temp && !bs[wires[i][0]] && i != index) {
					q.add(wires[i][0]);
					bs[wires[i][0]] = true;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < bs.length; i++) {
			if(bs[i]) count++;
		}
		return count;
	}
}
