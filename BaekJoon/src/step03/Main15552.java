package step03;

import java.io.*;

public class Main15552 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// 선언
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String row = br.readLine();
			String[] rowSplit = row.split(" ");
			bw.write(Integer.parseInt(rowSplit[0]) + Integer.parseInt(rowSplit[1]) + "\n");
		}
		bw.close();// 스트림을 닫음
		br.close();

	}
}
