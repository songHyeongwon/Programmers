package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11054 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dpUp = new int[N];
		int[] dpDw = new int[N];
		int max = 0;
		
		StringTokenizer token = new StringTokenizer(br.readLine() , " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		//가장 긴 증가하는 수열
		for (int i = 0; i < dpUp.length; i++) {
			dpUp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && dpUp[i] < dpUp[j] +1) {
					dpUp[i] = dpUp[j] + 1;
				}
			}
		}
		//가장 긴 감소하는수열
		for (int i = N - 1; i >= 0; i--) {
			dpDw[i] = 1;
			for (int j = N-1; j > i; j--) {
				if(arr[j] < arr[i] && dpDw[i] < dpDw[j] +1) {
					dpDw[i] = dpDw[j] + 1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dpUp[i] + dpDw[i]);
		}
		System.out.println(max -1);//같은자리 중복되서 제거
	}
}
