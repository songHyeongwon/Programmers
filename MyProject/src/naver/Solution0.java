package naver;
//테스트 솔루션
import java.util.HashSet;

public class Solution0 {
	public static void main(String[] args) {
		int[] A = {1 ,2 ,3};
		System.out.println(new Solution0().solution(A));
	}
	public int solution(int[] A) {
		int result = 1;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < A.length; i++) {
			if(A[i] > 0 ) set.add(A[i]);
		}
		for (int i = 1; i <= set.size()+1; i++) {
			if(!set.contains(i)) {
				result = i;
				break;
			}
		}
		return result;
    }
}
