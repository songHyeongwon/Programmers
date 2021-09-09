package lavel3;

import java.util.ArrayList;
import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/12936
public class Solution3 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution3().solution(20,13213216546848L)));
	}
	public int[] solution(int n, long k) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] result = new int[n];
        long fn = 1;
        for(int i = 1;  i <= n; i++) {
            fn *= i;
            list.add(i);
        }
        k--;
        
        int idx = 0; //배열이 다 차면 끝
        while(n > 0) {
            fn /= n;            //n번 째 자리수가 정해짐
            result[idx++] = list.get((int) (k/fn));
            list.remove((int) (k/fn));
            k %= fn;
            n--;
        }
        return result;
    }


//출처: https://tosuccess.tistory.com/75 [EI_HJ]
}
