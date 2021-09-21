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
	//���� ����
	String HOST_URL = "https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users";
	String token = "bd3c0c5b9600175d3bb4bc60b3d4da81";
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
	    //System.out.println(responseJson.toString());
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
	    System.out.println(responseJson.toString());
	    return responseJson;
	}

    /*public static void main(String[] args) {
        String token = "YOUR_ACCESS_TOKEN";// �׾Ʒ� ���� ��ū ��";
        String header = "Bearer " + token; // Bearer ������ ���� �߰�
        try {
            String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // ���� ȣ��
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // ���� �߻�
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/
}
