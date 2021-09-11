package kakao;

public class Solution2 {
	public static void main(String[] args) {
		for(int i = 1; i <= 1000000 ; i++) {
			for(int j = 3; j <= 10; j++) {
				System.out.println(i+ " / "+j);
				System.out.println(new Solution2().solution(i , j));
			}
		}
	}
	
	public int solution(int n, int k) {
        int answer = 0;
        
        String[] kWlstn = getKString(n, k).split("0");
        for(int i = 0; i< kWlstn.length; i++) {
        	if(!kWlstn[i].equals("") && isThtn(kWlstn[i])) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	private boolean isThtn(String string) {
		long checkNum = Long.parseLong(string);
		if(checkNum == 1) return false;
		
		for(int i = 2; i <= Math.sqrt(checkNum); i++) {
			if(checkNum % i == 0) return false;
		}
		
		return true;
	}
	public String getKString (int n , int k) {
		String ans ="";
		
		while(n>0) {
			ans = (n % k) + ans;
			n /= k;
		}
		return ans;
	}
}
