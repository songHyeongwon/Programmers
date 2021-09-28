package lavel1;

import java.util.Scanner;
//https://programmers.co.kr/learn/courses/30/lessons/12969?language=java
public class Solution9 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        char s='*';
        //String as="";
        for(int i=0;i<b;i++){
            for(int k=0;k<a;k++){
                System.out.print(s);
            }
            System.out.println();
        }

        
    }
}
