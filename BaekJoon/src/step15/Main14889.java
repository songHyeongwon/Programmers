package step15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14889 {
	static int minPoint = Integer.MAX_VALUE;
	static int[][] arr = null;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//¼±¾ð
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine() , " ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		getMinPoint(n);
		bw.write(minPoint+"");
		br.close();
		bw.close();
	}
	private static void getMinPoint(int n) {
		for(int i = 1<<n; i < 1<<(n+1); i++) {
			if(Integer.bitCount(i) == n/2 + 1) {
				String temp = Integer.toBinaryString(i);
				int timA = getTimPoint(temp.substring(1) , '0');
				int timB = getTimPoint(temp.substring(1) , '1');
				minPoint = Math.min(minPoint, Math.abs(timA-timB));
			}
		}
	}
	private static int getTimPoint(String temp, char c) {
		int result = 0;
		for (int i = 0; i < temp.length(); i++) {
			for (int j = 0; j < temp.length(); j++) {
				if( i != j && temp.charAt(i) == c && temp.charAt(j) == c) {
					result += arr[i][j];
				}
			}
		}
		return result;
	}
}
