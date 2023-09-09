package step04;

import java.util.HashMap;
import java.util.Scanner;

public class Main2480 {
	public static void main(String[] args) {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 3; i++) {
			int temp = sc.nextInt();
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		if(map.size() == 1) {
			int maxNum = 0;
			for (Integer k : map.keySet()) {
				maxNum = Math.max(maxNum, k);
				break;
			}
			result = 10000 + maxNum * 1000;
		} else if(map.size() == 2) {
			int maxNum = 0;
			for (Integer k : map.keySet()) {
				if(map.get(k) == 2) {
					maxNum = k;
				}
			}
			result = 1000 + maxNum * 100;
		} else {
			int maxNum = 0;
			for (Integer k : map.keySet()) {
				maxNum = Math.max(maxNum, k);
			}
			result = maxNum * 100;
		}
		
		System.out.println(result);
		sc.close();
	}
}
