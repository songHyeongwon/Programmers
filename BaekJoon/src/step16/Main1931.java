package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1931 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine() , " ");
			arr[i][0] = Integer.parseInt(token.nextToken());
			arr[i][1] = Integer.parseInt(token.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int count = 0;
		int thisEndTime = 0;
		
		for (int i = 0; i < arr.length; i++) {
			//System.out.println(Arrays.toString(arr[i]));
			if(thisEndTime <= arr[i][0]) {
				thisEndTime = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}
}
