package step09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// 선언
		int n = Integer.parseInt(br.readLine());

		ArrayList<Point> list = new ArrayList<Point>();
		String[] an = br.readLine().split(" ");
		for (int i = 0; i < an.length; i++) {
			Point point = new Point();
			point.idx = i;
			point.num = Integer.parseInt(an[i]);
			list.add(point);
		}
		// 숫자순 정렬
		list.sort((p1, p2) -> {
			return p1.num - p2.num;
		});
		// 좌표 압축
		list.get(0).temp = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1).num == list.get(i).num) {
				list.get(i).temp = list.get(i - 1).temp;
			} else {
				list.get(i).temp = list.get(i - 1).temp + 1;
			}
		}
		// 인덱스 순 정렬
		list.sort((p1, p2) -> {
			return p1.idx - p2.idx;
		});
		// 출~력
		for (Point a : list) {
			bw.write(a.toString());
		}
		br.close();
		bw.close();
	}
}

class Point {
	int idx;
	int num;
	int temp;

	@Override
	public String toString() {
		return temp + " ";
	}
}
