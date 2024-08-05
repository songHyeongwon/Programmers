package OUTTER;

import java.util.HashMap;
import java.util.Scanner;

public class Main9375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int N = sc.nextInt();
			for (int j = 0; j < N; j++) {
				String[] arr = new String[2];
				arr[0] = sc.next();
				arr[1] = sc.next();
				if(map.containsKey(arr[1])) {
					map.put(arr[1], map.get(arr[1])+1);
				} else {
					map.put(arr[1], 1);
				}
			}
			int mapSize = 1;
			for(String k : map.keySet()) {
				mapSize *= map.get(k)+1;//안입는 경우 +1
			}
			System.out.println(mapSize -1);//다안입는 경우 제외 -1
		}
		
		sc.close();
	}
}
