package lavel3;
//https://programmers.co.kr/learn/courses/30/lessons/12900?language=java
public class Solution13 {
	public static void main(String[] args) {
		System.out.println(new Solution13().solution(4));
	}
	
	public int solution(int n) {
		//������ �������� �ܼ��� �Ǻ���ġ �����ϻ��̴�.
		//1~8���������� �����غ��鼭 ������ ã�ƺ���
		int[] arr = new int [60001];
		arr[1] = 1;
		arr[2] = 2;
		for(int i =3; i< arr.length; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
		}
		
        return arr[n];
    }
}
