package step14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main15650 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		for (int i = 1<<n+1; i >= 1<<n ; i--) {
			if(Integer.bitCount(i) == m + 1) {
				String temp = Integer.toBinaryString(i);
				for (int j = 1; j < temp.length(); j++) {
					if(temp.charAt(j) == '1') {
						bw.write(j + " ");
					}
				}
				bw.write("\n");
			}
		}
		br.close();
		bw.close();
	}
}
