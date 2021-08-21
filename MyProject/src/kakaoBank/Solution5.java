package kakaoBank;

import java.util.HashMap;

class Solution5 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            map.put(i, prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if(prices[i] < map.get(j)) count++;
            }
            answer[i] = count;
            count = 0;
        }

        return answer;
    }
}