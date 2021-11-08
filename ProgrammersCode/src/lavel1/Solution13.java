package lavel1;

import java.util.HashSet;
//https://programmers.co.kr/learn/courses/30/lessons/1845?language=java
public class Solution13 {
	public static void main(String[] args) {
		int[] arr = {3,1,2,3};
		System.out.println(new Solution13().solution(arr));
	}
	
	public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
		for(int k : nums) {
			set.add(k);
		}
		int result = 0;
		//배열의 절반이   set 사이즈보다 작다면
		if((nums.length/2) <= set.size()) {
			result = (int)(nums.length/2);
		} else {
			result = set.size();
		}
        return result;
    }
}
