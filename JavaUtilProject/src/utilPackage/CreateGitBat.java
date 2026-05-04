package utilPackage;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//일일 배치 파일을 생성합니다.
public class CreateGitBat {
	private static String filePath = "C:/Users/iks16/eclipse-workspace/gitbat/";
	private static String fileMine = ".bat";
	private static LocalDate startDate = null;
	private static DateTimeFormatter formatter = null;
	public static void main(String[] args) throws Exception{
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		startDate = LocalDate.parse("2026-05-03", formatter);
		String temp = "C:/Users/iks16/eclipse-workspace/Programmers/";
		ArrayList<String> list = new ArrayList<String>();
		list.add(temp + "JavaUtilProject/src/utilPackage/AnimeUtil.java");
		list.add(temp + "JavaUtilProject/bin/utilPackage/CreateGitBat.class");
		list.add(temp + "JavaUtilProject/src/utilPackage/CreateGitBat.java");
		list.add(temp + "JavaUtilProject/bin/llb/jsoup-1.15.4.jar");
		list.add(temp + "JavaUtilProject/src/llb/jsoup-1.15.4.jar");
		list.add(temp + "BaekJoon/src/OUTTER/Main1002.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1003.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1004.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1010.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1011.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1021.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1065.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main10250.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main10718.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main10757.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main10828.java");
		list.add(temp + "JavaUtilProject/bin/module-info.class");
		list.add(temp + "JavaUtilProject/src/module-info.java");
		list.add(temp + "JavaUtilProject/src/utilPackage/NyaaNextEpisodeFinder.java");
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
	    
	    buf.append("cd C:\\Users\\iks16\\eclipse-workspace\\Programmers\n\n");
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
