package lavel3;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/17678?language=java
public class Solution8 {
	public static void main(String[] args) {
		String[] arr = 	{"09:10", "09:09", "08:00"};
		System.out.println(new Solution8().solution(2, 10, 2, arr));
	}
	/*��Ʋ ���� Ƚ�� n
	, ��Ʋ ���� ���� t
	, �� ��Ʋ�� Ż �� �ִ� �ִ� ũ�� �� m
	, ũ�簡 ��⿭�� �����ϴ� �ð��� ���� �迭 timetable�� �Է����� �־�����.*/
	public String solution(int n, int t, int m, String[] timetable) {
		
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		//9�� ����
		int startTime = 9*60;
		for(int i = 0; i< timetable.length; i++) {
			int hh = Integer.parseInt(timetable[i].split(":")[0]);
			int mm = Integer.parseInt(timetable[i].split(":")[1]);
			queue.add(hh*60 + mm);
		}
		//ž���� �迭
		ArrayList<Integer> list = null;
		for(int i = 0; i < n; i++) {
			list = new ArrayList<Integer>();//�� ������ ������ ž���� �ʱ�ȭ
			while(!queue.isEmpty()) {
				int queuePoll = queue.poll();
				if(queuePoll <= startTime && list.size() < m) {
					list.add(queuePoll);
				} else {
					queue.add(queuePoll);
					break;//�� ����
				}
				answer = queuePoll-1;
			}
			
			//�������� �߰�
			startTime += t;
		}
		//������ ���� �������
		if(list.size() < m) {
			answer = startTime - t;
		}
		String result = String.format("%02d:%02d", answer/60 , answer%60);

        return result;
    }
}
