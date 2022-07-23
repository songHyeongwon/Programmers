package step19;

import java.util.Scanner;
import java.util.Stack;

public class Main9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			System.out.println(result(sc.nextLine()));
		}
		sc.close();
	}
	
	public static String result(String k) {
		Stack<Character> statc = new Stack<Character>();
		statc.add('(');
		for (int i = 0; i < k.length(); i++) {
			if(statc.isEmpty()) return "NO";
			if(k.charAt(i) == '(') {
				statc.add('(');
			} else {
				statc.pop();
			}
		}
		if(statc.size() == 1 && statc.pop() == '(') {
			return "YES";
		} else {
			return "NO";
		}
	}
}
