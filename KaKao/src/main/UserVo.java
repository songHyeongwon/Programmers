package main;

import java.util.Comparator;

public class UserVo implements Comparable<UserVo>{
	int id;//���̵�
	int grade;//����
	int winCnt;//����
	int from; //��Ī�� ��ٸ� �ð�
	int loseCnt;//����
	
	int totalGameTaken;//�� ���ӽð�
	
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
