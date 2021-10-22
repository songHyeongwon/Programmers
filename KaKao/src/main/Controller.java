package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.json.JSONArray;
import org.json.JSONObject;

public class Controller {
	
	ApiAction api = new ApiAction();//Api ����� �׼�
	String status = "";//������ ���� finished�� ����
	int time = 0;//����ð�
	ArrayList<UserVo> userList = new ArrayList<>();//���������� ��� ArrayList
	Queue<UserVo> updateQueue = new LinkedList<>();//������Ʈ �ؾ��ϴ� ������ ť
	PriorityQueue<UserVo> waitingQueue = new PriorityQueue<>();//��⿭ ť
	
	//���� ���۽� ��Ʈ�ѷ�
	public void startController(int problem) {
		JSONObject startResult = this.api.startApi(problem);
		this.api.auth_key = startResult.getString("auth_key");
		this.time = startResult.getInt("time");
		
		addUserList();
		
		JSONObject WaitingLine = this.api.actionAPI("waiting_line", "GET", null); //��⿭
		JSONArray arr = WaitingLine.getJSONArray("waiting_line");
		if(arr.length() == 0) {
			addTime();
		}
	}
	
	//������ �����̴� ���μ��� ����
	public void process() {
		System.out.println("����ð���~"+this.time);
		this.updateQueue.clear();//ť�� ����
		updateGameResult();//���� ����� ��������Ʈ ������Ʈ �� ť�� ����
		changeGrade();//���� �ݿ�
		
		//��Ī ����Ʈ ��������
		waiting();
		//��Ī ���ֱ�
		match();
	}
	
	private void match() {
		// TODO Auto-generated method stub
		ArrayList<int[]> list = new ArrayList<>();
		
		while(!this.waitingQueue.isEmpty() && this.waitingQueue.size() >= 2) {
			UserVo vo1 = waitingQueue.poll();
			UserVo vo2 = waitingQueue.poll();
			//��Ī �ȴ�
			if(isMatch(vo1 , vo2)) {
				vo1.from = 0;
				vo2.from = 0;
				list.add(new int[] {vo1.id ,vo2.id});
			} else {
				//�ƴҰ�� �Ʒ����� �ְ� �ٽ� �õ�
				waitingQueue.add(vo2);
			}
		}
		int[][] arr = new int[list.size()][2];
		
		for(int i = 0; i< arr.length; i++) {
			arr[i] = list.get(i);
		}
		
 		JSONObject obj = new JSONObject();
		obj.put("pairs", arr);
		JSONObject match = api.actionAPI("match", "PUT", obj); //�� �迭 ������ �ܼ� ����
		this.status = match.getString("status");
		this.time = match.getInt("time");
	}

	private boolean isMatch(UserVo vo1, UserVo vo2) {
		// TODO Auto-generated method stub
		boolean result = false;
		int score = 10;//�⺻ ��Ī ���������� 10��
		//��ٸ� �ð��� ���� ���������� ���� Ŀ���Բ� ����
		score += vo1.from * 3;
		// 9000 �� 7400���� ��� 9000 -7400 <= 1000 +a ���ð� 3�еڸ� ��Ī
		if(vo1.grade - vo2.grade <= score) {
			result = true;
		}
		//System.out.println("isMatch "+result+ " " +vo1.grade + " / "+ vo2.grade);
		return result;
	}

	private void waiting() {
		// TODO Auto-generated method stub
		this.waitingQueue.clear();
		JSONObject WaitingLine = this.api.actionAPI("waiting_line", "GET", null); //��⿭
		JSONArray arr = WaitingLine.getJSONArray("waiting_line");
		if(arr.length() == 0) {
			addTime();
		} else {
			for(int i =0; i< arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				userList.get(obj.getInt("id")-1).from = obj.getInt("from");//���ð� ����
				waitingQueue.add(userList.get(obj.getInt("id")-1));
			}
		}
	}

	//������ ���� ������ ��� ��´�
	public void addUserList() {
		JSONObject userInfo = api.actionAPI("user_info", "GET", null); //��������
		JSONArray arr = userInfo.getJSONArray("user_info");
		for(int i = 0; i < arr.length(); i++) {
			JSONObject obj = arr.getJSONObject(i);
			UserVo vo = new UserVo();
			vo.id = obj.getInt("id");
			//�ʱ� �Ƿ��� ������� �غ���
			vo.grade = 3000; //obj.getInt("grade");
			//���� ���� ����
			vo.loseCnt = 0;
			vo.winCnt = 0;
			vo.totalGameTaken = 0;
			userList.add(vo);
		}
	}
	
	//��迭�� ������ �ܼ��ϰ� �ð��� �����Ų��.
	public void addTime() {
		JSONObject obj = new JSONObject();
		obj.put("pairs", new int[1][2]);
		JSONObject match = api.actionAPI("match", "PUT", obj); //�� �迭 ������ �ܼ� ����
		this.status = match.getString("status");
		this.time = match.getInt("time");
	}

	private void updateGameResult() {
		// TODO Auto-generated method stub
		JSONObject gameResult = this.api.actionAPI("game_result", "GET", null); //���Ӱ��
		JSONArray arr = gameResult.getJSONArray("game_result");
		for (int i = 0; i < arr.length(); i++) {
			JSONObject obj = arr.getJSONObject(i);
			UserVo winner = userList.get(obj.getInt("win")-1);//���� Vo
			UserVo loser = userList.get(obj.getInt("lose")-1);//���� Vo
			
			int[] prese = getGrade(winner, loser);//�߰���
			winner.winCnt++;
			winner.loseCnt = 0;
			loser.loseCnt++;
			loser.winCnt = 0;
			winner.addGrade(prese[0] + (winner.winCnt * winner.winCnt));//���� ����ġ(�ߺ����� ���Ϸ��°��� ����)
			if(loser.loseCnt > 5) {//������ ������ 5���� �̻� �̶�� ����ġ�� ���δ� ��� �����Ѵٸ� 0�� ����
				//System.out.println("���� ID = "+ loser.loseCnt +"������ " + loser.id + " / " + prese[1] + " ������" + (prese[1] / loser.loseCnt));
				if(loser.loseCnt < 10) {//10���к��ʹ� �������� ����
					loser.addGrade(-1*(prese[1] / loser.loseCnt));
				}
			}
			
			winner.totalGameTaken += obj.getInt("taken");
			loser.totalGameTaken += obj.getInt("taken");
			this.updateQueue.add(winner);
			this.updateQueue.add(loser);
		}
		
	}
	
	//���� ����
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
	
	//������ ����ġ�� ����մϴ�.
	public int[] getGrade(UserVo winner, UserVo loser) {
		//��ó http://www.todayhumor.co.kr/board/view.php?table=lol&no=439218
		int[] result = new int[2];
		
		int winnerPrese = (winner.grade * 100) / (winner.grade + loser.grade);
		int loserPrese = (loser.grade * 100) / (winner.grade + loser.grade);
		
		result[0] = (winner.grade * (100 - winnerPrese)) / (100 * 5);
		result[1] = (loser.grade * (100 - loserPrese)) / (100 * 5);
		
		return result;
	}
	public void getUserInfo() {
		// TODO Auto-generated method stub
		JSONObject userInfo = api.actionAPI("user_info", "GET", null); //��������
		System.out.println(userInfo.toString());
	}
	public void getScore() {
		// TODO Auto-generated method stub
		JSONObject score = api.actionAPI("score", "GET", null); //�� �迭 ������ �ܼ� ����
		System.out.println(score.toString());
	}
}
