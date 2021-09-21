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
		ApiAction api = new ApiAction();
		JSONObject startResult = api.startApi(1);
		api.auth_key = startResult.getString("auth_key");
				
		
		while(true) {
			JSONObject bikesJson = api.actionAPI("locations", "GET", null); //지도별 바이크 위치
			JSONObject trucksJson = api.actionAPI("trucks", "GET", null); //트럭의 상황
			
			JSONObject commands = new JSONObject();
			JSONArray jsonArr = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("truck_id", 0);
			obj.put("command", new int[] {2,5,4,6,1});
			jsonArr.put(obj);
			commands.put("commands", jsonArr);
			JSONObject resultMap = api.actionAPI("simulate" , "PUT", commands);
			JSONObject scoreMap = api.actionAPI("score", "GET", null);
			break;
		}
	}
}
