package lavel3;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/43105?language=java
public class Solution18 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		System.out.println(new Solution18().solution(triangle));
	}
	
	
	public int solution(int[][] triangle) {
        //���������� +1��ŭ
        int[][] newTriangle = new int[triangle[triangle.length-1].length][triangle[triangle.length-1].length];
        //���������� �ִ´�
        for(int i =0; i < newTriangle[0].length; i++) {
        	newTriangle[newTriangle.length-1][i] = triangle[triangle.length-1][i];
        }
        //�������� ���� ū���� �ִ´�.
        for(int i = triangle.length-1; i >= 1; i--) {
        	for (int j = 0; j < triangle[i].length-1; j++) {
        		newTriangle[i-1][j] = Math.max(newTriangle[i][j] + triangle[i-1][j] , newTriangle[i][j+1] + triangle[i-1][j]);
			}
        }
        //üũ�� ���
        /*for (int i = 0; i < newTriangle.length; i++) {
			System.out.println(Arrays.toString(newTriangle[i]));
		}*/
        return newTriangle[0][0];
    }
}
