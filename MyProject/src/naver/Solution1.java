package naver;

public class Solution1 {
	public static void main(String[] args) {
		//a b c d e f g h i j k l m n o p q r s t u v w x y z
		System.out.println(new Solution1().solution("aaaa"));
	}
	
	public String solution(String S) {
		String ansert = "";
		for (int i = 0; i < S.length(); i++) {
			//�Ѱ� ���� ���ڰ� ���ۺ��� �ռ��� ����
			if(S.compareTo(S.substring(0 , i) + S.substring(i+1)) > 0) {
				ansert = S.substring(0 , i) + S.substring(i+1);
				break;
			};
		}
		//aaaaa���� �� ���� ���� ó��
		if(ansert.equals("")) ansert = S.substring(1);
		return ansert;
    }
}
