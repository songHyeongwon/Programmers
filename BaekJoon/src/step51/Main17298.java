package step51;

import java.util.Scanner;
import java.util.Stack;

public class Main17298 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {
			/*
			 * ������ ������� �����鼭 
			 * ���� ���Ұ� ������ �� �� ���Ұ� ����Ű�� ���Һ��� ū ���
			 * �ش� ������ ������ �� ���� stack�� ���Ҹ� pop�ϸ鼭
			 * �ش� �ε����� ���� ���� ���ҷ� �ٲ��ش�. 
			 */
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i); //�ε����� ��´�.
		}
		//�������� -1�� ����
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			buf.append(arr[i]).append(' ');
		}
		System.out.println(buf.toString());
		
		/*���� Ǯ�� �ּ�
		 * StringBuffer buf = new StringBuffer();
		buf.insert(0, "-1 ");
		for (int i = arr.length -2 ; i >= 0; i--) {
			int insertNum = -1;//�� ����
			for (int j = i + 1 ; j < arr.length; j++) {
				stack.add(arr[j]);//�ڿ��� i������ �� ����
			}
			while(!stack.isEmpty()) {
				int pop = stack.pop();
				if(arr[i] < pop) {
					insertNum = pop;
				}
			}
			buf.insert(0, insertNum + " ");
		}
		System.out.println(buf.toString());*/
	}
}
