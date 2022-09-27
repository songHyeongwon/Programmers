package jobis3o3;

import java.util.Arrays;
import java.util.Collections;


public class Solution1 {
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		String[] arr = {"AAALLLAPAA", "AAAAAAAPPP", "ALAAAAPAAA"};
		System.out.println(Arrays.toString(sol.solution(arr)));
		String[] arr1 = {"ALALLAAPAA", "ALLLAAAPAA", "APAPALLAAA"};
		System.out.println(Arrays.toString(sol.solution(arr1)));
	}
	
    public int[] solution(String[] students) {
    	Student[] attendArr = new Student[students.length];
        int[] answer = new int[students.length];
    	int idx = 0;
    	for(String s : students) {
    		attendArr[idx++] = new Student(idx , s);
    	}
    	
    	Arrays.sort(attendArr , Collections.reverseOrder());
    	
		for (int i = 0; i < answer.length; i++) {
			answer[i] = attendArr[i].num;
		}
        return answer;
    }
    
    class Student implements Comparable<Student>{
    	int num;
    	int attend;
    	public Student(int num, int attend) {
    		this.num = num;
    		this.attend = attend;
    	}
    	public Student(int num, String s) {
    		this.num = num;
    		this.attend = resultAttend(s);
    	}
    	@Override
    	public int compareTo(Student o) {
    		return attend - o.attend;
    	}
    	public int resultAttend(String s) {
        	int result = 10;
        	int tardyCnt = 0;
        	int absentCnt = 0;
        	for (int i = 0; i < s.length(); i++) {
    			switch (s.charAt(i)) {
    			case 'A':
    				result++;
    				break;
    			case 'L':
    				tardyCnt++;
    				break;
    			case 'P':
    				absentCnt++;
    				break;
    			}
    		}
        	absentCnt += (tardyCnt/2);
        	if(absentCnt >= 3) return 0;
        	
        	return result - absentCnt;
        }
    }
}
