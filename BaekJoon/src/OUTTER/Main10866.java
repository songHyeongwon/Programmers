package OUTTER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main10866 {
	public static void main(String[] args) throws IOException{
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer buf = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer token = new StringTokenizer(line , " ");
			
			String pro = token.nextToken();
			if(pro.indexOf("push_") > -1) {
				if(pro.indexOf("front") > -1) {
					deque.addFirst(Integer.parseInt(token.nextToken()));
				} else {
					deque.addLast(Integer.parseInt(token.nextToken()));
				}
			} else if(pro.indexOf("pop_") > -1){
				if(deque.isEmpty()) {
					buf.append(-1).append("\n");
				} else {
					if(pro.indexOf("front") > -1) {
						buf.append(deque.pollFirst()).append("\n");
					} else {
						buf.append(deque.pollLast()).append("\n");
					}
				}
			} else if(pro.equals("size")) {
				buf.append(deque.size()).append("\n");
			} else if(pro.equals("empty")) {
				buf.append(deque.isEmpty() ? 1 : 0).append("\n");
			} else if(pro.equals("front")) {
				if(deque.isEmpty()) {
					buf.append(-1).append("\n");
				} else {
					buf.append(deque.peekFirst()).append("\n");
				}
			} else if(pro.equals("back")) {
				if(deque.isEmpty()) {
					buf.append(-1).append("\n");
				} else {
					buf.append(deque.peekLast()).append("\n");
				}
			}
		}
		br.close();
		System.out.println(buf.toString());
	}
}
