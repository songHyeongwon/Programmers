package step34;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// ¼±¾ð

		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		boolean[] isCheck = new boolean[n + 1];

		getOut(n, m, isCheck, bw, new ArrayList<Integer>());

		br.close();
		bw.close();
	}

	private static void getOut(int n, int m, boolean[] isCheck, BufferedWriter bw, ArrayList<Integer> list)
			throws IOException {
		// TODO Auto-generated method stub
		if (m == 0) {
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i) + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = 1; i < isCheck.length; i++) {
			if (!isCheck[i]) {
				isCheck[i] = true;
				list.add(i);
				getOut(n, m - 1, isCheck, bw, list);
				isCheck[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}
