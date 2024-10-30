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
			 * 스택이 비어있지 않으면서 
			 * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
			 * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
			 * 해당 인덱스의 값을 현재 원소로 바꿔준다. 
			 */
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i); //인덱스를 담는다.
		}
		//남은스택 -1로 변경
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			buf.append(arr[i]).append(' ');
		}
		System.out.println(buf.toString());
		
		/*이전 풀이 주석
		 * StringBuffer buf = new StringBuffer();
		buf.insert(0, "-1 ");
		for (int i = arr.length -2 ; i >= 0; i--) {
			int insertNum = -1;//들어갈 숫자
			for (int j = i + 1 ; j < arr.length; j++) {
				stack.add(arr[j]);//뒤에서 i전까지 다 담음
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
