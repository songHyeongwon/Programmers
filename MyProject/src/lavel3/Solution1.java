package lavel3;
//https://programmers.co.kr/learn/courses/30/lessons/12952?language=java
//https://st-lab.tistory.com/118
public class Solution1 {
	public static void main(String[] args) {
		System.out.println(new Solution1().solution(4));
	}
	public static int[] arr;
	public static int N;
	public static int count = 0;
	
	public int solution(int n) {
		arr = new int[n];
		N = n;
		getDfs(0);
        return count;
    }
	private void getDfs(int dep) {
		// TODO Auto-generated method stub
		if(dep == N) {
			count++;
			return;
		}
		
		for(int i =0; i < N; i++) {
			arr[dep] = i;
			if(isCheck(dep)) {
				getDfs(dep+1);
			}
		}
	}
	private boolean isCheck(int col) {
		for(int i =0; i <col; i++) {
			if(arr[col] == arr[i]) {
				return false;
			} else
			if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
