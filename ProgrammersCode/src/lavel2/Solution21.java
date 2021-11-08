package lavel2;

//https://programmers.co.kr/learn/courses/30/lessons/64065
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
public class Solution21 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution21().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
	}
	public int[] solution(String s) {
		String[] sSplit = s.replaceAll("[{}]", "").split(","); //튜플 배열
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();// 튜플 정렬용 맵
		ArrayList<Integer> list = new ArrayList<Integer>(); //튜플 리스트
		
		//맵에 카운팅 + 리스트 추가
		for(int i = 0; i < sSplit.length; i++) {
			int sSplitInt = Integer.parseInt(sSplit[i].trim());
			if(!map.containsKey(sSplitInt)) {
				map.put(sSplitInt, 1);
				list.add(sSplitInt);
			} else {
				map.put(sSplitInt, map.get(sSplitInt)+1);
			}
		}
		//맵에 있는 카운팅 갯수로 정렬
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(map.get(o1) > map.get(o2)) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		//배열 생성 입력
        int[] answer = new int[list.size()];
        for(int i =0; i< list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}

