package lavel1;

public class Solution1 {
	public static void main(String[] args) {
	}
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int winCnt = 0;
        int maskingCnt = 0;
        for (int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0) {
				maskingCnt++;
				continue;
			}
			for (int j = 0; j < win_nums.length; j++) {
				if(lottos[i] == win_nums[j]) winCnt++;
			}
		}
        System.out.println(winCnt + " / " + maskingCnt);
        answer[1] = 7 - winCnt;
        answer[0] = 7 - (winCnt + maskingCnt);
        if(answer[0] == 7) answer[0] = 6; 
        if(answer[1] == 7) answer[1] = 6; 
        return answer;
    }
}
