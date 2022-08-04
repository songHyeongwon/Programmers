package lavel2;

public class Solution35 {
	//https://school.programmers.co.kr/learn/courses/30/lessons/12902
	public static void main(String[] args) {
		Solution35 sol = new Solution35();
		System.out.println(sol.solution(5000));
		;
	}
	//2 3
	//4 11
	private static int MAX = 1000000007;
    public int solution(int n) {
    	if(n % 2 == 1) return 0;        
        long[] arr = new long[n+1];
        arr[2] = 3;
        arr[4] = 11;
        for (int i = 6; i < arr.length; i=i+2) {
        	long temp = (arr[i-2] * 4 % MAX - arr[i-4] % MAX) + MAX;
			arr[i] = temp % MAX;
		}
        return (int) arr[n];
    }
}
