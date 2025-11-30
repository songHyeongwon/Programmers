package step34;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2580 {
	static int[][] arr = new int[9][9];
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static boolean printlng = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int a = sc.nextInt();
				arr[i][j] = a;
				if (a == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		sc.close();

		getDfs(0, 0);
	}

	private static void printArr() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void getDfs(int idx, int count) {
		// TODO Auto-generated method stub
		if (list.size() == count) {
			printArr();
			printlng = true;
			// 다른케이스들은 출력되지 못하게 막음
		}
		// 다른케이스들은 여기서 출력 막힘
		if (printlng)
			return;

		int y = list.get(idx)[0];
		int x = list.get(idx)[1];

		for (int i = 1; i <= 9; i++) {
			if (isCheck(y, x, i)) {
				arr[y][x] = i;
				getDfs(idx + 1, count + 1);
				arr[y][x] = 0;
			}
		}

	}

	public static boolean isCheck(int y, int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (arr[y][i] == num)
				return false;
			if (arr[i][x] == num)
				return false;
		}

		int set_y = (y / 3) * 3;
		int set_x = (x / 3) * 3;

		for (int i = set_y; i < set_y + 3; i++) {
			for (int j = set_x; j < set_x + 3; j++) {
				if (arr[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
