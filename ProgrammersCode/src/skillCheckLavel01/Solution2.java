package skillCheckLavel01;

import java.util.Arrays;

public class Solution2 {
	public long solution(long n) {

        String str = n+"";

        char[] arr = str.toCharArray();

        Arrays.sort(arr);
        str = "";
        System.out.println(arr);
        for(int i =arr.length-1; i >=0 ; i--) {
            str += arr[i];
        }
        System.out.println(str);
        return Long.parseLong(str);

    }
}
