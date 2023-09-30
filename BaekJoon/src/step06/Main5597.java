package step06;

import java.util.Scanner;

public class Main5597 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stCnt = 30;
		boolean[] isCheck = new boolean[stCnt];
		for (int i = 0; i < isCheck.length - 2; i++) {
			isCheck[sc.nextInt() - 1] = true;
		}
		for (int i = 0; i < isCheck.length; i++) {
			if(!isCheck[i]) System.out.println(i+1);
		}
		sc.close();
	}
}
