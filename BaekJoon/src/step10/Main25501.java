package step10;

import java.util.Scanner;

public class Main25501 {
	static int recursionCnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			recursionCnt = 0;
			System.out.println(recursion(s.toCharArray() , 0 , s.length() -1 ) + " " + recursionCnt);
		}
		sc.close();
	}
	public static int recursion(char[] s,int l, int r) {
		recursionCnt++;
		if(l >= r) return 1;
		else if(s[l] != s[r]) return 0;
	    else return recursion(s, l+1, r-1);
	}
}
