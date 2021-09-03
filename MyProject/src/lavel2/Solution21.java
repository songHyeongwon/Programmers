package lavel2;

//https://programmers.co.kr/learn/courses/30/lessons/64065
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
public class Solution21 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution21().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
	}
	public int[] solution(String s) {
		String[] sSplit = s.replaceAll("[{}]", "").split(","); //Ʃ�� �迭
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();// Ʃ�� ���Ŀ� ��
		ArrayList<Integer> list = new ArrayList<Integer>(); //Ʃ�� ����Ʈ
		
		//�ʿ� ī���� + ����Ʈ �߰�
		for(int i = 0; i < sSplit.length; i++) {
			int sSplitInt = Integer.parseInt(sSplit[i].trim());
			if(!map.containsKey(sSplitInt)) {
				map.put(sSplitInt, 1);
				list.add(sSplitInt);
			} else {
				map.put(sSplitInt, map.get(sSplitInt)+1);
			}
		}
		//�ʿ� �ִ� ī���� ������ ����
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(map.get(o1) > map.get(o2)) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		//�迭 ���� �Է�
        int[] answer = new int[list.size()];
        for(int i =0; i< list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}

