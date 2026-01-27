package OUTTER;

import java.util.Scanner;

public class Main2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[][] arr = new int[15][15];
		//최하층 초기화
		for (int i = 0; i < arr[0].length; i++) {
			arr[0][i] = i+1;
		}
		//각 층마다 값 누적
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int sum = 0;
				for (int k = 0; k <= j ; k++) {
					sum += arr[i-1][k];
				}
				arr[i][j] = sum;
			}
		} 
		
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(arr[k][n-1]);
		}
		sc.close();
	}
}
