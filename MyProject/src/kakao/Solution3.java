package kakao;

import java.util.*;

public class Solution3 {
	public static void main(String[] args) {
		//�⺻ �ð�(��)	�⺻ ���(��)	���� �ð�(��)	���� ���(��)
		int[] fees = {180, 5000, 10, 600};
		String[] recores = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		System.out.println(Arrays.toString(new Solution3().solution(fees, recores)));
	}
	
	public int[] solution(int[] fees, String[] records) {
		HashMap<String, Car> map = new HashMap<String, Car>();		
		
		for(int i = 0; i < records.length; i++) {
			String[] recordSplit = records[i].split(" ");
			if(map.get(recordSplit[1]) != null) {
				//�̹� �ִ°�ü
				Car car = map.get(recordSplit[1]);
				if(recordSplit[2].equals("IN")) {
					//�ٽ� ����
					car.isIn = true;
					car.inTime = getTime(recordSplit[0]);
					car.outTime = getTime("23:59");
				} else {
					//����
					car.isIn = false;
					car.outTime = getTime(recordSplit[0]);
					car.allTime += (car.outTime - car.inTime);
				}
			} else {
				//�ּ� ����
				Car car = new Car();
				car.mainTime = fees[0];
				car.mainMouny = fees[1];
				car.subTime = fees[2];
				car.subMoney = fees[3];
				car.carNum = recordSplit[1];
				car.isIn = true;
				car.inTime = getTime(recordSplit[0]);
				car.outTime = getTime("23:59");
				map.put(recordSplit[1], car);
			}
		}
		//�����ؼ� ���
		ArrayList<String> carList = new ArrayList<String>();
		for(String k: map.keySet()) {
			carList.add(k);
		}
		Collections.sort(carList);
        int[] answer = new int[carList.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = map.get(carList.get(i)).getMomey();
        }
        
        return answer;
    }
	class Car {
		int mainTime = 0;
		int mainMouny = 0;
		int subTime = 0;
		int subMoney = 0;
		boolean isIn = false;
		String carNum = "";
		int allTime = 0;
		int inTime = 0;
		int outTime = 0;
		
		public int getMomey() {
			if(this.isIn == true) {
				allTime += (outTime - inTime);
			}
			if(allTime <= mainTime) return mainMouny;
			
			System.out.println(toString());
			int result = this.mainMouny;
			int allsubTime = (int)Math.ceil(((double)(this.allTime - this.mainTime)) / (double)this.subTime);		
			allsubTime *= this.subMoney;
			System.out.println(allsubTime);
			result += allsubTime;
			return result;
		}

		@Override
		public String toString() {
			return "Car [mainTime=" + mainTime + ", mainMouny=" + mainMouny + ", subTime=" + subTime + ", subMoney="
					+ subMoney + ", isIn=" + isIn + ", carNum=" + carNum + ", allTime=" + allTime + ", inTime=" + inTime
					+ ", outTime=" + outTime + "]";
		}

		
	}
	
	public int getTime(String time) {
		//05:34
		int a = Integer.parseInt(time.split(":")[0]);
		int b = Integer.parseInt(time.split(":")[1]);
		
		return (a*60) + b;
	}
}
