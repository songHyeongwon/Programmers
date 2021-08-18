package lavel2;

import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/12909?language=java
public class Solution2 {
	public static void main(String[] args) {
		Solution2 solution2 = new Solution2();
		String a= "(())()";
		System.out.println(solution2.solution(a));;
	}
	boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        //stack.add('(');
        for (int i = 0; i < s.length(); i++) {
			
			
			if(s.charAt(i) == '(') {
				stack.add(s.charAt(i));
			} else {
				if(stack.isEmpty()) return false;
				stack.pop();
			}
		}
        //stack.pop();
        return stack.isEmpty();
    }
}
