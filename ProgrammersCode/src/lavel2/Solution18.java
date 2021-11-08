package lavel2;

import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
public class Solution18 {
	public static void main(String[] args) {
		System.out.println(new Solution18().solution("17"));
	}
	static HashSet<Integer> set = new HashSet<Integer>();
	
	
	
	/* 순열 루틴
	 * public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }*/
	public int solution(String numbers) {
		char[] arr = numbers.toCharArray();
        for(int i =1; i <= arr.length; i++) {
        	addSet(arr , 0 , i);
        }
        int answer = 0;
        for(int k: set) {
        	if(isChekc(k)) answer++;
        }
        return answer;
    }
	
	
	private void addSet(char[] arr, int depth, int k) {
		// TODO Auto-generated method stub
		if (depth == k) { 
            // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            print(arr, k);
            return;
        } else {
            for (int i = depth; i < arr.length; i++) {
                swap(arr, i, depth);
                addSet(arr, depth + 1, k);
                swap(arr, i, depth);
            }
        }
	}
	
	public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	public void print(char[] arr, int k) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < k; i++) {
            a.append(arr[i]);
        }
        System.out.println(a.toString());
        set.add(Integer.parseInt(a.toString()));
    }
	
	//소수판별
	public boolean isChekc(int a) {
		if(a < 2) return false;
		for(int i = 2; i <= Math.sqrt(a); i++) {
			if(a % i == 0) return false;
		}
		return true;
 	}
}
