package lavel2;

import java.util.ArrayList;
import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/67257?language=java
public class Solution23 {
	public static void main(String[] args) {
		System.out.println(new Solution23().solution("50*6-3*2"));
		
	}
	
	public long solution(String expression) {
        long answer = 0;
        //가지고 있는 연산 가짓수
        HashSet<Character> set = new HashSet<Character>();
        
        for(int i = 0; i < expression.length(); i++) {
        	if(expression.charAt(i) < 48) {
        		//arrList.add(i);
        		set.add(expression.charAt(i));
        	}
        }
        //조합 가져오기
        ArrayList<char[]> outList = getOutList(set);
        for(int i = 0; i<outList.size(); i++) {
        	//'+', '-' ,'*'
        	char[] out = outList.get(i);
        	answer = Math.max(answer, Math.abs(getSum(expression, out)));
        }
        
        return answer;
    }

	private long getSum(String expression, char[] out) {
		// TODO Auto-generated method stub
		String[] longArr = expression.split("[-*+]");
		String[] longArr2 = expression.split("[0-9]+");
		ArrayList<Long> longList = new ArrayList<Long>();
        for (int i = 0; i < longArr.length; i++) {
        	longList.add(Long.parseLong(longArr[i]));
        }
        ArrayList<String> longList2 = new ArrayList<String>();
        for (int i = 1; i < longArr2.length; i++) {
        	longList2.add(longArr2[i]);
        }
        
		for(int i = 0; i < out.length; i++) {
			char test= out[i];
			
			for(int j = 0; j < longList2.size(); j++) {
				//우선순위 연산이 같다면
				if(longList2.get(j).equals(String.valueOf(test))) {
					long front = longList.get(j);
					long end = longList.get(j+1);
					long temp = getCalc(front, end, longList2.get(j));
							
					longList.remove(j+1);
					longList.remove(j);
					longList2.remove(j);
					
					longList.add(j, temp);
					j--;
				}
			}
		}
		
		return longList.get(0);
	}

	
	
	private long getCalc(long front, long end, String string) {
		switch (string) {
        case "-" :
            return front - end;
        case "+" :
            return front + end;
        default :
            return front * end;
		}
	}

	private ArrayList<char[]> getOutList(HashSet<Character> set) {
		ArrayList<char[]> arr = new ArrayList<char[]>();
		char[] anw = new char[set.size()];
		int count =  0;
		for(char a : set) {
			anw[count++] = a;
		}
		if(set.size() == 1) {
			arr.add(new char[] {anw[0]});
		} else if(set.size() == 2) {
			arr.add(new char[] {anw[0], anw[1]});
			arr.add(new char[] {anw[1], anw[0]});
		} else {
			arr.add(new char[] {'+', '-' ,'*'});
			arr.add(new char[] {'+', '*' ,'-'});
			
			arr.add(new char[] {'-', '+' ,'*'});
			arr.add(new char[] {'-', '*' ,'+'});
			
			arr.add(new char[] {'*', '+' ,'-'});
			arr.add(new char[] {'*', '-' ,'+'});
		}
		
		
		return arr;
	}
}
