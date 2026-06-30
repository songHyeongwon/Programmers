package OUTTER;

import java.io.*;

public class Main2742 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// ����
		int t = Integer.parseInt(br.readLine());

		for (int i = t; i > 0; i--) {
			bw.write(i + "\n");
		}

		bw.close();// ��Ʈ���� ����
		br.close();
	}
}
