package lavel1;

import java.util.ArrayList;
import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
public class Solution12 {
	public static void main(String[] args) {
		System.out.println(new Solution12().solution(5, new int[]{2, 4}, new int[]{3}));
	}
	
	
	public int solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost);
		Arrays.sort(reserve);
        ArrayList<Integer> lostArr = new ArrayList<Integer>();
        ArrayList<Integer> lostArrTemp = new ArrayList<Integer>();
        ArrayList<Integer> reserveArr = new ArrayList<Integer>();
        ArrayList<Integer> reserveArrTemp = new ArrayList<Integer>();
        for (int i = 0; i < lost.length; i++) {
        	lostArr.add(lost[i]);
        	lostArrTemp.add(lost[i]);
		}
        for (int i = 0; i < reserve.length; i++) {
        	reserveArr.add(reserve[i]);
        	reserveArrTemp.add(reserve[i]);
		}
        lostArr.removeAll(reserveArrTemp);
        reserveArr.removeAll(lostArrTemp);
        //System.out.println(reserveArr.toString());
        //System.out.println(lostArr.toString());
        
        int answer = n - lostArr.size();
        for (int i = 0; i < reserveArr.size(); i++) {
        	int reserveNum = reserveArr.get(i);
        	
			for (int j = 0; j < lostArr.size(); j++) {
				int lostNum = lostArr.get(j);
				if(lostNum-1 ==  reserveNum) {
					answer++;
					lostArr.set(j, -1);
					break;
				}
				if(lostNum+1 ==  reserveNum) {
					answer++;
					lostArr.set(j, -1);
					break;
				}
			}
		}
        
        return answer;
    }
}
