package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {
	public static void main(String[] args) throws Exception{
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp != 0) {
				stack.add(temp);
				sum += temp;
			} else {
				sum -= stack.pop();
			}
		}
		System.out.println(sum);
	}
}
