package lavel2;
//https://programmers.co.kr/learn/courses/30/lessons/84512
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution19 {
	public static void main(String[] args) {
		System.out.println(new Solution19().solution("EIO"));
	}
	
	/*public int solution(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }*/
	
	static String[] arr = {"","A", "E", "I", "O", "U"};
	static HashSet<String> set = new HashSet<String>();
	public int solution(String word) {
		addSet();
		System.out.println(set.size());
		ArrayList<String> list = new ArrayList<String>();
		for(String k : set) {
			list.add(k);
		}
		Collections.sort(list);
		
        return list.indexOf(word)+1;
	}

	private void addSet() {
		// TODO Auto-generated method stub
		for(String i : arr) {
			for(String j : arr) {
				for(String k : arr) {
					for(String l : arr) {
						for(String o : arr) {
							String a = i.trim() + j.trim() + k.trim() + l.trim() + o.trim();
							if(!a.equals("")) {
								set.add(a);
							}
						}
					}
				}
			}
		}
	}
}
