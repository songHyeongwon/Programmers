package step18;

import java.util.Scanner;

public class Main1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String[] arr = str.split("-");
		int sum = 0;//Integer.parseInt(arr[0]);
		for (int i = 0; i < arr.length; i++) {
			String[] tempArr = arr[i].split("[+]");
			int tempSum = 0;
			for (int j = 0; j < tempArr.length; j++) {
				tempSum += Integer.parseInt(tempArr[j]);
			}
			if(i == 0) {
				sum = tempSum;
			} else {
				sum -= tempSum;
			}
		}
		System.out.println(sum);
		sc.close();
	}
}
