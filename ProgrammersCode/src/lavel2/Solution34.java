package lavel2;

//https://programmers.co.kr/learn/courses/30/lessons/92342?language=java
public class Solution34 {
	public static void main(String[] args) {
		int[] info = 	{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
		System.out.println(new Solution34().solution(10, info));
	}
	static int maxScore = 0;
	static int[] maxScoreArr = null;
	static int[] arpachScoreArr = null;
	public int[] solution(int n, int[] info) {
		arpachScoreArr = info;
		getDfs(new int[info.length] , 0 , n);
		if(maxScore == 0) {
			maxScoreArr = new int[]{-1};
		}
		
        return maxScoreArr;
    }
	private void getDfs(int[] is, int num, int n) {
		// TODO Auto-generated method stub
		if(num == n) {
			int score = checkScore(is);
			if(score > maxScore) {
				maxScore = score;
				int[] b = new int[is.length];
				for (int i = 0; i < b.length; i++) {
		            b[i] = is[i];
		        }
				maxScoreArr = b;
			}
			return;
		}
		
		for(int i = 10; i >= 0; i--) {
			if (is[i] < arpachScoreArr[i]+1 && arpachScoreArr[i] + num +1 <= n) {
                if(checkScore(is) >= maxScore/2) {
					//½ÉÃþÅ½»ö
					is[i] = is[i]+1;
					getDfs(is, num+1, n);
					is[i] = is[i]-1;
				} else {
					is[i] = is[i]+arpachScoreArr[i]+1;
					getDfs(is, arpachScoreArr[i]+num+1, n);
					is[i] = is[i]-arpachScoreArr[i]-1;
				}
			}
		}
	}
	
	//¾ç±Ã Á¡¼öÈ®ÀÎ
	private int checkScore(int[] is) {
		// TODO Auto-generated method stub
		int result = 0;
		
		for(int i = 0; i <= 10 ; i++) {
			if(arpachScoreArr[i] < is[i] && is[i] > 0) {
				result += (10-i);
			}
		}
		int arpachScore = 0;
		for(int i = 0; i <= 10; i++) {
			if(arpachScoreArr[i] >= is[i] && arpachScoreArr[i] > 0) {
				arpachScore += (10-i);
			}
		}
		return result - arpachScore;
	}
}
