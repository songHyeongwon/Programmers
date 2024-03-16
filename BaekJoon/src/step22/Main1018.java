package step22;

import java.util.Scanner;

public class Main1018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[][] arr = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String a = sc.next();
			for (int j = 0; j < M; j++) {
				if(a.charAt(j) == 'W') {
					arr[i][j] = true;
				}
			}

		}
		sc.close();
		int minCnt = 8*8;
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				minCnt = Math.min(minCnt, getCount(arr, i, j));
			}
		}
		System.out.println(minCnt);
	}

	private static int getCount(boolean[][] arr, int y, int x) {
		int result = 0;
		boolean temp = arr[y][x];
		for (int i = 0; i < 8; i++) {
			temp = !temp;
			for (int j = 0; j < 8; j++) {
				temp = !temp;
				if(i == 0 && j == 0) continue;
				if(arr[y+i][x+j] != temp) {
					result++;
				}
			}
		}
		return Math.min(result, 64-result);
	}
}
