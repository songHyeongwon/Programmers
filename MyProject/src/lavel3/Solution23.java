package lavel3;

import java.util.Arrays;
import java.util.HashSet;
//https://programmers.co.kr/learn/courses/30/lessons/64064
public class Solution23 {
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		System.out.println(new Solution23().solution(user_id, banned_id));
	}
	
	HashSet<String> set;
	String[] regex;
	String[] user;
	boolean[] visited;
	
	public int solution(String[] user_id, String[] banned_id) {
		set = new HashSet<String>();
		user = user_id;
		regex = new String[banned_id.length];
		
		for (int i = 0; i < regex.length; i++) {
			regex[i] = banned_id[i].replaceAll("\\*", ".");
		}
		
		visited = new boolean[user.length];
		backTracking(0 , "");
        return set.size();
	}

	private void backTracking(int idx, String result) {
		//탐색이 끝나면 배열잘라 사전순 정렬 후 재조합 셋에 넣는다.
		if(idx == regex.length) {
			String[] str = result.split(" ");
			Arrays.sort(str);
			
			String temp = "";
			for (int i = 0; i < str.length; i++) {
				temp += str[i]+" ";
			}
			set.add(temp);
			System.out.println(set.toString());
			return;
		}
		//dfs 탐색
		for (int i = 0; i < user.length; i++) {
			if(!visited[i] && user[i].matches(regex[idx])) {
				visited[i] = true;
				backTracking(idx + 1 , result + " " + user[i]);
				visited[i] = false;
			}
		}
	}
}
