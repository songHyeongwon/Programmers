package step09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11650 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//¼±¾ð
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		for(int i =0; i < n; i++) {
			int[] tempArr = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			tempArr[0] = Integer.parseInt(st.nextToken());
			tempArr[1] = Integer.parseInt(st.nextToken());
			
			list.add(tempArr);
		}
		
		list.sort((arr1, arr2) -> {
			if(arr1[0] > arr2[0]) {
				return 1;
			} else if(arr1[0] == arr2[0]){
				if(arr1[1] > arr2[1]) {
					return 1;
				} else if(arr1[1] == arr2[1]) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		});
		
		for(int[] a : list) {
			System.out.println(a[0] + " " + a[1]);
		}
		bw.close();
		br.close();
	}
}
