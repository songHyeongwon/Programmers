package lavel2;
//https://programmers.co.kr/learn/courses/30/lessons/17684?language=java
import java.util.*;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 solution3 =new Solution3();
		System.out.println(Arrays.toString(solution3.solution("TOBEORNOTTOBEORTOBEORNOT")));
		
	}
	public int[] solution(String msg) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		char k = 'A';
		int count = 1;
		for (;count <= 26; count++)  {
			map.put(String.valueOf(Character.toChars(k+(count-1))), count);
		}
		//사전 초기화 종료
		StringBuffer buf = new StringBuffer();
		
		String temp = null;
		
		for (int i = 0; i < msg.length(); i++) {
			buf.append(msg.charAt(i));
			if(map.get(buf.toString()) != null) {
				temp = buf.toString();
			} else {
				map.put(buf.toString(), count++);
				list.add(map.get(temp));
				i--;
				buf = new StringBuffer();
			}
		}
		list.add(map.get(temp));
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
		}
        List<Map.Entry<String, Integer>> entryList = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        
        System.out.println(entryList.toString());
        return answer;
    }
}
