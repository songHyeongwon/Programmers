package devMatching;

import java.util.HashSet;
//Ä¿¹Ô Å×½ºÆ®
public class Solution1 {
	public static void main(String[] args) {
		String[] arr = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"}; 
		
		System.out.println(new Solution1().solution(arr,"cow"));
		
	}
	public String solution(String[] registered_list, String new_id) {
        String answer = new_id;
        String s = new_id.replaceAll("[0-9]", "");
        String n = new_id.replaceAll("[a-z]", "");
        
        int nTemp = 0;
        
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < registered_list.length; i++) {
        	set.add(registered_list[i]);
        }
        
        if(n.length() > 0) {
        	nTemp = Integer.parseInt(n);
        } else {
        	nTemp = 0;
        }
        
        while(!set.add(answer)) {
        	answer = (s + (++nTemp));
        }
        return answer;
    }
}
