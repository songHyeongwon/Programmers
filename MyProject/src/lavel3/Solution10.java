package lavel3;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42884
public class Solution10 {
	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(new Solution10().solution(routes));
	}
	
	public int solution(int[][] routes) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        for(int i = 0; i < routes.length; i++) {
        	list.add(routes[i]);
        }
        //나가는 순서 정렬
        Collections.sort(list , new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] > o2[1]) return 1;
				else return -1;
			}
		});
        
        while(!list.isEmpty()) {
        	int camere = list.get(0)[1];//-13
        	
        	for(int i = 0; i < list.size(); i++) {
        		//카메라 
        		if(list.get(i)[0] <= camere && list.get(i)[1] >= camere) {
        			list.remove(i);
        			i--;
        		}
        	}
        	answer++;
        }
        
        return answer;
    }
}
