package lavel2;

import java.util.ArrayList;
import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/42890?language=java
public class Solution14 {
	public static void main(String[] args) {
		String[][] relation = {
				{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}
				};
		
		System.out.println(new Solution14().solution(relation));
		
		//System.out.println(new Solution14().getList(relation));
	}
	static ArrayList<Integer> arr = new ArrayList<Integer>();
		
	public int solution(String[][] relation) {
		int y = relation.length;
		int x = relation[0].length;
		
		for (int i = 1; i <= (1<<x)-1; i++) {
			//System.out.println(Integer.toBinaryString(i));
			HashSet<String> set = new HashSet<String>();
			for (int j = 0; j < y; j++) {
				String temp = "";
				for (int k = 0; k < x; k++) {
					if((i & (1<<k)) > 0) {
						temp+=relation[j][k];
					}
				}
				set.add(temp);
			}
			if(set.size() == y && checkOnly(i)) {
				arr.add(i);
			}
		}
        
        return arr.size();
    }

	private boolean checkOnly(int i) {
		
		for(int j =0; j< arr.size(); j++) {
			if((arr.get(j) & i) == arr.get(j)) return false;
		}
		
		return true;
	}
}
