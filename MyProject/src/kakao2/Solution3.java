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
 * Test shortcuts Skip to main content ALL 3. 빵 옮기기 편의점 알바생 죠르디가 일렬로 나열된 n 개의 상자
 * 배열 box 에 담긴 빵을 다시 나눠 담으려고 합니다.
 * 
 * 각 상자는 1부터 시작하는 양의 정수를 인덱스로 가집니다.
 * 
 * 죠르디는 다음과 같은 과정으로만 빵을 옮길 수 있으며, 이 과정은 몇 차례건 가능합니다.
 * 
 * 2 ≤ i ≤ n 을 만족하는 i 를 고릅니다. 1 ≤ x ≤ box[i] 를 만족하는 x 를 고릅니다. i 번째 박스에서 x 개 만큼의
 * 빵을 꺼냅니다. ( box[i] = box[i] - x ) i-1 번째 박스에 꺼낸 x 개 만큼의 빵을 넣습니다. ( box[i-1] =
 * box[i-1] + x ) 죠르디의 업무는 옮기는 과정이 끝난 후 모든 상자 중 가장 빵이 많은 상자에 든 빵의 개수가 가장 적어지도록
 * 빵을 옮기는 일입니다.
 * 
 * 최종적으로 얻을 수 있는 빵이 가장 많은 상자에 든 최소한의 빵 개수를 구하세요.
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
 * 최적의 옮기기 순서는 다음과 같습니다. (배열 box 는 1부터 시작되는 인덱싱을 사용합니다.)
 * 
 * 첫 번째 옮기기 : i = 3, x = 4 선택 (x 는 1 ≤ x ≤ box[i] 조건을 만족합니다. 4 < 7) i 번째 박스에서 x
 * 개 만큼의 빵을 꺼냅니다. (7 - 4 = 3) i-1 번째 박스에 꺼낸 x 개 만큼의 빵을 넣습니다. (5 + 4 = 9) 배열 box
 * 는 이제 [1, 9, 3, 6] 이 되었습니다. (빵이 가장 많은 상자에 든 빵 개수는 9입니다) 두 번째 옮기기 : i = 2, x =
 * 4 선택 i 번째 박스에서 x 개 만큼의 빵을 꺼냅니다. (9 - 4 = 5) i-1 번째 박스에 꺼낸 x 개 만큼의 빵을 넣습니다. (1
 * + 4 = 5) 배열 box 는 이제 [5, 5, 3, 6] 이 되었습니다. (빵이 가장 많은 상자에 든 빵 개수는 6입니다) 세 번째
 * 옮기기: i = 4, x = 1 선택, 옮긴 후 결과는 [5, 5, 4, 5] 입니다. (빵이 가장 많은 상자에 든 빵 개수는 5입니다)
 * 
 * 
 * 빵이 가장 많은 상자에 든 최소한의 빵 개수는 세 번째 옮기기 이후의 5 입니다.
 * 
 * 
 * 
 * Function Description
 * 
 * 아래 편집기에서 solution 함수를 구현하세요.
 * 
 * solution 함수는 다음 인자를 갖습니다.
 * 
 * int box[n]: 정수 배열
 * 
 * 
 * 
 * Returns
 * 
 * int: box 배열의 가능한 최댓값 중 가장 작은 값
 * 
 * 
 * 
 * Constraints
 * 
 * 1 ≤ n ≤ 105 1 ≤ box[i] ≤ 109
 * 
 * 
 * Input Format For Custom Testing Sample Case 0 Sample Input For Custom Testing
 * 
 * STDIN FUNCTION ----- -------- 3 → n = 3 5 → box = [5, 15, 19] 15 19 Sample
 * Output
 * 
 * 13 Explanation
 * 
 * 
 * 
 * 최적의 옮기기 순서는 다음과 같습니다.
 * 
 * 첫 번째 옮기기 : i = 3, x = 6 -> [5, 21, 13]. 두 번째 옮기기 : i = 2, x = 8 -> [13 ,13,
 * 13].
 * 
 * 
 * Sample Case 1 Sample Input For Custom Testing
 * 
 * STDIN FUNCTION ----- -------- 4 → n = 4 10 → box = [10, 3, 5, 7] 3 5 7 Sample
 * Output
 * 
 * 10 Explanation
 * 
 * 
 * 
 * 이 경우 옮기는 행동으로 가장 많은 상자에 든 최소한의 빵 개수를 줄일 방법은 없습니다.
 */
