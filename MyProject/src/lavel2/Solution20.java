package lavel2;

import java.util.ArrayList;
import java.util.Comparator;
//https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
public class Solution20 {
	public static void main(String[] args) {
		int[] arr = {3, 30, 34, 5, 9};
		System.out.println(new Solution20().solution(arr));
	}
	public String solution(int[] numbers) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < numbers.length; i++) {
			list.add(String.valueOf(numbers[i]));
		}
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
			
		});
		//00000¿œ∂ß
		if(list.get(0).equals("0")) return "0";
		
		StringBuffer buf = new StringBuffer();
		for(String a : list) {
			buf.append(a);
		}
        return buf.toString();
    }
}
