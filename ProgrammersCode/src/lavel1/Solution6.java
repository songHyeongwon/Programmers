package lavel1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//https://programmers.co.kr/learn/courses/30/lessons/85002?language=java
public class Solution6 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution6().solution(new int[]{10,10,10,10}, new String[]{"NLWL","WNLL","LWNW","WWLN"})));
	}
	public int[] solution(int[] weights, String[] head2head) {
		
		ArrayList<Boxser> boxserList = new ArrayList<Boxser>();
		
		for(int i=0; i< head2head.length; i++) {
			Boxser temp = new Boxser();
			temp.index = i+1;
			temp.weights = weights[i];
			int winCnt = 0;
			int upWinCnt = 0;
			
			if(head2head[i].indexOf("W") > 0 || head2head[i].indexOf("L") > 0) {
				for(int j =0; j < head2head[i].length(); j++) {
					if(i!=j) {
						if(head2head[i].charAt(j) == 'W') {
							winCnt++;
							if(weights[i] < weights[j]) {
								upWinCnt++;
							}
						}
					}
				}
				temp.winPrer =  (double) winCnt / (double) (head2head[i].replaceAll("N", "").length())*100;
				temp.upWinCnt = upWinCnt;
			} else {//한번도 싸운적 없는 복서~
				temp.winPrer = 0.0;
				temp.upWinCnt = 0;
			}
			System.out.println(temp.toString());
			boxserList.add(temp);
		}
		
		boxserList.sort(new Comparator<Boxser>() {
			@Override
			public int compare(Boxser o1, Boxser o2) {
				if(o1.winPrer < o2.winPrer) {//1단계 조건 승률
					return 1;
				} else if(o1.winPrer == o2.winPrer) {
					if(o1.upWinCnt < o2.upWinCnt) {//2단계 조건 자신보다 무거운 복서 이긴 횟수
						return 1;
					} else if(o1.upWinCnt == o2.upWinCnt) {
						if(o1.weights < o2.weights) {//3단계 몸무게
							return 1;
						} else if(o1.weights == o2.weights) {
							if(o1.index > o2.index) {//4단계 그냥 앞번호
								return 1;
							}
						}
					}
				}
				return -1;
			}
		});
		
		int[] answer = new int[weights.length];
		for(int i = 0; i < boxserList.size(); i++) {
			answer[i] = boxserList.get(i).index;
		}
        return answer;
    }
	
	class Boxser{
		int index;
		int weights;
		double winPrer;
		int upWinCnt;
		@Override
		public String toString() {
			return "Boxser [index=" + index + ", weights=" + weights + ", winPrer=" + winPrer + ", upWinCnt=" + upWinCnt
					+ "]";
		}
		
	}
}
