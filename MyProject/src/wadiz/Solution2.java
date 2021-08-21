package wadiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 solution2 = new Solution2();
		String[] code = {"a=3", "..a=4", "..b=3", "..print a", ".......a=6", ".......print a", ".......print b", "..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a"};
		System.out.println(Arrays.toString(solution2.solution(code)));
 	}
	static HashMap<String, String> codeMap = new HashMap<String, String>();
	
	public String[] solution(String[] code) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < code.length; i++) {
        	int index = 0; //.ÀÇ °¹¼ö
        	String key = "";
        	String value = ""; 
        	
        	if(code[i].indexOf("print") > -1) {
        		index = ((int)code[i].chars().filter(c -> c == '.').count());
				if(index == 0) {
					index = 1;
				}
				key = code[i].split(" ")[1];
				result.add(getValue(key, index));
        	} else {
        		index = ((int)code[i].chars().filter(c -> c == '.').count());
				if(index == 0) {
					index = 1;
				}
				key = code[i].split("=")[0].replaceAll("[.]", "");
				value = code[i].split("=")[1];
				codeMap.put(getKey(key, index), value);
        	}
        	
		}
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
        	answer[i] = result.get(i);
        }
        return answer;
	}
	private String getValue(String key, int index) {
		if(index == 0) return "error";
		
		if(codeMap.get(getKey(key, index)) != null) {
			return key+"="+codeMap.get(getKey(key, index));
		}
		return getValue(key , index-1);
	}
	public String getKey(String key, int index) {
		String result = key;
		for (int i = 0; i < index; i++) {
			result = "."+result; 
		}
		return result;
	}
}
