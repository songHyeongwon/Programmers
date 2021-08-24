package lavel2;
//https://programmers.co.kr/learn/courses/30/lessons/42883?language=java
public class Solution9 {
	public static void main(String[] args) {
		String number = "987698769876987698769876987698769876987698769876987698769876";
		int k = 2;
		System.out.println(new Solution9().solution(number, k));
	}
	
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
