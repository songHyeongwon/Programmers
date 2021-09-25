package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiAction {
	//���⵵ ���� ���� �ּ�
	//���� ����
	String HOST_URL = "https://huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod";
	String token = "8a751668e3a962d6bfb3fd2cf4033c8d";
	String auth_key = "";
	
	public JSONObject startApi(int problem) {
	    HttpURLConnection conn = null;
	    JSONObject responseJson = null;
	    
	    try {
	        //URL ����
	        URL url = new URL(this.HOST_URL + "/start");

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
	        commands.put("problem", problem);
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
	    System.out.println(responseJson.toString());
	    return responseJson;
	}
	public JSONObject actionAPI(String apiType, String method, JSONObject commands) {
	    HttpURLConnection conn = null;
	    JSONObject responseJson = null;
	    
	    try {
	        //URL ����
	        URL url = new URL(this.HOST_URL + "/" + apiType);

	        conn = (HttpURLConnection) url.openConnection();
	        //Request ���� ����
	        conn.setRequestMethod(method);
	        
	        conn.setRequestProperty("Authorization", this.auth_key);
	        conn.setRequestProperty("Content-Type", "application/json");
	        
	        if(commands != null) {
	        	//System.out.println("SEND ~ "+apiType +"="+ commands.toString());
	        	//request�� JSON data �غ�
		        conn.setDoOutput(true);
		        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		        //request�� ����
		        bw.write(commands.toString());
		        bw.flush();
		        bw.close();
	        }
	        
	        //������ ����� �ޱ�
	        int responseCode = conn.getResponseCode();
	        if (responseCode != 200) {
	        	System.out.println(responseCode + " / " + conn.getResponseMessage());
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
	    //System.out.println("RESULT ~ "+apiType +"="+ responseJson.toString());
	    return responseJson;
	}
}
