package jobis3o3;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		int[][] arr1 = {
				{2, 3, 4, 0, 1}, 
				{1, 4, 3, 2, 0}, 
				{4, 1, 0, 2, 3}, 
				{3, 2, 1, 4, 0}, 
				{0, 3, 2, 1, 4}};
		int[][] arr2 = {{2, 1, 0, 3}, {3, 2, 0, 1}, {3, 0 ,2, 1}, {2, 3, 0, 1}};
		Solution2 sol = new Solution2();
		//System.out.println(Arrays.toString(sol.solution(arr1)));
		System.out.println(Arrays.toString(sol.solution(arr2)));
	}
	

	static int stdentCnt;
	static int halfCnt;
	static int cnt;
	static boolean[] isCheck;
    public int[] solution(int[][] orders) {
    	cnt = 0;
    	stdentCnt = orders.length;
    	isCheck = new boolean[stdentCnt];
    	if(stdentCnt % 2 == 0) {
    		halfCnt = stdentCnt/2;
    	} else {
    		halfCnt = stdentCnt/2 + 1;
    	}
    	
    	int result = getResult(orders); //득표자
        int[] answer = new int[2];
        answer[0] = cnt;
        answer[1] = result;
        return answer;
    }
    //재귀로 득표자를 뽑자
    public int getResult(int[][] orders) {
    	cnt++;
    	int[] orderArr = new int[stdentCnt];
    	for (int i = 0; i < orders.length; i++) {
            //가장 처음 선호도 부터 득표자가 살아있다면 ++
			for (int j = 0; j < orders[i].length; j++) {
				//해당 학생이 살아 있다면
				if(!isCheck[orders[i][j]]) {
					orderArr[orders[i][j]]++;
					break;
				}
			}
		}
    	int minOrder = stdentCnt; //가장 적게 받은 표 초기화
    	//절반 넘은 사람 있다면 반환
    	for (int i = orderArr.length -1; i > 0; i--) {
			if(orderArr[i] >= halfCnt) return i;
			if(!isCheck[i]) {
				minOrder = Math.min(minOrder, orderArr[i]);
			}
		}
    	//탈락자 선별
    	for (int i = 0; i < orderArr.length; i++) {
    		if(!isCheck[i] && orderArr[i] == minOrder) {
    			isCheck[i] = !isCheck[i];
    			break;
    		}
		}

    	return getResult(orders);
    }
}