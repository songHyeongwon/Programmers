package kakaoBank;

import java.util.ArrayList;


class Solution2 {
    public int solution(int[][] needs, int r) {
        if(needs[0].length <= r) return needs.length;
        //needs[0].length 에서 R개를 뽑은 경우를 반환 받는다
        ArrayList<String> result = new ArrayList<>();
        //부품수와 로봇수
        result = getResult(needs[0].length, r);
        int answer = 0;
        for (int i = 0; i < result.size(); i++) {
            answer = Math.max(answer, getResultCnt(needs , result.get(i)));
        }
        System.out.println(answer);
        return answer;
    }
    //경우의 수들을 뽑아낸다
    private ArrayList<String> getResult(int length, int r) {
        ArrayList<String> result = new ArrayList<>();
        int cout = 0;
        for(int i=0; i<(length*length*length*length); i++){
            String binaryString = Integer.toBinaryString(i);
            binaryString = ("000000000000000000000000000000000" + binaryString);
            binaryString = binaryString.substring(binaryString.length() -length, binaryString.length());
            for (int j = 0; j < binaryString.length(); j++) {
                if(binaryString.charAt(j) == '1') {
                    cout++;
                }
            }
            if(cout != r) {
                cout = 0;
            } else {
                result.add(binaryString);
                cout = 0;
            }
        }
        return result;
    }
    //배열와 기계의 경우를 넣고 검사
    private int getResultCnt(int[][] needs, String resultString) {
        int resultCnt = 0;
        boolean collect = false;
        String[] result = resultString.split("");
        for (int i = 0; i < needs.length; i++) {
            for (int j = 0; j < needs[i].length; j++) {
                if(needs[i][j] != 0) {
                    if(needs[i][j] != Integer.parseInt(result[j])) {
                        collect = false;
                        break;
                    }
                } else {
                    collect = true;
                }
                collect = true;
            }
            if(collect) {
                resultCnt++;
                collect = false;
            }
        }
        return resultCnt;
    }
}