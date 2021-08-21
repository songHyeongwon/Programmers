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
        public String day;//����
        public double R;//�ݸ�
        public int money;//��
        public int sumMoney;
        public Solution2(String k) {
            String[] splits = k.split(" ");
            this.day = splits[0];
            this.R = 0.01 * Integer.parseInt(splits[1]);
            this.money = Integer.parseInt(splits[2]);
            //Ȯ�ο� ��¹�
            //System.out.println(this.day +" "+ this.R + " / " + this.money +" / "+(getWeekOfYear(this.day)));
            this.sumMoney = this.money + (int)((double)(this.money * this.R) * ((double)(getWeekOfYear(this.day)) / 365));
        }
        //������ 1�⿡�� ������ ��������
        private int getWeekOfYear(String s_date) {
            try {
                Calendar getToday = Calendar.getInstance();
                Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse("2021/12/31");//2021�⵵�� ������ ����
                getToday.setTime(date1); //���� ��¥
                Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse("2021/"+s_date);//�⵵�� �����ش�.
                Calendar cmpDate = Calendar.getInstance();
                cmpDate.setTime(date2); //Ư�� ����
                long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
                long diffDays = diffSec / (24*60*60); //���ڼ� ����
                return (int)diffDays;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}