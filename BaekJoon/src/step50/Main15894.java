package step50;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15894 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		System.out.print(4 * n);
	}
}
