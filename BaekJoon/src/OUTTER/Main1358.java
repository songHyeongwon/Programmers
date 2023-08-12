package OUTTER;

import java.util.Scanner;

public class Main1358 {
	
	static int W;
	static int H;
	static int X;
	static int Y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		int p = sc.nextInt();
		int count = 0;
		for(int i = 0; i < p; i++) {
			if(fun(sc.nextInt(), sc.nextInt())) count++;
		}
		sc.close();
		System.out.println(count);
	}
	
	public static boolean fun(int x, int y) {
		int r = H/2;
		if(y < Y || y > Y + H) return false;
		if(x < X) {
			if(r < getDis(x, y, X, Y+r)) return false;
		}
		if(x > X + W) {
			if(r < getDis(x, y, X+W, Y+r)) return false;
		}
		return true;
	}
	
	public static double getDis(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2));
	}
}
