package wadiz;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution3 {
static int answer = 0;
	
	public int solution(int[] arr) {
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
        // set.size() <= answer < arr.length
		answer = set.size();
		for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
			int minValue = iterator.next();
			checkArr(arr , minValue);
		}
		return answer;
    }
	
	public void checkArr(int[] arr, int min) {
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == min) {
				arr[i] = -1;
				count++;
			}
		}
        //�и��� �迭��ŭ ī����
		if(count > 2) {
			answer += (count-2);
		}
        //�⺻�� 0�̱� ������ 0�� ī���Ϳ��� ����
		if(min == 0) {
			answer--;
		}
		System.out.println(Arrays.toString(arr));
	}
}
