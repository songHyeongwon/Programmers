package step7;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String k = sc.next().toUpperCase();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char a = 'A';
		for (int i = 0; i < 26; i++) {
			map.put((char)(a+i), 0);
		}

		for (int i = 0; i < k.length(); i++) {
			map.put(k.charAt(i), map.get(k.charAt(i)) +1);
		}
		
		LinkedList<Entry<Character, Integer>> list = new LinkedList<Entry<Character,Integer>>(map.entrySet());
		Collections.sort(list , new Comparator<Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
				
		if(list.get(0).getValue().equals(list.get(1).getValue())) {
			System.out.println("?");
		} else {
			System.out.println(list.get(0).getKey());
		}
		sc.close();
	}
}
