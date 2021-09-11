package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution1 {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		System.out.println(Arrays.toString(new Solution1().solution(id_list, report, 2)));
	}
	
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> tlsrhSet = new HashSet<String>();
        HashMap<String, Integer> tlsrhMap = new HashMap<String, Integer>();
        
        for(int i = 0; i < report.length; i++) {
        	if(tlsrhSet.add(report[i])) {
        		String repost = report[i].split(" ")[0];//�Ű��ѻ��
        		String pRepost = report[i].split(" ")[1];//�Ű�������
        		upDownArr(id_list , answer , 1, repost);
        		if(tlsrhMap.get(pRepost) != null) {
        			tlsrhMap.put(pRepost, tlsrhMap.get(pRepost) +1);
        		} else {
        			tlsrhMap.put(pRepost, 1);
        		}
        	}
        }
        //�Ű�Ƚ��
        for(String key : tlsrhSet) {
    		String repost = key.split(" ")[0];//�Ű��ѻ��
    		String pRepost = key.split(" ")[1];//�Ű�������        	
    		if(tlsrhMap.get(pRepost) < k) {
    			upDownArr(id_list , answer , -1, repost);
        	}
        }
        
        return answer;
    }
	
	public void upDownArr(String[] id_list , int[] answer , int upDown, String id) {
		for(int i =0; i < id_list.length; i++) {
			if(id_list[i].equals(id)) {
				answer[i] += upDown;
				break;
			}
		}
	}
}
