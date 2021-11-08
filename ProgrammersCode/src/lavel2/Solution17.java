package lavel2;

import java.util.LinkedList;
import java.util.Queue;
//https://programmers.co.kr/learn/courses/30/lessons/1844?language=java
public class Solution17 {
	public static void main(String[] args) {
		int[][] arr= {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}};
		int[][] arr2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		System.out.println(new Solution17().solution(arr));
	}
	
	public int solution(int[][] maps) {
		int [] xIndex = {1, 0, -1, 0};
		int [] yIndex = {0, 1, 0, -1};
		int x = maps[0].length;
		int y = maps.length;
		boolean[][] check = new boolean[y][x];
        int answer = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {0,0});
        check[0][0] = true;
        
        while (!queue.isEmpty()) {
        	int[] a = queue.poll();
        	int yPoint = a[0];
        	int xPoint = a[1];
        	for(int i = 0; i <xIndex.length; i++) {
        		if(
    				yPoint + yIndex[i] >=0 && 
    				yPoint + yIndex[i] < y &&  
    				xPoint + xIndex[i] >=0 && 
    				xPoint + xIndex[i] < x &&
    				maps[yPoint + yIndex[i]][xPoint + xIndex[i]] > 0 &&
    				!check[yPoint + yIndex[i]][xPoint + xIndex[i]]) 
        		{
        			maps[yPoint + yIndex[i]][xPoint + xIndex[i]] = maps[yPoint][xPoint] +1;
        			check[yPoint + yIndex[i]][xPoint + xIndex[i]] = true;
        			queue.add(new int[] {yPoint + yIndex[i], xPoint + xIndex[i]});
        		}
        	}
		}
        answer = maps[y-1][x-1];
        if(answer <= 1) {
        	answer = -1;
        }
        
        return answer;
    }
}
