package OUTTER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2477 {
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int first = Integer.parseInt(st.nextToken());
		int pre = first;
		for(int i = 1 ; i < 6 ; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int now = Integer.parseInt(st.nextToken());
			max = Math.max(now*pre, max);
			sum += now*pre;
			pre = now;
		}
		max = Math.max(first*pre, max);
		sum += first*pre;
		int result = (max - ((max*3)-sum))*K;
		System.out.println(result);
	}
}
