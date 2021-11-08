package lavel1;
//https://programmers.co.kr/learn/courses/30/lessons/12950
public class Solution11 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		  
		for(int i=0;i<arr1.length;i++){
			for(int k=0;k<arr1[i].length;k++){
				answer[i][k]=arr1[i][k]+arr2[i][k];
			}
		}
		  
		  
		return answer;
	}
}
