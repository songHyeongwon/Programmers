package kakao2;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
	public static void main(String[] args) {
		List<Integer> box = new ArrayList<>();
		box.add(4);
		box.add(1);
		box.add(5);
		box.add(6);
		box.add(7);
		solution(box);
	}
	public static int solution(List<Integer> box) {
		long sums = 0;
        System.out.println("box size = " + box.size());
        for (int i = 0; i < box.size(); i++) {
            sums += box.get(i);
        }
        int temp = Math.round((float) sums / box.size());
        System.out.println("temp = " + temp);
        
        System.out.println("t");
        for (int i = box.size() -1; i >= 1; i--) {
        	if(i == 1) {
        		while(box.get(i) > box.get(i-1)) {
        			box.set(i, box.get(i) - 1);
        			box.set(i -1, box.get(i-1) + 1);
        		}
        		break;
        	}
        	
        	if(box.get(i) > temp) {
        		int x = box.get(i) - temp;
        		box.set(i, box.get(i) - x);
        		box.set(i-1, box.get(i-1) + x);
        		System.out.println(x + " / " + i + " / " + (i-1));
        	}
        }

        
        System.out.println(box.toString());
        int result = box.get(0);
        for (int i = 1; i < box.size(); i++) {
            result = Math.max(result , box.get(i));
        }
        return result;
    }

    public static boolean isNext(List<Integer> box) {
        for (int i = 1; i < box.size(); i++) {
            if(box.get(0) < box.get(i)) return true;
        }
        return false;
    }
}
/*
 * Test shortcuts Skip to main content ALL 3. �� �ű�� ������ �˹ٻ� �Ҹ��� �Ϸķ� ������ n ���� ����
 * �迭 box �� ��� ���� �ٽ� ���� �������� �մϴ�.
 * 
 * �� ���ڴ� 1���� �����ϴ� ���� ������ �ε����� �����ϴ�.
 * 
 * �Ҹ���� ������ ���� �������θ� ���� �ű� �� ������, �� ������ �� ���ʰ� �����մϴ�.
 * 
 * 2 �� i �� n �� �����ϴ� i �� ���ϴ�. 1 �� x �� box[i] �� �����ϴ� x �� ���ϴ�. i ��° �ڽ����� x �� ��ŭ��
 * ���� �����ϴ�. ( box[i] = box[i] - x ) i-1 ��° �ڽ��� ���� x �� ��ŭ�� ���� �ֽ��ϴ�. ( box[i-1] =
 * box[i-1] + x ) �Ҹ����� ������ �ű�� ������ ���� �� ��� ���� �� ���� ���� ���� ���ڿ� �� ���� ������ ���� ����������
 * ���� �ű�� ���Դϴ�.
 * 
 * ���������� ���� �� �ִ� ���� ���� ���� ���ڿ� �� �ּ����� �� ������ ���ϼ���.
 * 
 * 
 * 
 * Example
 * 
 * n = 4
 * 
 * box = [1, 5, 7, 6]
 * 
 * 
 * 
 * ������ �ű�� ������ ������ �����ϴ�. (�迭 box �� 1���� ���۵Ǵ� �ε����� ����մϴ�.)
 * 
 * ù ��° �ű�� : i = 3, x = 4 ���� (x �� 1 �� x �� box[i] ������ �����մϴ�. 4 < 7) i ��° �ڽ����� x
 * �� ��ŭ�� ���� �����ϴ�. (7 - 4 = 3) i-1 ��° �ڽ��� ���� x �� ��ŭ�� ���� �ֽ��ϴ�. (5 + 4 = 9) �迭 box
 * �� ���� [1, 9, 3, 6] �� �Ǿ����ϴ�. (���� ���� ���� ���ڿ� �� �� ������ 9�Դϴ�) �� ��° �ű�� : i = 2, x =
 * 4 ���� i ��° �ڽ����� x �� ��ŭ�� ���� �����ϴ�. (9 - 4 = 5) i-1 ��° �ڽ��� ���� x �� ��ŭ�� ���� �ֽ��ϴ�. (1
 * + 4 = 5) �迭 box �� ���� [5, 5, 3, 6] �� �Ǿ����ϴ�. (���� ���� ���� ���ڿ� �� �� ������ 6�Դϴ�) �� ��°
 * �ű��: i = 4, x = 1 ����, �ű� �� ����� [5, 5, 4, 5] �Դϴ�. (���� ���� ���� ���ڿ� �� �� ������ 5�Դϴ�)
 * 
 * 
 * ���� ���� ���� ���ڿ� �� �ּ����� �� ������ �� ��° �ű�� ������ 5 �Դϴ�.
 * 
 * 
 * 
 * Function Description
 * 
 * �Ʒ� �����⿡�� solution �Լ��� �����ϼ���.
 * 
 * solution �Լ��� ���� ���ڸ� �����ϴ�.
 * 
 * int box[n]: ���� �迭
 * 
 * 
 * 
 * Returns
 * 
 * int: box �迭�� ������ �ִ� �� ���� ���� ��
 * 
 * 
 * 
 * Constraints
 * 
 * 1 �� n �� 105 1 �� box[i] �� 109
 * 
 * 
 * Input Format For Custom Testing Sample Case 0 Sample Input For Custom Testing
 * 
 * STDIN FUNCTION ----- -------- 3 �� n = 3 5 �� box = [5, 15, 19] 15 19 Sample
 * Output
 * 
 * 13 Explanation
 * 
 * 
 * 
 * ������ �ű�� ������ ������ �����ϴ�.
 * 
 * ù ��° �ű�� : i = 3, x = 6 -> [5, 21, 13]. �� ��° �ű�� : i = 2, x = 8 -> [13 ,13,
 * 13].
 * 
 * 
 * Sample Case 1 Sample Input For Custom Testing
 * 
 * STDIN FUNCTION ----- -------- 4 �� n = 4 10 �� box = [10, 3, 5, 7] 3 5 7 Sample
 * Output
 * 
 * 10 Explanation
 * 
 * 
 * 
 * �� ��� �ű�� �ൿ���� ���� ���� ���ڿ� �� �ּ����� �� ������ ���� ����� �����ϴ�.
 */
