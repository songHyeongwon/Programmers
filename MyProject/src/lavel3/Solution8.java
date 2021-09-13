package lavel3;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/17678?language=java
public class Solution8 {
	public static void main(String[] args) {
		String[] arr = 	{"09:10", "09:09", "08:00"};
		System.out.println(new Solution8().solution(2, 10, 2, arr));
	}
	/*셔틀 운행 횟수 n
	, 셔틀 운행 간격 t
	, 한 셔틀에 탈 수 있는 최대 크루 수 m
	, 크루가 대기열에 도착하는 시각을 모은 배열 timetable이 입력으로 주어진다.*/
	public String solution(int n, int t, int m, String[] timetable) {
		
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		//9시 시작
		int startTime = 9*60;
		for(int i = 0; i< timetable.length; i++) {
			int hh = Integer.parseInt(timetable[i].split(":")[0]);
			int mm = Integer.parseInt(timetable[i].split(":")[1]);
			queue.add(hh*60 + mm);
		}
		//탑승자 배열
		ArrayList<Integer> list = null;
		for(int i = 0; i < n; i++) {
			list = new ArrayList<Integer>();//새 버스가 왔으니 탑승자 초기화
			while(!queue.isEmpty()) {
				int queuePoll = queue.poll();
				if(queuePoll <= startTime && list.size() < m) {
					list.add(queuePoll);
				} else {
					queue.add(queuePoll);
					break;//다 탔음
				}
				answer = queuePoll-1;
			}
			
			//배차간격 추가
			startTime += t;
		}
		//마지막 버스 비었을때
		if(list.size() < m) {
			answer = startTime - t;
		}
		String result = String.format("%02d:%02d", answer/60 , answer%60);

        return result;
    }
}
