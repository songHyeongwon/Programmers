package step12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2108 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//¼±¾ð
		int n = Integer.parseInt(br.readLine());
		
		int avg = 0;
		int renge = 0;
		int median = 100000;
		int mede = 1000000;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		int[] arr = new int[8002];
		
		double sum = 0;
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(br.readLine());
			sum += value;
			arr[value + 4000]++;
			max = Math.max(max, value);
			min = Math.min(min, value);
		}
		
		int count = 0;
		int modeMax = 0;
		boolean flag = false;
		
		for (int i = min + 4000; i <= max + 4000 ; i++) {
			if(arr[i] > 0) {
				if(count < (n + 1) / 2) {
					count += arr[i];
					median = i - 4000;
				}
				
				if(modeMax < arr[i]) {
					modeMax =arr[i];
					mede = i - 4000;
					flag =  true;
				} else if(modeMax == arr[i] && flag) {
					mede = i - 4000;
					flag =  false;
				}
			}
		}
		avg = (int) Math.round(sum / n);
		renge = max - min;
		
		bw.write(avg + "\n");
		bw.write(median + "\n");
		bw.write(mede + "\n");
		bw.write(renge + "\n");
		bw.close();
		br.close();
	}
}
