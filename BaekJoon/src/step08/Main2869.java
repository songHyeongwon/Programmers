package step08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2869 {
	public static void main(String[] args) throws IOException {
		// 빠른 입출력 필수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int result = (V - B) / (A - B);

		if ((V - B) % (A - B) != 0) {
			result++;
		}
		System.out.println(result);
	}
}
