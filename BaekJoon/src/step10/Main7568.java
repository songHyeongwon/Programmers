package step10;

import java.util.Scanner;

public class Main7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < arr.length; i++) {
			int rank = 1;
			for (int j = 0; j < arr.length; j++) {
				if(i!=j) {
					if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
						rank++;
					}
				}
			}
			System.out.print(rank+" ");
		}
		
	}
}