package lavel3;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/43238
public class Solution14 {
	public static void main(String[] args) {
		int[] times = {7,10};
		
		System.out.println(new Solution14().solution(6, times));
	}
	//����Ž��
	public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = times[0];
		long max = (long) n * times[times.length-1];
        long answer = max;
        
        while(min <= max) {//�ּҰ� �ִ뺸�� �������ȸ�
        	long mid = (max + min)/2;
        	long check = isCheck(mid , times);
        	if(check < n) {
        		//�ð� ���̱�
            	min = mid + 1; //(max + min)/2 +1;
        	} else {
        		//�ð� ���̱�
        		max = mid - 1; //(max + min)/2 -1;
        		answer = Math.min(mid, answer); //�ּҰ����� �׻� ����
        	}
        }
        return answer;
    }
	
	private long isCheck(long mid, int[] times) {
		long result = 0;
		for(int i=0; i < times.length; i++) {
			result += mid / times[i];
		}
		return result;
	}
}
