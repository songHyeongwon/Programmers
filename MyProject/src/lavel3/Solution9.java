package lavel3;

import java.util.ArrayList;

//https://programmers.co.kr/learn/courses/30/lessons/12946?language=java
public class Solution9 {
	public static void main(String[] args) {
		new Solution9().solution(2);
	}
	
	static ArrayList<int[]> list = new ArrayList<int[]>();
	
	public int[][] solution(int n) {
        //n개 원판을 1->3으로 2를 거쳐서
		move(n, 1, 3, 2);
        
		int[][] answer = new int[list.size()][2];
		
		for(int i = 0; i< list.size(); i++) {
			answer[i][0] = list.get(i)[0];
			answer[i][1] = list.get(i)[1];
		}
		System.out.println(list.toString());
        return answer;
    }
	
	public void move(int n, int as, int to, int is) {
		int[] moves = {as , to};
		//System.out.println("n = " +n+ " "+as + " / " + to + " is =" +is);
		if(n==1) {
			list.add(moves);
			return;
		}
		move(n-1, as, is, to);
		list.add(moves);
		move(n-1, is, to, as);
	}
}
