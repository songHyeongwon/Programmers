package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {

		Controller controller = new Controller();		
		controller.startController(1);//시나리오 1:2
		
		while(true) {
			controller.process();
			//서버상태 finished 시 정지
			if(controller.status.equals("finished")) {
				break;
			}
		}
		//최종 유저상태 확인용
		controller.getUserInfo();
		//결과 확인
		controller.getScore();
	}
}
