package lavel2;
//https://programmers.co.kr/learn/courses/30/lessons/12985
public class Solution16 {
	public static void main(String[] args) {
		
		System.out.println(new Solution16().solution(8, 4, 3));
	}
	
	public int solution(int n, int a, int b) {
		//return Integer.toBinaryString((a-1)^(b-1)).length();
        int answer = 0;
        
        while(true) {
        	if(a==b) {
        		break;
        	} else {
        		answer++;
        	}
        	n /=2;
        	if(a%2==1) {
        		a = (a+1)/2;
        	} else {
        		a /=2;
        	}
        	if(b%2==1) {
        		b = (b+1)/2;
        	} else {
        		b /=2;
        	}
        	//System.out.println(a+ " / " +b);
        }
        
        return answer;
    }
}
