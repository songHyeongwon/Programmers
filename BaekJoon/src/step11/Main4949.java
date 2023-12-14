package step11;

import java.util.Scanner;
import java.util.Stack;

public class Main4949 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		
		while(true) {		
			s = sc.nextLine();
			if(s.equals(".")) break;
			System.out.println(process(s));
		}
		sc.close();
	}
	
	public static String process(String k) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < k.length(); i++) {
			char temp = k.charAt(i);
			
			switch (temp) {
			case '(':
			case '[': 
				stack.push(temp);
				break;
			case ')': 
				if(stack.isEmpty() || stack.pop() != '(') return "no";
				break;
			case ']': 
				if(stack.isEmpty() || stack.pop() != '[') return "no";
				break;
			}
		}
		if(stack.isEmpty()) {
			return "yes";
		} else {
			return "no";
		}
	}
}
