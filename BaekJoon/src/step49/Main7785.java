package step49;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main7785 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new TreeSet<>();
		int N = sc.nextInt();

		while (N-- > 0) {
			String name = sc.next();
			String status = sc.next();

			if (status.equals("enter"))
				set.add(name);
			else
				set.remove(name);
		}
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		for (String s : list)
			System.out.println(s);
		sc.close();
	}
}
