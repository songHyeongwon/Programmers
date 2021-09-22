package lavel3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

//https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
public class Solution17 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"};
		int[] plays = {500, 600, 150, 800, 1100, 2500, 100, 1000};
		
		System.out.println(Arrays.toString(new Solution17().solution(genres, plays)));
	}
	
	public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<Music> arr = new ArrayList<Music>();
        
        for(int i =0; i < genres.length; i++) {
        	arr.add(new Music(genres[i] , plays[i] , i));
        	if(map.containsKey(genres[i])) {
        		map.put(genres[i] , map.get(genres[i]) + plays[i]);
        	} else {
        		map.put(genres[i] , plays[i]);
        	}
        	
        }
        // Map.Entry 리스트 작성
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
        
        // 비교함수 Comparator를 사용하여 내림 차순으로 정렬
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
        	// compare로 값을 비교
        	public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
        		// 내림 차순으로 정렬
        		int obj2V = obj2.getValue();
        		int obj1V = obj1.getValue();
        		
        		if(obj2V > obj1V) {
        			return 1;
        		} else {
        			return -1;
        		}
        	}
        });
        Collections.sort(arr);
 		//System.out.println(list_entries.toString());
 		//System.out.println(arr.toString());
 		
 		ArrayList<Integer> temp = new ArrayList<Integer>();
 		for(int j = 0; j < list_entries.size(); j++) {
 			String key = list_entries.get(j).getKey();
 			int count = 0;
 			for(int i =0; i < arr.size(); i++) {
 				if(arr.get(i).genre.equals(key)) {
 					if(count < 2) {
 						temp.add(arr.get(i).index);
 						count++;
 					}
 				}
 			}
 		}
 		
 		//System.out.println(temp.toString());
 		
        int[] answer = new int[temp.size()];
        
        for(int i =0; i < temp.size(); i++) {
        	answer[i] = temp.get(i);
        }
        
        return answer;
    }
	class Music implements Comparable<Music>{
		String genre;
		int play;
		int index;
		Music(String genre , int play , int index){
			this.genre = genre;
			this.play = play;
			this.index = index;
		}
		
		@Override
		public int compareTo(Music o) {
			// TODO Auto-generated method stub
			return o.play - this.play;
		}

		@Override
		public String toString() {
			return "Music [genre=" + genre + ", play=" + play + ", index=" + index + "]";
		}
	}
}
