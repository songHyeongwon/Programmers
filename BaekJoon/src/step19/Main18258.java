package step19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main18258 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		//ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine() , " ");
			String word = token.nextToken();
			
			if(word.equals("push")) {
				queue.add(Integer.parseInt(token.nextToken()));
			}
			
			if(word.equals("pop")) {
				if(queue.size() != 0) {
					sb.append(queue.get(0)).append("\n");
					queue.remove(0);
				} else {
					sb.append(-1).append("\n");
				}
			}
			
			if(word.equals("size")) {
				sb.append(queue.size()).append("\n");
			}
			
			if(word.equals("empty")) {
				if(queue.size() != 0) {
					sb.append(0).append("\n");
				} else {
					sb.append(1).append("\n");
				}
			}
			
			if(word.equals("front")) {
				if(queue.size() != 0) {
					sb.append(queue.get(0)).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			}
			
			if(word.equals("back")) {
				if(queue.size() != 0) {
					sb.append(queue.get(queue.size()-1)).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
