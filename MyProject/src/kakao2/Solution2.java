package kakao2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	public static void main(String[] args) {
		List<Integer> cost = new ArrayList<Integer>();
		cost.add(20);
		cost.add(30);
		cost.add(50);
		System.out.println(solution(cost , 70));
	}
	
    final static int an = 1000000007;
    public static int solution(List<Integer> cost, int x) {
        int[] dp = new int[cost.size() + 1];
        
        for (int i = cost.size() -1; i >= 0; i--) {
        	int pow = 0;
            if(x >= cost.get(i)) { //Å©¸é
            	pow = (int) Math.pow(2 , i);
            	x-= cost.get(i);
            	System.out.println(dp[i]);
            }
            dp[i] = dp[i + 1] + pow % an;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
