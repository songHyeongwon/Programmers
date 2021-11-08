package lavel1;

import java.util.HashMap;

public class Solution5 {
	public static void main(String[] args) {
		String[] table = {
				"SI JAVA JAVASCRIPT SQL PYTHON C#", 
				"CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", 
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", 
				"PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", 
				"GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"PYTHON", "C++", "SQL"};
		int[] preference = {7, 5, 5};
		System.out.println(new Solution5().solution(table, languages, preference));
	}
	
	public String solution(String[] table, String[] languages, int[] preference) {
        String answer = ""; //������ ���� ���� ����
        int point = 0;		//���� ���� ����
        //���� ���������
        HashMap<String, Integer> languagePreMap = new HashMap<String, Integer>();
        for (int i = 0; i < preference.length; i++) {
        	languagePreMap.put(languages[i], preference[i]);
		}
        
        //��� �迭�� ��
        for (int i = 0; i < table.length; i++) {
        	int temp = 0;
			String tableRow = table[i];
        	String[] rowSplit = tableRow.split(" ");
        	for (int j = 1; j < rowSplit.length; j++) {
				if(languagePreMap.get(rowSplit[j]) != null) {
					temp += languagePreMap.get(rowSplit[j]) * (rowSplit.length-j);
				}
			}
        	
        	//����Ʈ ���
        	if(temp > point) {
        		point = temp;
        		answer = rowSplit[0];
        	} else if(temp == point) {
        		if(answer.compareTo(rowSplit[0]) > 0) {
        			point = temp;
            		answer = rowSplit[0];
        		}
        	}
		}
        
        return answer;
    }
}
