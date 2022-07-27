package step21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main1992 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer buf = new StringBuffer();
	static int[][] arr = null;
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i< N; i++) {
			String s = br.readLine();
			for(int j=0; j < N;j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		fun(0,0,N);
		bw.write(buf.toString());
		bw.flush();
		bw.close();
	}
	
	public static void fun(int startY, int startX , int n) {
		//하나라도 다른게 있나 검사
		int rowSum = 0;
		for (int i = startY; i < startY + n; i++) {
			for (int j = startX; j < startX + n; j++) {
				rowSum += arr[i][j];
			}
		}
		//모두 0 혹은 N*N일경우
		if(rowSum == 0) {
			buf.append("0");
			return;
		} else if(rowSum == n*n) {
			buf.append("1");
			return;
		}
		
		buf.append("(");
		fun(startY , startX , n/2);
		fun(startY , startX + n/2 , n/2);
		fun(startY + n/2, startX , n/2);
		fun(startY + n/2, startX + n/2, n/2);
		buf.append(")");
	}
}
