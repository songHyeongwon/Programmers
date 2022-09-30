package jobis3o3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution4 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		System.out.println(Arrays.toString(sol.solution(3, new int[][] {{1,4},{2,2},{1,3},{1,6},{3,-1},{2,-1}})));
		System.out.println(Arrays.toString(sol.solution(4, new int[][] {{1,3},{1,2},{3,6},{3,-1},{4,5},{2,-1},{3,-1},{1,-1}})));
		System.out.println(Arrays.toString(sol.solution(5, new int[][] {{1,-1},{2,-1},{3,-1},{4,-1},{5,-1}})));
	}
	
    public int[] solution(int n, int[][] queries) {
    	int baseNum = -1;
    	Deque<Integer>[] stacks = new Deque[n];
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i < stacks.length; i++) {
    		stacks[i] = new LinkedList<Integer>();
		}
    	
    	for (int i = 0; i < queries.length; i++) {
    		int stackIdx = queries[i][0] - 1;
    		int num = queries[i][1];
    		
			if(num == -1) {
				//POP
				if(stacks[stackIdx].isEmpty()) {
					list.add(baseNum);
					//앞번호 스택을 가져와야함
					int newBaseNum = -1;
					for (int j = 1; j < stacks.length; j++) {
						if(!stacks[(stackIdx + j) % stacks.length].isEmpty()) {
							newBaseNum = stacks[(stackIdx + j) % stacks.length].removeFirst();
							break;
						}
					}
					baseNum = newBaseNum;
					continue;
				}
				list.add(stacks[stackIdx].removeLast());
			} else {
				//PUSH
				if(baseNum == -1) {
					baseNum = num;
					continue;
				}
				stacks[stackIdx].addLast(num);
			}
		}
    	//반환
    	int idx = 0;
    	int[] answer = new int[list.size()];
    	for(int i : list) {
    		answer[idx++] = i;
    	}
    	return answer;
    }
}