package lavel2;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/1835
public class Solution25 {
	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		System.out.println(new Solution25().solution(n, data));
	}
	static String[] kakaoFrand = {"A", "C", "F", "J", "M", "N", "R", "T"};
	static int answer;
	
	public int solution(int n, String[] data) {
		answer = 0;
		boolean[] isInCheck = new boolean[8];
		getDfs("" , isInCheck, data);
        return answer;
    }
	private void getDfs(String name, boolean[] isInCheck, String[] data) {
		// TODO Auto-generated method stub
		if(name.length() == 7) {
			if(isCheck(name , data)) {
				answer++;
			}
			return;
		}
		for(int i = 0; i < 8; i++) {
			if(!isInCheck[i]) {
				isInCheck[i] = true;
				String nameAdd = name + kakaoFrand[i];
				getDfs(nameAdd, isInCheck, data);
				isInCheck[i] = false;
			}
		}
	}
	private boolean isCheck(String name, String[] datas) {
		// TODO Auto-generated method stub
		for(String data : datas) {
			//[N, ~, F, =, 0]
			String[] dataArr = data.split("");
			int frand1 = name.indexOf(dataArr[0]);
			int frand2 = name.indexOf(dataArr[2]);
			int length = Integer.parseInt(dataArr[4])+1;
			if(dataArr[3].equals("=")) {
				if(!(Math.abs(frand1 - frand2) == length)) return false;
			} else if(dataArr[3].equals(">")) {
				if(!(Math.abs(frand1 - frand2) > length)) return false;
			} else if(dataArr[3].equals("<")) {
				if(!(Math.abs(frand1 - frand2) < length)) return false;
			}
		}
		return true;
	}
}
