package OUTTER;

import java.util.Arrays;
import java.util.Scanner;

public class Main2981 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int gap = arr[1]  - arr[0];
		
		for (int i = 2; i < N; i++) {
			gap = gcd(gap , arr[i] - arr[i-1]);
		}
		
		for (int i = 2; i <= gap; i++) {
			if(gap % i == 0) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	} 
	//최대공약수
	private static int gcd(int a, int b) {
		while(b != 0) {
			int r =a % b;
			a=b;
			b=r;
		}
		return a;
	}
}
