package step9;

import java.util.Scanner;

public class Main3009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] xArr = new int[3];
		int[] yArr = new int[3];
		
		for (int i = 0; i < yArr.length; i++) {
			xArr[i] = sc.nextInt();
			yArr[i] = sc.nextInt();
		}
		sc.close();
		
		int resultX = 0;
		int resultY = 0;
		if(xArr[0] == xArr[1]) {
			resultX = xArr[2];
		} else if(xArr[1] == xArr[2]){
			resultX = xArr[0];
		} else {
			resultX = xArr[1];
		}
		if(yArr[0] == yArr[1]) {
			resultY = yArr[2];
		} else if(yArr[1] == yArr[2]){
			resultY = yArr[0];
		} else {
			resultY = yArr[1];
		}
		System.out.println(resultX + " " + resultY);
	}
}
