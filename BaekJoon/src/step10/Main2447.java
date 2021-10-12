package step10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2447 {
	static int[][] arr = null;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		star(n, 0 ,0);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				bw.write(arr[i][j]==1?"*" : " ");
			}
			bw.write("\n");
		}
		bw.close();//스트림을 닫음
		br.close();
	}
	private static void star(int n, int x, int y) {
		// TODO Auto-generated method stub
		if(n == 1) return;
		int k = n/3;				
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if((i/k) == 1 && (j/k) == 1) {
					arr[y+i][x+j] = 0;
				} else {
					arr[y+i][x+j] = 1;
				}
			}
		}
		
		for (int i = y; i < n+y; i++) {
			for (int j = x; j < n+x; j++) {
				if(i % k == 0 && j % k == 0 && arr[i][j] == 1) {
					star(k, j , i);
				}
			}
		}
	}
}
