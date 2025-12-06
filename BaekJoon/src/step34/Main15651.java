package step34;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main15651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		getDfs(n, m, bw, "");

		br.close();
		bw.close();
	}

	private static void getDfs(int n, int m, BufferedWriter bw, String buf) throws IOException {
		if (m == 0) {
			bw.write(buf.trim() + "\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			getDfs(n, m - 1, bw, buf + " " + i);
		}
	}
}
