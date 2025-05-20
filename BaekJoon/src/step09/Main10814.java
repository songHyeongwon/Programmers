package step09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// ¼±¾ð

		int n = Integer.parseInt(br.readLine());
		ArrayList<User> list = new ArrayList<User>();

		for (int i = 0; i < n; i++) {
			User user = new User();
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			user.idx = i;
			user.age = Integer.parseInt(token.nextToken());
			user.name = token.nextToken();
			list.add(user);
		}

		list.sort((u1, u2) -> {
			if (u1.age == u2.age) {
				return u1.idx - u2.idx;
			} else {
				return u1.age - u2.age;
			}
		});

		for (User a : list) {
			bw.write(a.age + " " + a.name + "\n");
		}

		br.close();
		bw.close();
	}
}

class User {
	int idx;
	int age;
	String name;
}
