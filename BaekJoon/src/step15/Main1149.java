package step15;

import java.util.Arrays;
import java.util.Scanner;

public class Main1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = new int[n][3];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		
		for (int i = n-1; i > 0; i--) {
			arr[i-1][0] += Math.min(arr[i][1] , arr[i][2]);
			arr[i-1][1] += Math.min(arr[i][0] , arr[i][2]);
			arr[i-1][2] += Math.min(arr[i][0] , arr[i][1]);
		}
		Arrays.sort(arr[0]);
		System.out.println(arr[0][0]);
		
		sc.close();
	}
}
