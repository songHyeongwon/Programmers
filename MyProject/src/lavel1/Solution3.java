package lavel1;

public class Solution3 {
    public int solution(String s) {
        s = s
		.replaceAll("zero", "0")
		.replaceAll("one", "1")
		.replaceAll("two", "2")
		.replaceAll("three", "3")
		.replaceAll("four", "4")
		.replaceAll("five", "5")
		.replaceAll("six", "6")
		.replaceAll("seven", "7")
		.replaceAll("eight", "8")
		.replaceAll("nine", "9");
        int answer = Integer.parseInt(s);
        return answer;
    }
}
