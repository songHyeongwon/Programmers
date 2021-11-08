package lavel1;

import java.util.Arrays;

//https://programmers.co.kr/tryouts/3929/challenges?original_test_id=28397&original_token=e31fb4943739792fcaf3ccf67ed5a058
public class Solution4 {
	public static void main(String[] args) {
		Solution4 solution4 = new Solution4();
		
		int[][] arr = {{1, 4}, {3, 4}, {3, 10}};
		System.out.println(Arrays.toString(solution4.solution(arr)));
	}
	
	public int[] solution(int[][] v) {
        int[] answer = new int[2];
 
        for (int i = 0; i < 3; i++) {
            answer[0] ^= v[i][0];
            answer[1] ^= v[i][1];
        }

        return answer;
    }
}
