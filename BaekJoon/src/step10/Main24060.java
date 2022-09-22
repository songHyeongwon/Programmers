package step10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main24060 {
	static int dpCnt = 0;
	static int K = 0;
	static int[] arr = null;
	static int result = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		K = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		merge_sort(0, n-1);
		System.out.println(result);
		sc.close();
	}
	public static void merge_sort(int p, int r) {
		if(p < r) {
			int q = (p + r) /2;
			merge_sort(p, q);
			merge_sort(q+1, r);
			merge(p, q, r);
		}
	}
	public static void merge(int p, int q, int r) {
		int i = p;
		int j = q+1;
		ArrayList<Integer> numList = new ArrayList<>();
		while (i <= q && j <= r) {
			if(arr[i] <= arr[j]) {
				numList.add(arr[i]);
				i++;
			} else {
				numList.add(arr[j]);
				j++;
			}
		}
		while(i <= q) {
			numList.add(arr[i]);
			i++;
		}
		while(j <= r) {
			numList.add(arr[j]);
			j++;
		}
		i = p;
		int t = 0;
		while(i <= r) {
			arr[i] = numList.get(t);
			dpCnt++;
			if(dpCnt == K) {
				result = arr[i];
			}
			i++;
			t++;
		}
	}
}
