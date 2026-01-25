package OUTTER;

import java.io.*;

public class Main2741 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= t ; i++) {
			bw.write(i + "\n");
		}
		bw.close();//스트림을 닫음
		br.close(); 
	}
}
