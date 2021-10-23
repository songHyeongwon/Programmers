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

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getWinCnt() {
		return winCnt;
	}


	public void setWinCnt(int winCnt) {
		this.winCnt = winCnt;
	}


	public int getFrom() {
		return from;
	}


	public void setFrom(int from) {
		this.from = from;
	}


	public int getLoseCnt() {
		return loseCnt;
	}


	public void setLoseCnt(int loseCnt) {
		this.loseCnt = loseCnt;
	}


	public int getTotalGameTaken() {
		return totalGameTaken;
	}


	public void setTotalGameTaken(int totalGameTaken) {
		this.totalGameTaken = totalGameTaken;
	}

	@Override
	public int compareTo(UserVo o) {
		// TODO Auto-generated method stub
		return o.grade - this.grade;
	}
}
