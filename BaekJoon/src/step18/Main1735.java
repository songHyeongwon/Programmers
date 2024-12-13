package step18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1735 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int numerator = A * D + B * C;
		int denominator = B * D;

		int mod = gcd(numerator, denominator);
		numerator /= mod;
		denominator /= mod;

		bw.write(numerator + " " + denominator + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	// ��Ŭ���� ȣ����
	public static int gcd(int a, int b) {
		// a�� b���� ū ��쿡 ���ؼ� ��Ŭ���� ȣ���� ����.
		if (a <= b) {
			int temp = a;
			a = b;
			b = temp;
		}

		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
