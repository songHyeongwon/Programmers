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
		controller.startController(1);//�ó����� 1:2
		
		while(true) {
			controller.process();
			//�������� finished �� ����
			if(controller.status.equals("finished")) {
				break;
			}
		}
		//���� �������� Ȯ�ο�
		controller.getUserInfo();
		//��� Ȯ��
		controller.getScore();
	}
}
