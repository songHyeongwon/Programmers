package OUTTER;

import java.util.HashSet;

public class Main4673 {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < 10000; i++) {
			set.add(getD(i));
		}
		for (int i = 1; i < 10000; i++) {
			if(!set.contains(i)) {
				System.out.println(i);
			}
		}
	}
	public static int getD(int i) {
		int result = i;
		String temp = String.valueOf(i);
		for (int j = 0; j < temp.length(); j++) {
			result += Character.getNumericValue(temp.charAt(j));
		}
		return result; 
	}
}
