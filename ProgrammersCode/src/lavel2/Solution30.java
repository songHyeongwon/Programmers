package lavel2;
//https://programmers.co.kr/learn/courses/30/lessons/87946?language=java
public class Solution30 {
	public static void main(String[] args) {
		System.out.println(new Solution30().solution(80, new int[][]{{80,20},{50,40},{30,10}}));
	}
	
	static int max = 0;
	static boolean[] isCheck = null;
	
	public int solution(int k, int[][] dungeons) {
        isCheck = new boolean[dungeons.length];
        
        dfs(dungeons , k , 0);
        
        return max;
    }

	private void dfs(int[][] dungeons, int k, int count) {
		//System.out.println("남은피로도 = " + k +" 돈 던전은 = " +count);
		max = Math.max(max, count);
		if(k <= 0) {
			return;
		}
		for (int i = 0; i < dungeons.length; i++) {
			if(!isCheck[i] && dungeons[i][0] <= k) {
				isCheck[i] = true;
				dfs(dungeons , k - dungeons[i][1] , count+1);
				isCheck[i] = false;
			}
		}
	}
}
