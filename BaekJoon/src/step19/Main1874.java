package step19;

import java.util.Scanner;
import java.util.Stack;

public class Main1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int idx = 1;
		Stack<Integer> stack = new Stack<Integer>();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		StringBuffer buf = new StringBuffer();
		
		for (int i = 0; i < arr.length; i++) {
			if(stack.contains(arr[i])) {
				//있다면
				while(stack.peek() != arr[i]) {
					//System.out.println("-");
					buf.append("-\n");
					stack.pop();
				}
				//System.out.println("-");
				buf.append("-\n");
				stack.pop();
			} else {
				//없다면
				if(idx > arr[i]) {//인덱스보다 작다면 이미 틀렸다
					System.out.println("NO");
					return;
				} else {
					while(idx <= arr[i]) {
						//System.out.println("+");
						buf.append("+\n");
						stack.add(idx++);
					}
					i--;//입력해줬으니 i를 줄인다.
				}
			}

		}
		System.out.println(buf.toString());
	}
}
