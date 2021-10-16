package devMatching;

public class Solution2 {
	public static void main(String[] args) {
		int[] arr = {6, 21};
		System.out.println(new Solution2().solution(15, "FRI", arr));
	}
	
	static String[] days = {"SUN" , "MON" , "TUE" , "WED" , "THU" , "FRI" , "SAT"};
	static int AllMax = 0;
	
	public int solution(int leave, String day, int[] holidays) {
		
		boolean[] isholidays = new boolean[32];
		//공휴일 넣어주고
		for (int i = 0; i < holidays.length; i++) {
			isholidays[holidays[i]] = true;
		}
		
		int firstDay = 0;
		for (int i = 0; i < days.length; i++) {
			if(days[i].equals(day)) {
				firstDay = i;
				break;
			}
		}
		
		for(int i = 0; i < 30; i++) {
			if(days[(firstDay+i) % 7].equals("SAT") || days[(firstDay+i) % 7].equals("SUN")) {
				isholidays[i+1] = true;
			}
		}
        getAnswer(isholidays , leave);
        return AllMax;
    }

	private void getAnswer(boolean[] isholidays, int leave) {
        int count = 0;//안 쉬는날
		for (int i = 0; i < isholidays.length-1; i++) {
			if(!isholidays[i]) count++;
		}
        //휴가일이 더 많다
		if(count <= leave) {
			AllMax = 30;
			return;
		}
		
		if(leave == 0) {//탐색종료
			AllMax = Math.max(AllMax, getMax(isholidays));
			System.out.println(AllMax);
			return;
		}
		
		for(int i = 1; i < isholidays.length-1; i++) {
			//본인이 false면서 앞뒤로 휴가가 있을때만
			if(!isholidays[i] && (isholidays[i-1] || isholidays[i+1])) {
				isholidays[i] = true;
				getAnswer(isholidays , leave-1);
				isholidays[i] = false;
			}
		}
	}

	private int getMax(boolean[] isholidays) {
		// TODO Auto-generated method stub
		int max = 0;
		int temp = 0;
		for (int i = 1; i < isholidays.length; i++) {
			if(isholidays[i]) {
				temp++;
			} else {
				max = Math.max(max, temp);
				temp = 0;
			}
		}
		
		return max;
	}
}
