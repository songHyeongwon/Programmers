package step22;

import java.util.Scanner;

public class Main2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int sum = 0;//гу╟Х
		
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		sum = getSum(arr , n ,m);
		
		System.out.println(sum);
		
		sc.close();
	}

	static int getSum(int[] arr, int n, int m) {
		// TODO Auto-generated method stub
		int result = 0;
		
		for (int i = 0; i < n-2; i++) {
			for (int j = i+1; j < n-1; j++) {
				for (int k = j+1; k < n; k++) {
					int tempSum = arr[i] + arr[j] + arr[k];
					if(tempSum == m) return tempSum;
					if(tempSum < m) {
						result = Math.max(result, tempSum);
					}
				}
			}
		}
		
		return result;
	}
}
