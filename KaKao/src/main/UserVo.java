package main;

import java.util.Comparator;

public class UserVo implements Comparable<UserVo>{
	int id;//아이디
	int grade;//점수
	int winCnt;//연승
	int from; //매칭을 기다린 시간
	int loseCnt;//연패
	
	int totalGameTaken;//총 게임시간
	
	public void addGrade(int parst) {
		this.grade += parst;
		if(this.grade <= 0) {
			this.grade = 0;
		}
		if(this.grade >= 9999) {
			this.grade = 9999;
		}
		
	}


	@Override
	public int compareTo(UserVo o) {
		// TODO Auto-generated method stub
		return o.grade - this.grade;
	}
}
