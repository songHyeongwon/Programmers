package kakao2;

public class Solution1 {
    public static int solution(int x, int y, int z) {
        int k = Math.max(y,x);
        int abs = Math.abs(x - y);
        if(abs > z) return -1;
        if(abs == z) return k;
        System.out.println(String.format("%d %d %d %d", x , y , z , abs));
        z -= abs;
        k += z/2;
        //k -= abs / 2;
        return k;
    }
}
//633356 633357
//100000006
//100000005