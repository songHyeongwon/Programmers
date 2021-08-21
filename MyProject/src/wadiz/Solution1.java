package wadiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class Solution1 {
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int[][] passwords = {{101,1234},{102,54321},{201,202},{202,1}};
		String s = "101#1234#102#654321#51#203#201#202#1#";
		
		System.out.println(solution1.solution(passwords, s));
 	}
	
	public int solution(int[][] passwords, String s) {
        int answer = 0;
        HashMap<Integer, Integer> passwordMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < passwords.length; i++) {
        	passwordMap.put(passwords[i][0], passwords[i][1]);
		}
        
        String[] sna = s.split("#");
        
        for (int i = 0; i < sna.length; i++) {
			if(i % 2 ==0 && i+1 < sna.length) {
				int ghtn = Integer.parseInt(sna[i]); 
				int pass = Integer.parseInt(sna[i+1]);
				if(passwordMap.get(ghtn) != null && passwordMap.get(ghtn) == pass) {
					answer++;
				}
			}
		}
        
        return answer;
    }
}
