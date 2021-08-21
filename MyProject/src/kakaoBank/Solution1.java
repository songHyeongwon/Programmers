package kakaoBank;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Solution {
    public int solution(String[] deposits) {
        int answer = 0;
        for (int i = 0; i < deposits.length; i++) {
            Solution2 add = new Solution2(deposits[i]);
            answer += add.sumMoney;
        }
        System.out.println(answer);
        return answer;
    }
    class Solution2{
        public String day;//일자
        public double R;//금리
        public int money;//돈
        public int sumMoney;
        public Solution2(String k) {
            String[] splits = k.split(" ");
            this.day = splits[0];
            this.R = 0.01 * Integer.parseInt(splits[1]);
            this.money = Integer.parseInt(splits[2]);
            //확인용 출력문
            //System.out.println(this.day +" "+ this.R + " / " + this.money +" / "+(getWeekOfYear(this.day)));
            this.sumMoney = this.money + (int)((double)(this.money * this.R) * ((double)(getWeekOfYear(this.day)) / 365));
        }
        //오늘이 1년에서 몇일지 지났는지
        private int getWeekOfYear(String s_date) {
            try {
                Calendar getToday = Calendar.getInstance();
                Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse("2021/12/31");//2021년도는 윤년이 없다
                getToday.setTime(date1); //금일 날짜
                Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse("2021/"+s_date);//년도를 더해준다.
                Calendar cmpDate = Calendar.getInstance();
                cmpDate.setTime(date2); //특정 일자
                long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
                long diffDays = diffSec / (24*60*60); //일자수 차이
                return (int)diffDays;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}