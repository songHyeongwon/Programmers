package step11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main28279 {
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // ��ɾ��� ��

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());

			switch (order) {
			case 1: // ��ɾ� 1 X : ���� �տ� �ִ´�
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case 2: // ��ɾ� 2 X : ���� �ڿ� �ִ´�
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case 3: // ��ɾ� 3 : ���� �� ���� ������ ���� ����Ѵ�.(���ٸ� -1)
				sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
				break;
			case 4: // ��ɾ� 4 : ���� �� ���� ������ ���� ����Ѵ�.(���ٸ� -1)
				sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
				break;
			case 5: // ��ɾ� 5 : ���� ����ִ� ������ ���� ���
				sb.append(deque.size()).append("\n");
				break;
			case 6: // ��ɾ� 6 : ���� ��������� 1 ��� ������� ������ 0
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
				break;
			case 7: // ��ɾ� 7 : ���� ������ �ִٸ� �� ���� ������ ���(���ٸ� -1)
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
				break;
			case 8: // ��ɾ� 8 : ���� ������ �ִٸ� �� ���� ������ ���(���ٸ� -1)
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
				break;
			}
		}
		br.close();
		System.out.println(sb);
	}

}
