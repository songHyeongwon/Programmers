package lavel2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/81302
public class Solution22 {
	public static void main(String[] args) {
		String[][] arr = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(Arrays.toString(new Solution22().solution(arr)));
	}
	
	public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = getCheckPlaces(places[i]);//방 별로 체크
        }
        
        return answer;
    }
	/*{
	 * "POOOP", 
	 * "OXXOX", 
	 * "OPXPX", 
	 * "OOXOX", 
	 * "POXXP"}*/
	//좌표가 p일때 맨헤튼거리 체크
	private int getCheckPlaces(String[] strings) {
		for(int i =0; i<strings.length; i++) {
			for(int j =0; j<strings[i].length(); j++) {
				//사람일경우 자리 체크
				if(strings[i].charAt(j) == 'P' && !isManCheck(strings ,i,j)) {
					return 0;
				}
			}
		}
		return 1;
	}
	//좌표점에 사람의 거리두기를 모두 체크한다.
	private boolean isManCheck(String[] string, int y, int x) {
		// TODO Auto-generated method stub
		Queue<int []> queue = new LinkedList<int[]>();
		queue.add(new int[]{y, x, 0});//y축 x 축 1은 =p, 0은 조회순번
		int [] xIndex = {1, 0, -1, 0};
		int [] yIndex = {0, 1, 0, -1};
		boolean[][] check = new boolean[string.length][string[0].length()];
		check[y][x] = true;
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
        	int yPoint = a[0];
        	int xPoint = a[1];
        	int searchCnt = a[2];
        	if(searchCnt == 2) return true;
        	
			for(int i = 0; i<xIndex.length; i++) {
				if(
					yPoint + yIndex[i] >=0 && 
					yPoint + yIndex[i] < string.length &&  
					xPoint + xIndex[i] >=0 && 
					xPoint + xIndex[i] < string[0].length() &&
					!check[yPoint + yIndex[i]][xPoint + xIndex[i]]) {
					char thisChar = string[yPoint + yIndex[i]].charAt(xPoint + xIndex[i]);
					if(thisChar == 'P') {
						return false;
					}
					if(thisChar == 'O') {
						check[yPoint + yIndex[i]][xPoint + xIndex[i]] = true;
						queue.add(new int[]{yPoint + yIndex[i], xPoint + xIndex[i], searchCnt+1});
					}
				}
			}
		}
		return true;
	}
}
