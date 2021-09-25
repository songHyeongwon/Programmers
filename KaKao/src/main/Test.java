package main;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getGrade( 40000, 40000)));
	}
	
	//점수의 가중치를 계산합니다.
	public static int[] getGrade(int winner, int loser) {
		//출처 http://www.todayhumor.co.kr/board/view.php?table=lol&no=439218
		int[] result = new int[2];
		
		int winnerPrese = (winner *100 / (winner + loser));
		int loserPrese = (loser * 100 / (winner + loser));
		
		System.out.println(winnerPrese);
		System.out.println(loserPrese);
		System.out.println((winner * (100 - winnerPrese)));
		
		result[0] = (winner * (100 - winnerPrese)) / (100 * 100) ;
		result[1] = (loser * (100 - loserPrese)) / (100 * 100);
		
		return result;
	}
}
