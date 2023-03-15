package utilPackage;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//일일 배치 파일을 생성합니다.
public class CreateGitBat {
	private static String filePath = "C:/Users/iks16/gitbat/";
	private static String fileMine = ".bat";
	private static LocalDate startDate = null;
	private static DateTimeFormatter formatter = null;
	public static void main(String[] args) throws Exception{
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		startDate = LocalDate.parse("2023-03-20", formatter);
		String temp = "C:/Temp/workspace/Programmers/";
		ArrayList<String> list = new ArrayList<String>();
		list.add(temp + "BaekJoon/bin/step11/Main1181.class");
		list.add(temp + "BaekJoon/bin/step11/Main1427.class");
		list.add(temp + "BaekJoon/bin/step11/Main2108.class");
		list.add(temp + "BaekJoon/bin/step11/Main2750.class");
		list.add(temp + "BaekJoon/bin/step11/Main2751.class");
		list.add(temp + "BaekJoon/bin/step11/Main10814.class");
		list.add(temp + "BaekJoon/bin/step11/Main10989.class");
		list.add(temp + "BaekJoon/bin/step11/Main11650.class");
		list.add(temp + "BaekJoon/bin/step11/Main11651.class");
		list.add(temp + "BaekJoon/bin/step11/Main18870.class");
		list.add(temp + "BaekJoon/bin/step11/Main25305.class");
		list.add(temp + "BaekJoon/bin/step11/Point.class");
		list.add(temp + "BaekJoon/bin/step11/User.class");
		list.add(temp + "BaekJoon/bin/step11/Main1874.class");
		list.add(temp + "BaekJoon/bin/step11/Main4949.class");
		list.add(temp + "BaekJoon/bin/step11/Main9012.class");
		list.add(temp + "BaekJoon/bin/step11/Main10773.class");
		list.add(temp + "BaekJoon/bin/step11/Main10828.class");
		list.add(temp + "BaekJoon/bin/step12/Main1269.class");
		list.add(temp + "BaekJoon/bin/step12/Main1620.class");
		list.add(temp + "BaekJoon/bin/step12/Main1764.class");
		list.add(temp + "BaekJoon/bin/step12/Main10815.class");
		list.add(temp + "BaekJoon/bin/step12/Main10816.class");
		list.add(temp + "BaekJoon/bin/step12/Main11478.class");
		list.add(temp + "BaekJoon/bin/step12/Main14425.class");
		list.add(temp + "BaekJoon/bin/step12/Main1021.class");
		list.add(temp + "BaekJoon/bin/step12/Main1966.class");
		list.add(temp + "BaekJoon/bin/step12/Main2164.class");
		list.add(temp + "BaekJoon/bin/step12/Main5430.class");
		list.add(temp + "BaekJoon/bin/step12/Main10866.class");
		list.add(temp + "BaekJoon/bin/step12/Main11866.class");
		list.add(temp + "BaekJoon/bin/step12/Main18258.class");
		list.add(temp + "BaekJoon/bin/step13/Main1002.class");
		list.add(temp + "BaekJoon/bin/step13/Main1004.class");
		list.add(temp + "BaekJoon/bin/step13/Main1085.class");
		list.add(temp + "BaekJoon/bin/step13/Main1358.class");
		list.add(temp + "BaekJoon/bin/step13/Main2477.class");
		list.add(temp + "BaekJoon/bin/step13/Main3009.class");
		list.add(temp + "BaekJoon/bin/step13/Main3053.class");
		list.add(temp + "BaekJoon/bin/step13/Main4153.class");
		list.add(temp + "BaekJoon/bin/step13/Planet.class");
		for(String s : list) {
			printFile(s);
			startDate = startDate.plusDays(1);
		}
	} 
	
	public static void printFile(String file) throws Exception{
		OutputStream output = new FileOutputStream(filePath + startDate.format(formatter) + fileMine);
	    StringBuffer buf = new StringBuffer();
	    String[] pathSplit = file.split("\\\\");
	    String fileName =  pathSplit[pathSplit.length-1];
	    
	    buf.append("cd C:\\Temp\\workspace\\Programmers\n\n");
	    buf.append("git add " + file + "\n");
	    buf.append("git commit -m \"window bat push Programmers " + fileName + "\"\n\n");
	    buf.append("git push origin main\n\n");
	    buf.append("pause");
	    System.out.println(buf.toString());
	    byte[] by= buf.toString().getBytes();
	    output.write(by);
	    output.close();
	}
}
