package step34;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main15652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		getDfs(n, m, bw, "", 1);

		br.close();
		bw.close();
	}

	private static void getDfs(int n, int m, BufferedWriter bw, String buf, int befor) throws IOException {
		if (m == 0) {
			bw.write(buf.trim() + "\n");
			return;
		}
		for (int i = befor; i <= n; i++) {
			if (i >= befor) {
				getDfs(n, m - 1, bw, buf + " " + i, i);
			}
		}
	}
}
