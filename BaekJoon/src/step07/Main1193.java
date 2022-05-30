package step07;

import java.util.Scanner;

public class Main1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int temp = 1;
		int count = 1;
		int asTemp = 0;
		while(temp < x && x != 1) {
			asTemp = temp;
			temp += (++count);
		}
		if(count % 2 == 0) {
			//Â¦¼ö¿­
			int row = x - asTemp;
			System.out.println(row +"/"+ (count +1 - row));
			
		} else {
			//È¦¼ö¿­
			int row = x - asTemp;
			System.out.println((count +1 - row) + "/" + row);
		}
		
		sc.close();
	}
}
