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
	//메인 설정
	String HOST_URL = "https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users";
	String token = "bd3c0c5b9600175d3bb4bc60b3d4da81";
	String auth_key = "";
	
	public JSONObject startApi(int problem) {
	    HttpURLConnection conn = null;
	    JSONObject responseJson = null;
	    
	    try {
	        //URL 설정
	        URL url = new URL(this.HOST_URL + "/start");

	        conn = (HttpURLConnection) url.openConnection();
	        //Request 형식 설정
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("X-Auth-Token", this.token);
	        conn.setRequestProperty("Content-Type", "application/json");

	        //request에 JSON data 준비
	        conn.setDoOutput(true);
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	        //commands라는 JSONArray를 담을 JSONObject 생성
	        JSONObject commands = new JSONObject();
	        commands.put("problem", problem);
	        //request에 쓰기
	        bw.write(commands.toString());
	        bw.flush();
	        bw.close();
	        
	        //보내고 결과값 받기
	        int responseCode = conn.getResponseCode();
	        if (responseCode == 400) {
	            System.out.println("400:: 해당 명령을 실행할 수 없음 (실행할 수 없는 상태일 때, 엘리베이터 수와 Command 수가 일치하지 않을 때, 엘리베이터 정원을 초과하여 태울 때)");
	        } else if (responseCode == 401) {
	            System.out.println("401:: X-Auth-Token Header가 잘못됨");
	        } else if (responseCode == 500) {
	            System.out.println("500:: 서버 에러, 문의 필요");
	        } else { // 성공 후 응답 JSON 데이터받기
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
	        //URL 설정
	        URL url = new URL(this.HOST_URL + "/" + apiType);

	        conn = (HttpURLConnection) url.openConnection();
	        //Request 형식 설정
	        conn.setRequestMethod(method);
	        
	        conn.setRequestProperty("Authorization", this.auth_key);
	        conn.setRequestProperty("Content-Type", "application/json");
	        
	        if(commands != null) {
	        	//request에 JSON data 준비
		        conn.setDoOutput(true);
		        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		        //request에 쓰기
		        bw.write(commands.toString());
		        bw.flush();
		        bw.close();
	        }
	        
	        //보내고 결과값 받기
	        int responseCode = conn.getResponseCode();
	        if (responseCode != 200) {
	        	System.out.println(responseCode + " / " + conn.getResponseMessage());
	        } else { // 성공 후 응답 JSON 데이터받기
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
        String token = "YOUR_ACCESS_TOKEN";// 네아로 접근 토큰 값";
        String header = "Bearer " + token; // Bearer 다음에 공백 추가
        try {
            String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
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
