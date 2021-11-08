package lavel2;
//https://programmers.co.kr/learn/courses/30/lessons/42578
import java.util.HashMap;
import java.util.HashSet;

public class Solution11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(new Solution11().solution(clothes));
	}
	public int solution(String[][] clothes) {        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashSet<String> set = new HashSet<String>();
        
        for (int i = 0; i < clothes.length; i++) {
        	set.add(clothes[i][1]);
        	if(map.containsKey(clothes[i][1])) {//containsKey 특정키의 여부 확인
        		map.put(clothes[i][1], map.get(clothes[i][1])+1);
        	} else {
        		map.put(clothes[i][1] , 1);
        	}
		}
        //(3[머리]+1) * (2[상의]+1) * (1[하의]+1) * 1 - 1[안입을때]
        int an = 1;
        for(String k : set) {
        	an *= (map.get(k)+1);
        }
        
        return an-1;
    }
}
