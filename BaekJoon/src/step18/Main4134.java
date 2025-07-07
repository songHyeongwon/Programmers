package step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4134 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sbd = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			long prime = Long.parseLong(br.readLine());
			if (prime == 0 | prime == 1) {
				sbd.append(2).append("\n");
				continue; 
			}

			while (true) {
				long cnt = 0;
				for (long j = 2; j <= Math.sqrt(prime); j++) {
					if (prime % j == 0) {
						cnt++;
						break;
					}
				}

				if (cnt == 0) {
					sbd.append(prime).append("\n");
					break;
				}
				prime++;
			}
		}
		System.out.println(sbd);
	}
}
