package lavel3;

import java.util.Arrays;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/77886
//https://wellbell.tistory.com/228
public class Solution20 {
	public static void main(String[] args) {
		String[] arr = {"1110","100111100","0111111010"};
		
		System.out.println(Arrays.toString(new Solution20().solution(arr)));
	}
	
	
	public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i =0; i < s.length; i++) {
        	answer[i] = getAnswer(s[i]);
        }
        
        return answer;
    }


	private String getAnswer(String s) {
		// TODO Auto-generated method stub
		/*String temp = s;
		
		while(temp.indexOf("110") > -1) {
			temp = temp.replaceAll("110", "");
		}*/
		
		
		
		String str = s;
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for(int j=0; j<str.length(); j++) {
            char z = str.charAt(j);

            if(stack.size()>=2) {
                char y = stack.pop();
                char x = stack.pop();

                if(x=='1' && y=='1' && z=='0') {
                    cnt++;
                } else {
                    stack.push(x);
                    stack.push(y);
                    stack.push(z);
                }
            } else {
                stack.push(z);
            }
        }
		
        int idx = stack.size();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            if(!flag && stack.peek()=='1') {
                idx--;
            }

            if(!flag && stack.peek()=='0') {
                flag = true;
            }

            sb.insert(0, stack.pop());
        }
		//int k = (s.length() - temp.length()) / 3;
		String temp = sb.toString();
		StringBuilder buf = new StringBuilder(temp);
		int index = temp.lastIndexOf("0") == -1 ? 0 : temp.lastIndexOf("0") +1;
		StringBuilder tempBuf = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			tempBuf.append("110");
		}
		buf.insert(index, tempBuf.toString());
		
		return buf.toString();
	}
}
