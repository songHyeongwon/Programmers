package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.json.JSONArray;
import org.json.JSONObject;

public class Controller {
	
	ApiAction api = new ApiAction();//Api 실행용 액션
	String status = "";//서버의 상태 finished면 종료
	int time = 0;//현재시간
	ArrayList<UserVo> userList = new ArrayList<>();//유저정보를 담는 ArrayList
	Queue<UserVo> updateQueue = new LinkedList<>();//업데이트 해야하는 유저의 큐
	PriorityQueue<UserVo> waitingQueue = new PriorityQueue<>();//대기열 큐
	
	//최초 시작시 컨트롤러
	public void startController(int problem) {
		JSONObject startResult = this.api.startApi(problem);
		this.api.auth_key = startResult.getString("auth_key");
		this.time = startResult.getInt("time");
		
		addUserList();
		
		JSONObject WaitingLine = this.api.actionAPI("waiting_line", "GET", null); //대기열
		JSONArray arr = WaitingLine.getJSONArray("waiting_line");
		if(arr.length() == 0) {
			addTime();
		}
	}
	
	//메인이 움직이는 프로세스 실행
	public void process() {
		System.out.println("현재시간은~"+this.time);
		this.updateQueue.clear();//큐를 비우고
		updateGameResult();//게임 결과로 유저리스트 업데이트 및 큐에 적재
		changeGrade();//점수 반영
		
		//매칭 리스트 가져오기
		waiting();
		//매칭 해주기
		match();
	}
	
	private void match() {
		// TODO Auto-generated method stub
		ArrayList<int[]> list = new ArrayList<>();
		
		while(!this.waitingQueue.isEmpty() && this.waitingQueue.size() >= 2) {
			UserVo vo1 = waitingQueue.poll();
			UserVo vo2 = waitingQueue.poll();
			//매칭 된다
			if(isMatch(vo1 , vo2)) {
				vo1.from = 0;
				vo2.from = 0;
				list.add(new int[] {vo1.id ,vo2.id});
			} else {
				//아닐경우 아래것을 넣고 다시 시도
				waitingQueue.add(vo2);
			}
		}
		int[][] arr = new int[list.size()][2];
		
		for(int i = 0; i< arr.length; i++) {
			arr[i] = list.get(i);
		}
		
 		JSONObject obj = new JSONObject();
		obj.put("pairs", arr);
		JSONObject match = api.actionAPI("match", "PUT", obj); //빈 배열 보내서 단순 진행
		this.status = match.getString("status");
		this.time = match.getInt("time");
	}

	private boolean isMatch(UserVo vo1, UserVo vo2) {
		// TODO Auto-generated method stub
		boolean result = false;
		int score = 10;//기본 매칭 점수범위는 10점
		//기다린 시간에 따라 점수범위가 점점 커지게끔 하자
		score += vo1.from * 3;
		// 9000 과 7400점일 경우 9000 -7400 <= 1000 +a 대기시간 3분뒤면 매칭
		if(vo1.grade - vo2.grade <= score) {
			result = true;
		}
		//System.out.println("isMatch "+result+ " " +vo1.grade + " / "+ vo2.grade);
		return result;
	}

	private void waiting() {
		// TODO Auto-generated method stub
		this.waitingQueue.clear();
		JSONObject WaitingLine = this.api.actionAPI("waiting_line", "GET", null); //대기열
		JSONArray arr = WaitingLine.getJSONArray("waiting_line");
		if(arr.length() == 0) {
			addTime();
		} else {
			for(int i =0; i< arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				userList.get(obj.getInt("id")-1).from = obj.getInt("from");//대기시간 갱신
				waitingQueue.add(userList.get(obj.getInt("id")-1));
			}
		}
	}

