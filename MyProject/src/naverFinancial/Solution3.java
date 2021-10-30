package naverFinancial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution3 {
	public static void main(String[] args) {
		String[] arr = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
		System.out.println(Arrays.toString(new Solution3().solution(arr)));
	}
	
	public String[] solution(String[] logs) {
        HashMap<String, User> userMap = new HashMap<String, User>();
        for (int i = 0; i < logs.length; i++) {
			String[] logSplit = logs[i].split(" ");
			if(userMap.containsKey(logSplit[0])) {
				userMap.get(logSplit[0]).map.put(logSplit[1], logSplit[2]);
				userMap.get(logSplit[0]).sumCnt = userMap.get(logSplit[0]).map.size();
			} else {
				User user = new User();
				user.userId = logSplit[0];
				user.map.put(logSplit[1], logSplit[2]);
				userMap.put(logSplit[0], user);
				user.sumCnt = user.map.size();
			}
		}
        //유저정보 누적 종료
        //중복유저 탐색
        ArrayList<User> userList = new ArrayList<User>();
        for(String userId : userMap.keySet()) {
        	System.out.println(userMap.get(userId).toString());
        	userList.add(userMap.get(userId));
        }
        
        HashSet<String> set = new HashSet<String>();
        
        for (int i = 0; i < userList.size(); i++) {
			for (int j = 0; j < userList.size(); j++) {
				if(i!=j) {
					
		        	User user1 = userList.get(i);
		        	User user2 = userList.get(j);
					
					if(user1.getSumCnt() == user2.getSumCnt() && user1.getSumCnt() >= 5) {
		        		if(user1.isCheck(user2)) {
		        			set.add(user1.userId);
		        			set.add(user2.userId);
		        		}
		        	}
				}
			}
		}

        String[] answer = null;
        if(set.size() == 0) {
        	answer = new String[]{"None"};
        } else {
        	answer = new String[set.size()];
        	int idx = 0;
        	for(String id : set) {
        		answer[idx++] = id;
        	}
        	Arrays.sort(answer);
        }
        return answer;
    }
}
class User implements Comparable<User>{
	String userId;
	HashMap<String, String> map = new HashMap<String, String>();
	int sumCnt = 0;
	
	
	public int getSumCnt() {
		return sumCnt;
	}

	public void setSumCnt(int sumCnt) {
		this.sumCnt = sumCnt;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return o.sumCnt - this.sumCnt;
	}
	
	@Override
	public String toString() {
		return userId +" 의 풀이갯수 = " +sumCnt + " "+ map.toString(); 
	}
	
	public boolean isCheck(User o1) {
		for(String k : this.map.keySet()) {
			if(o1.map.containsKey(k)) {
				//점수가 다르면 false
				if(!this.map.get(k).equals(o1.map.get(k))) {
					return false;
				}
			} else {//키가 없다면 문제를 안푼것
				return false;
			}
		}
		return true;
	}
}
