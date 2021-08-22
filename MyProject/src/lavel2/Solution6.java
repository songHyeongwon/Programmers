package lavel2;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/70129
public class Solution6 {
	public static void main(String[] args) {
		String s = "1111111";
		System.out.println(Arrays.toString(new Solution6().solution(s)));
	}
	
	static int processCnt = 0;	//���μ��� ����Ƚ��
	static int zeroCnt = 0; 	//0�� ����
	
	public int[] solution(String s) {
		//�ݺ����� ��ȯ
		if(s.equals("1")) return new int[]{processCnt , zeroCnt};
		//���μ��� ���� , 0�� ���� +=
		processCnt++;
		zeroCnt += ((int)s.chars().filter(c -> c == '0').count());
		//0 ġȯ�� ���� => ������ ��ȯ
		s = s.replaceAll("0", "");
		String s2 = Integer.toBinaryString(s.length());
        
        return solution(s2);
    }
}
