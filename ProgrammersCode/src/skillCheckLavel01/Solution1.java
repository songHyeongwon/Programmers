package skillCheckLavel01;

public class Solution1 {
	boolean solution(String s) {
        boolean answer = true;

        int countP = 0;
        int countY = 0;
        char[] arr = s.toUpperCase().toCharArray();

        for(int i = 0; i< arr.length; i++) {
            if(arr[i] == 'P') countP++;
            if(arr[i] == 'Y') countY++;
        }
        if(countP == countY) answer = true; else answer = false;
        return answer;
    }
}
