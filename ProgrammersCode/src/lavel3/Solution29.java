package lavel3;
//https://programmers.co.kr/learn/courses/30/lessons/43163
public class Solution29 {
	public static void main(String[] args) {
		String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(new Solution29().solution("hit", "cog", arr));
	}
	
	static boolean[] check = null;
	static String[] arr = null;
	
	public int solution(String begin, String target, String[] words) {
		check = new boolean[words.length];
		arr = words;
        int answer = dfs(begin, target, 1, Integer.MAX_VALUE);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
	
	
	
	private int dfs(String begin, String target, int cnt, int ans) {
		//같다면 종료
		if(begin.equals(target)) {
			return cnt -1;
		}
		
		//단어탐색
		for (int i = 0; i < arr.length; i++) {
			if(!check[i] && isCheck(begin , arr[i])) {
				check[i] = true;
				ans = Math.min(ans , dfs(arr[i], target, cnt+1, ans));
				check[i] = false;
			}
		}
		return ans;
	}

	public boolean isCheck(String a , String b) {
		if(a.length() != b.length()) {
			return false;
		}
		int difCnt = 0;
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				difCnt++;
			}
		}
		return difCnt == 1;
	}
}
