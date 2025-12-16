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
		startDate = LocalDate.parse("2025-12-12", formatter);
		String temp = "C:/Users/iks16/eclipse-workspace/Programmers/";
		ArrayList<String> list = new ArrayList<String>();
		list.add(temp + "JavaUtilProject/bin/utilPackage/BaekJoonProblemSync.class");
		list.add(temp + "Doit/bin/chap08/BMmatch.class");
		list.add(temp + "Doit/bin/Practice/chap08/BMmatchEx_08_04.class");
		list.add(temp + "JavaUtilProject/bin/utilPackage/CreateGitBat.class");
		list.add(temp + "JavaUtilProject/src/utilPackage/CreateGitBat.java");
		list.add(temp + "BaekJoon/bin/step22/Main1018.class");
		list.add(temp + "BaekJoon/bin/step52/Main1316.class");
		list.add(temp + "BaekJoon/bin/step16/Main1463.class");
		list.add(temp + "BaekJoon/bin/step18/Main1929.class");
		list.add(temp + "BaekJoon/bin/step02/Main2566.class");
		list.add(temp + "BaekJoon/bin/OUTTER/Main3053.class");
		list.add(temp + "BaekJoon/bin/step34/Main14888.class");
		list.add(temp + "BaekJoon/bin/step34/Main14889.class");
		list.add(temp + "BaekJoon/bin/step51/Main17298.class");
		list.add(temp + "BaekJoon/bin/step52/Main25083.class");
		list.add(temp + "JavaUtilProject/bin/utilPackage/MoveFile.class");
		list.add(temp + "ProgrammersCode/bin/lavel2/Solution12$Graph.class");
		list.add(temp + "ProgrammersCode/bin/lavel3/Solution12.class");
		list.add(temp + "ProgrammersCode/bin/lavel3/Solution15.class");
		list.add(temp + "ProgrammersCode/bin/lavel3/Solution16.class");
		list.add(temp + "ProgrammersCode/bin/lavel2/Solution24.class");
		list.add(temp + "ProgrammersCode/bin/lavel3/Solution29.class");
		list.add(temp + "ProgrammersCode/bin/lavel2/Solution31.class");
		list.add(temp + "Doit/bin/chap06/SortCalendar.class");
		list.add(temp + "JavaUtilProject/bin/utilPackage/Test1.class");
		list.add(temp + "ProgrammersCode/bin/Test.class");
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
