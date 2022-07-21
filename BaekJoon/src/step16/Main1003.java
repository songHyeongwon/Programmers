package step16;

import java.util.Scanner;

public class Main1003 {
	public static void main(String[] args) {
		int[][] arr = new int[41][2];
		//0ÀÇ°¹¼ö
		//1ÀÇ°¹¼ö
		arr[0][0] = 1;
		arr[1][1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i][0] = arr[i-1][0] + arr[i-2][0];
			arr[i][1] = arr[i-1][1] + arr[i-2][1];
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int next = sc.nextInt();
			System.out.println(arr[next][0] + " " + arr[next][1]);
		}
		sc.close();
	}
}