	//최초의 유저 정보를 모두 담는다
	public void addUserList() {
		JSONObject userInfo = api.actionAPI("user_info", "GET", null); //유저정보
		JSONArray arr = userInfo.getJSONArray("user_info");
		for(int i = 0; i < arr.length(); i++) {
			JSONObject obj = arr.getJSONObject(i);
			UserVo vo = new UserVo();
			vo.id = obj.getInt("id");
			//초기 실력을 평균으로 해보자
			vo.grade = 3000; //obj.getInt("grade");
			//연승 연패 조건
			vo.loseCnt = 0;
			vo.winCnt = 0;
			vo.totalGameTaken = 0;
			userList.add(vo);
		}
	}
	
	//빈배열을 보내서 단순하게 시간만 진행시킨다.
	public void addTime() {
		JSONObject obj = new JSONObject();
		obj.put("pairs", new int[1][2]);
		JSONObject match = api.actionAPI("match", "PUT", obj); //빈 배열 보내서 단순 진행
		this.status = match.getString("status");
		this.time = match.getInt("time");
	}

	private void updateGameResult() {
		// TODO Auto-generated method stub
		JSONObject gameResult = this.api.actionAPI("game_result", "GET", null); //게임결과
		JSONArray arr = gameResult.getJSONArray("game_result");
		for (int i = 0; i < arr.length(); i++) {
			JSONObject obj = arr.getJSONObject(i);
			UserVo winner = userList.get(obj.getInt("win")-1);//승자 Vo
			UserVo loser = userList.get(obj.getInt("lose")-1);//패자 Vo
			
			int[] prese = getGrade(winner, loser);//추가점
			winner.winCnt++;
			winner.loseCnt = 0;
			loser.loseCnt++;
			loser.winCnt = 0;
			winner.addGrade(prese[0] + (winner.winCnt * winner.winCnt));//연승 가산치(중복값을 피하려는것이 목적)
			if(loser.loseCnt > 5) {//패직자 방지용 5연패 이상 이라면 가중치를 줄인다 계속 연패한다면 0에 수렴
				//System.out.println("패작 ID = "+ loser.loseCnt +"연패중 " + loser.id + " / " + prese[1] + " 이지만" + (prese[1] / loser.loseCnt));
				if(loser.loseCnt < 10) {//10연패부터는 점수변동 없음
					loser.addGrade(-1*(prese[1] / loser.loseCnt));
				}
			}
			
			winner.totalGameTaken += obj.getInt("taken");
			loser.totalGameTaken += obj.getInt("taken");
			this.updateQueue.add(winner);
			this.updateQueue.add(loser);
		}
		
	}
	
	//점수 변경
	public void changeGrade() {
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		while(!this.updateQueue.isEmpty()) {
			UserVo vo = this.updateQueue.poll();
			JSONObject value = new JSONObject();
			value.put("grade", vo.grade);
			value.put("id", vo.id);
			arr.put(value);
		}
		if(arr.length() != 0) {
			obj.put("commands", arr);
			JSONObject change_grade = api.actionAPI("change_grade", "PUT", obj);
			this.status = change_grade.getString("status");
		}
	}
	
	//점수의 가중치를 계산합니다.
	public int[] getGrade(UserVo winner, UserVo loser) {
		//출처 http://www.todayhumor.co.kr/board/view.php?table=lol&no=439218
		int[] result = new int[2];
		
		int winnerPrese = (winner.grade * 100) / (winner.grade + loser.grade);
		int loserPrese = (loser.grade * 100) / (winner.grade + loser.grade);
		
		result[0] = (winner.grade * (100 - winnerPrese)) / (100 * 5);
		result[1] = (loser.grade * (100 - loserPrese)) / (100 * 5);
		
		return result;
	}
	public void getUserInfo() {
		// TODO Auto-generated method stub
		JSONObject userInfo = api.actionAPI("user_info", "GET", null); //유저정보
		System.out.println(userInfo.toString());
	}
	public void getScore() {
		// TODO Auto-generated method stub
		JSONObject score = api.actionAPI("score", "GET", null); //빈 배열 보내서 단순 진행
		System.out.println(score.toString());
	}
}
