package step09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11651 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//¼±¾ð
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		
		for (int i = 0; i < n; i++) {
			Integer[] tempArr = new Integer[2];
			StringTokenizer token = new StringTokenizer(br.readLine() , " ");
			tempArr[0] = Integer.parseInt(token.nextToken());
			tempArr[1] = Integer.parseInt(token.nextToken());
			list.add(tempArr);
		}
		list.sort((arr1 , arr2) -> {
			if(arr1[1].compareTo(arr2[1]) == 0) {
				return arr1[0].compareTo(arr2[0]);
			} else {
				return arr1[1].compareTo(arr2[1]);
			}
		});
		
		for(Integer[] a : list) {
			bw.write(a[0] + " " + a[1] +"\n");
		}
		
		br.close();
		bw.close();
	}
}