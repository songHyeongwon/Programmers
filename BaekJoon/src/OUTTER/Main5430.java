package OUTTER;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main5430 {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayDeque<Integer> deque;
		
		for (int i = 0; i < T; i++) {
			String fun = sc.next();
			int N = sc.nextInt();
			String arrText = sc.next();
			String[] arr = arrText.substring(1, arrText.length() -1).split(",");
			//System.out.println(fun + " " + N + " " + Arrays.toString(arr));
			deque = new ArrayDeque<Integer>();
			// 덱에 배열 원소를 넣어준다.
			for(int j = 0; j < N; j++) {
				deque.add(Integer.parseInt(arr[j]));
			}
			fun(fun , deque);
		} 
		System.out.println(sb.toString());
		sc.close();
	}
	public static void fun(String temp , ArrayDeque<Integer> list) {
		boolean isFirst = true;
		for (int i = 0; i < temp.length(); i++) {
			if(temp.charAt(i) == 'R') {
				isFirst = !isFirst;
			} else {
				if(list.size() == 0) {
					sb.append("error\n");
					return;
				}
				if(isFirst) {
					list.pollFirst();
				} else {
					list.pollLast();
				}
			}
		}
		makeSb(isFirst , list);
	}
	private static void makeSb(boolean isFirst, ArrayDeque<Integer> list) {
		sb.append("[");
		if(list.size() > 0) {
			if(isFirst) {
				sb.append(list.pollFirst());
				while(!list.isEmpty()) {
					sb.append(",").append(list.pollFirst());
				}
			} else {
				sb.append(list.pollLast());
				while(!list.isEmpty()) {
					sb.append(",").append(list.pollLast());
				}
			}
		}
		sb.append("]\n");
	}
}
