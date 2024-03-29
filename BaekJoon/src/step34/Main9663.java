package step34;

import java.util.Scanner;

public class Main9663 {
	static int N;
	static int[] arr;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		getDfs(0);
		sc.close();
		System.out.println(count);
	}

	private static void getDfs(int dep) {
		// TODO Auto-generated method stub
		if(N == dep) {
			count++;
			return;
		}
		
		for(int i =0; i < N; i++) {
			arr[dep] = i;
			if(isCheck(dep)) {
				getDfs(dep+1);
			}
		}
	}
	
	private static boolean isCheck(int col) {
		for(int i =0; i <col; i++) {
			if(arr[col] == arr[i]) {
				return false;
			} else
			if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
