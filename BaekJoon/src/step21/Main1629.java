package step21;

import java.util.Scanner;
//https://st-lab.tistory.com/237
public class Main1629 {
	static long C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		C = sc.nextLong();
		
		System.out.println(pow(A, B));
	}
	public static long pow(long A , long exponent) {
		
		//������ 1�� ��� A^1 A�� �״�� ����
		if(exponent == 1) {
			return A % C;
		}
		// ������ ���ݿ� �ش��ϴ� A^(exponent / 2) �� ���Ѵ�.
		long temp = pow(A, exponent / 2);
		/*
		 * ���� ������ Ȧ �� ���ٸ�
		 * A^(exponent / 2) * A^(exponent / 2) * A �̹Ƿ�
		 * A�� �� �� �� �����־�� �Ѵ�.
		 * 
		 * ex) A^9 = A^4 * A^4 * A
		 */
		if(exponent % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C; 
	}
}
