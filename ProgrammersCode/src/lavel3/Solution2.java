package lavel3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//https://programmers.co.kr/learn/courses/30/lessons/17676?language=java
public class Solution2 {
	public static void main(String[] args) {
		//String[] arr = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
		String[] arr = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		System.out.println(new Solution2().solution(arr));
	}
	public int solution(String[] lines) {
        int answer = 0;
        
        ArrayList<Trans> list = new ArrayList<Trans>();
		for(int i = 0; i < lines.length; i++) {
			Trans trans = new Trans(lines[i]);
			list.add(trans);
		}
		
		for(int i = 0; i < list.size(); i++) {
			int cnt = 0;
			long startOfSection = list.get(i).startCal.getTimeInMillis();
			long endOfSection = startOfSection + 1000;
			
			for(int j = 0 ; j < lines.length ; ++j) {
				if(list.get(j).startCal.getTimeInMillis() >= startOfSection && list.get(j).startCal.getTimeInMillis() < endOfSection) {
					cnt++;
				} else if(list.get(j).endCal.getTimeInMillis() >= startOfSection && list.get(j).endCal.getTimeInMillis() < endOfSection) {
					cnt++;
				} else if(list.get(j).startCal.getTimeInMillis() <= startOfSection && list.get(j).endCal.getTimeInMillis() >= endOfSection) {
					cnt++;
				}
			}
			answer = Math.max(answer, cnt);
		}
		
		for(int i = 0; i < list.size(); i++) {
			int cnt = 0;
			long startOfSection = list.get(i).endCal.getTimeInMillis();
			long endOfSection = startOfSection + 1000;
			
			for(int j = 0 ; j < lines.length ; ++j) {
				if(list.get(j).startCal.getTimeInMillis() >= startOfSection && list.get(j).startCal.getTimeInMillis() < endOfSection) {
					cnt++;
				} else if(list.get(j).endCal.getTimeInMillis() >= startOfSection && list.get(j).endCal.getTimeInMillis() < endOfSection) {
					cnt++;
				} else if(list.get(j).startCal.getTimeInMillis() <= startOfSection && list.get(j).endCal.getTimeInMillis() >= endOfSection) {
					cnt++;
				}
			}
			answer = Math.max(answer, cnt);
		}
        
        return answer;
    }
	class Trans {
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		public Trans(String value) {
			try {
				String[] valueSplit = value.split(" ");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				int addTime = (int)(Double.parseDouble(valueSplit[2].replaceAll("s", "")) * 1000);
				endCal.setTime(format.parse(valueSplit[0] + " " + valueSplit[1]));
				startCal.setTimeInMillis(endCal.getTimeInMillis() - addTime +1 );
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	/*static Calendar first;
	
	public int solution(String[] lines) {
		String fristTime =  lines[0];
		String lastTime = lines[lines.length-1];
		//날짜 차이 구하기
		int timeGap = getTimeGap(fristTime, lastTime);
		ArrayList<Trans> list = new ArrayList<Trans>();
		int answer = 0;
		for(int i = 0; i < lines.length; i++) {
			Trans trans = new Trans(lines[i]);
			list.add(trans);
		}
		
		for(int i = 0; i <= timeGap; i++) {
			
			answer = Math.max(answer, getAnswer(list , i));
		}
		
        return answer;
    }
	private int getAnswer(ArrayList<Trans> list, int gap) {
		// TODO Auto-generated method stub
		Calendar thisTime = Calendar.getInstance();
		thisTime.setTimeInMillis(first.getTimeInMillis() + (gap * 1000));
		int result = 0;
		for(int i = 0; i <list.size(); i++) {
			long thisLong = thisTime.getTimeInMillis();
			long starLong = list.get(i).startCal.getTimeInMillis();
			long endLong = list.get(i).endCal.getTimeInMillis();

			
			if(thisLong <= starLong && thisLong + 999 > starLong) {
				System.out.println("1스타트"+list.get(i).startCal.getTime().toString());
				result++;//시작이 안에 있으면
			} else if(thisLong <= endLong && thisLong + 999 > endLong) {
				System.out.println("2엔드"+list.get(i).endCal.getTime().toString());
				result++;//종료가 안에 있으면
			} else if(thisLong >= starLong && thisLong + 999 < endLong) {
				System.out.println("3스타트"+list.get(i).startCal.getTime().toString());
				System.out.println("3엔드"+list.get(i).endCal.getTime().toString());
				result++;//시작 종료가 관통해 있으면
			}
		}
		
		System.out.println(thisTime.getTime().toString()+ " / " + result);
		return result;
	}
	private int getTimeGap(String fristTime, String lastTime) {
		// TODO Auto-generated method stub
		String[] fristArr = fristTime.split(" ");
		String[] lastArr = lastTime.split(" ");
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar fristCal = Calendar.getInstance();
			Calendar lastCal = Calendar.getInstance();
			fristCal.setTime(format.parse(fristArr[0] + " " + fristArr[1]));
			lastCal.setTime(format.parse(lastArr[0] + " " + lastArr[1]));
            long diffSec = (lastCal.getTimeInMillis() - fristCal.getTimeInMillis()) / 1000;
            first = fristCal;
            return (int)diffSec;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	class Trans {
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		public Trans(String value) {
			try {
				String[] valueSplit = value.split(" ");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				int addTime = (int)(Double.parseDouble(valueSplit[2].replaceAll("s", "")) * 1000);
				endCal.setTime(format.parse(valueSplit[0] + " " + valueSplit[1]));
				startCal.setTimeInMillis(endCal.getTimeInMillis() - addTime);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}*/
}
