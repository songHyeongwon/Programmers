package step33;

import java.util.Scanner;

public class Main13305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] line = new long[N-1];
		long[] city = new long[N];
		
		for (int i = 0; i < line.length; i++) {
			line[i] = sc.nextLong();
		}
		for (int i = 0; i < city.length; i++) {
			city[i] = sc.nextLong();
		}
		
		long sum = 0; //합산된 값
		long beforCity = city[0];
		for (int i = 0; i < city.length-1; i++) {
			if(city[i] < beforCity) {
				beforCity = city[i];
			}
			sum += (beforCity * line[i]);
		}
		System.out.println(sum);
		sc.close();
	}
}
