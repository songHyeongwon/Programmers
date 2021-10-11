package step05;

import java.util.Scanner;

public class Main4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] avgArr = new double[n];
		
		for (int i = 0; i < avgArr.length; i++) {
			int row = sc.nextInt();
			double[] rowArr = new double[row];
			double ave = 0;
			
			for (int j = 0; j < row; j++) {
				rowArr[j] = sc.nextDouble();
				ave += rowArr[j];
			}
			ave = ave / row;
			int count = 0;
			for (int j = 0; j < row; j++) {
				if( ave < rowArr[j]) {
					count++;
				}
			}
			
			avgArr[i] = ((double)count / (double)row) * 100;
		}
		for (int i = 0; i < avgArr.length; i++) {
			System.out.println(String.format("%.3f", avgArr[i]) +"%");
		}
		sc.close();
	}
}
