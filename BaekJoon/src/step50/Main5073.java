package step50;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main5073 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[3];

		// 무한루프
		while (true) {
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			arr[2] = sc.nextInt();

			// 0 0 0 입력시 무한루프 종료
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				break;

			// 정렬
			Arrays.sort(arr);

			if (arr[2] >= arr[0] + arr[1]) {
				System.out.println("Invalid");
			} else if (arr[0] == arr[1] && arr[1] == arr[2]) {
				System.out.println("Equilateral");
			} else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		}
		sc.close();
	}
}
