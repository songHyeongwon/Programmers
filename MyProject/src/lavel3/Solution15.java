package lavel3;
//https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
public class Solution15 {
	public static void main(String[] args) {
		
		System.out.println(new Solution15().solution(5, 12));
	}
	
	//출처 : https://velog.io/@jwkim/DFS-n-expression
	private int n;
	private int target;
	private int answer = Integer.MAX_VALUE;
	
	public int solution(int N, int number) {
		n = N;
		target = number;
		dfs(0, 0);// 연산횟수 , 결과값
        return answer == Integer.MAX_VALUE ? -1 : answer; //답이 변경되었으면 답 아니면 -1
    }

	private void dfs(int count, int prev) {
		System.out.println(prev);
		// TODO Auto-generated method stub
		if(count > 8) {
			answer = -1;
			return;
		}
		
		if(prev == target) {
			answer = Math.min(count, answer);
			return;
		}
		
		int tempN = n;
		for(int i = 0; i < 8-count; i++) {
			int count2 = count+ i + 1;
			dfs(count2, prev + tempN);
			dfs(count2, prev - tempN);
			dfs(count2, prev / tempN);
			dfs(count2, prev * tempN);
			tempN = tempN * 10 + n;//템프의 단위를 10단위 상승
		}
	}
}
