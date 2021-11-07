package skillCheckLavel03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution02 {
	public static void main(String[] args) {
		String[] arr = {".ZI.", "M.**", "MZU.", ".IU."};
		
		System.out.println(new Solution02().solution(4, 4, arr));
	}
	char[][] arr = null;
	int m ,n;
	HashMap<Character, int[][]> map = new HashMap<>();
	ArrayList<Character> list = new ArrayList<Character>();
	public String solution(int m, int n, String[] board) {
		arr = new char[m][n];
		this.m = m;
		this.n = n;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				char temp = board[i].charAt(j);
				arr[i][j] = temp;
				if(temp != '.' && temp != '*') {
					if(!list.contains(temp)) {
						list.add(temp);
						int[][] newIntArr = new int[2][2];
						newIntArr[0][0] = i;
						newIntArr[0][1] = j;
						map.put(temp, newIntArr);
					} else {
						map.get(temp)[1][0] = i;
						map.get(temp)[1][1] = j;
					}
				}
			}
		}
		//정렬
		Collections.sort(list);
        String answer = "";
		int index = 0;
		while(list.size() != 0) {
			if(isCheck(list.get(index))) {
				char pro = list.remove(index);
				answer+=pro;
				deleteChar(pro);
				index = 0;
			} else {
				index++;
				if(index == list.size()) {
					return "IMPOSSIBLE";
				}
			}
		}
		

        return answer;
    }
	//블럭을 지웠다
	void deleteChar(char a){
        arr[map.get(a)[0][0]][map.get(a)[0][1]] = '.';
        arr[map.get(a)[1][0]][map.get(a)[1][1]] = '.';
    }
	boolean isCheck(Character a) {
        int r1 = map.get(a)[0][0];
        int c1 = map.get(a)[0][1];
        int r2 = map.get(a)[1][0];
        int c2 = map.get(a)[1][1];
        
        if(c1 < c2){
            if(linearColumnCheck(c1, c2, r1, a) && linearRowCheck(r1, r2, c2, a)){
                return true;
            }
            if(linearRowCheck(r1, r2, c1, a) && linearColumnCheck(c1, c2, r2, a)){
                return true;
                }
        }else{
            if(linearRowCheck(r1, r2, c2, a) && linearColumnCheck(c2, c1, r1, a)){
                return true;
            }
            if(linearColumnCheck(c2, c1, r2, a) && linearRowCheck(r1, r2, c1, a)){
                return true;
            }
        }
        return false;
	}
    boolean linearRowCheck(int r1, int r2, int c, char a){
        for(int i = r1; i < r2+1; i++){
            if(arr[i][c] != '.' && arr[i][c] != a)
                return false;
        }
        return true;
    }
    
    boolean linearColumnCheck(int c1, int c2, int r, char a){
        for(int i = c1; i < c2+1; i++){
            if(arr[r][i] != '.' && arr[r][i] != a)
                return false;
        }
        return true;
    }
}
