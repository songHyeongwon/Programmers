package step10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main9506 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == -1)
				break;
			getSum(n);
		}
		sc.close();
	}

	public static void getSum(int n) {
		int temp = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				list.add(i);
				temp += i;
			}
		}
		if (n == temp) {
			// 6 = 1 + 2 + 3
			System.out.print(String.format("%d = ", n));
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				result.append(list.get(i));
				if (i < list.size() - 1) {
					result.append(" + ");
				}
			}
			System.out.println(result.toString());
		} else {
			System.out.println(String.format("%d is NOT perfect.", n));
		}
	}
}
