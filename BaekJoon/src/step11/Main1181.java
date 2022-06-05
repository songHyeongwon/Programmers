package step11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class Main1181 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//¼±¾ð
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			if(set.add(temp)) {
				list.add(temp);
			}
		}
		list.sort((s1 , s2) -> {
			if(s1.length() == s2.length()) {
				return s1.compareTo(s2);
			} else {
				return s1.length() - s2.length();
			}
		});
		
		for(String a : list) {
			bw.write(a+"\n");
		}
		
		bw.close();
		br.close();
	}
}
