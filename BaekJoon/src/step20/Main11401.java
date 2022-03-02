package step20;

import java.util.Scanner;

public class Main11401 {
	private static final long P = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long K = sc.nextLong();
		sc.close();
		//����
		long nFac = getFactorial(N);
		//�и�
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
		//������ 1�ϰ�� base % P ����
		if(expo == 1) {
			return base % P;
		}
		
		//������ ���ݿ� �ش��ϴ� base^(expo / 2) �� ���Ѵ�.
		long temp = pow(base, expo /2);
		
		if(expo % 2 == 1) {
			return (temp * temp % P) * base % P;
		}
		return temp * temp % P;
	}
}
