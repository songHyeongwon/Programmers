package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.crypto.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
	String HOST_URL = "https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users";
	String token = "bd3c0c5b9600175d3bb4bc60b3d4da81";
	
	public static void main(String[] args) {
		Main main = new Main();
		
		System.out.println(main.actionAPI(null).toString());
	}
	
	public JSONObject actionAPI(JSONArray commandlist) {
	    HttpURLConnection conn = null;
	    JSONObject responseJson = null;
	    
	    try {
	        //URL ����
	        URL url = new URL(this.HOST_URL + "/action");

	        conn = (HttpURLConnection) url.openConnection();
	        //Request ���� ����
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("X-Auth-Token", this.token);
	        conn.setRequestProperty("Content-Type", "application/json");

	        //request�� JSON data �غ�
	        conn.setDoOutput(true);
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	        //commands��� JSONArray�� ���� JSONObject ����
	        JSONObject commands = new JSONObject();
	        commands.put("commands", commandlist);
	        //request�� ����
	        bw.write(commands.toString());
	        bw.flush();
	        bw.close();
	        
	        //������ ����� �ޱ�
	        int responseCode = conn.getResponseCode();
	        if (responseCode == 400) {
	            System.out.println("400:: �ش� ����� ������ �� ���� (������ �� ���� ������ ��, ���������� ���� Command ���� ��ġ���� ���� ��, ���������� ������ �ʰ��Ͽ� �¿� ��)");
	        } else if (responseCode == 401) {
	            System.out.println("401:: X-Auth-Token Header�� �߸���");
	        } else if (responseCode == 500) {
	            System.out.println("500:: ���� ����, ���� �ʿ�");
	        } else { // ���� �� ���� JSON �����͹ޱ�
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            StringBuilder sb = new StringBuilder();
	            String line = "";
	            while ((line = br.readLine()) != null) {
	                sb.append(line);
	            }
	            
	            responseJson = new JSONObject(sb.toString());
	            
	        }
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JSONException e) {
	        System.out.println("not JSON Format response");
	        e.printStackTrace();
	    }
	    return responseJson;
	}
}
