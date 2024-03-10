package step20;

import java.util.Scanner;

public class Main11401 {
	private static final long P = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long K = sc.nextLong();
		sc.close();
		//분자
		long nFac = getFactorial(N);
		//분모
		long denom = getFactorial(K) * getFactorial(N-K) % P;
		
		System.out.println(nFac * pow(denom , P -2) % P);
		
	}
	private static long getFactorial(long n) {
		long result = 1L;
		while(n > 1) {
			result = (result * n) % P;
			n--;
		}
		return result;
	}
	private static long pow(long base, long expo) {
		//지수가 1일경우 base % P 리턴
		if(expo == 1) {
			return base % P;
		}
		
		//지수의 절반에 해당하는 base^(expo / 2) 를 구한다.
		long temp = pow(base, expo /2);
		
		if(expo % 2 == 1) {
			return (temp * temp % P) * base % P;
		}
		return temp * temp % P;
	}
}
