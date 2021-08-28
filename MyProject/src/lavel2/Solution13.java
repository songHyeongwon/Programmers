package lavel2;

import java.util.Stack;
//https://programmers.co.kr/learn/courses/30/lessons/76502
public class Solution13 {
	public static void main(String[] args) {
		//System.out.println(new Solution13().solution("[](){}"));
		System.out.println(new Solution13().isCheck("[](){}"));
	}
	
	public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(isCheck(s.substring(i) + s.substring(0, i))) answer++;
        }
        return answer;
    }
	public boolean isCheck(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i<s.length(); i++) {
			char index = s.charAt(i);
			if(stack.isEmpty()) {
				stack.add(index);
				continue;
			}
			if(index == ']' && stack.peek() == '[') {
				stack.pop();
			} else if(index == '}' && stack.peek() == '{') {
				stack.pop();
			} else if(index == ')' && stack.peek() == '(') {
				stack.pop();
			} else {
				stack.push(index);
			}
		}
		//이제 비어있으면 true
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
}
 