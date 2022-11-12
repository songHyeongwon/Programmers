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
		startDate = LocalDate.parse("2022-11-07", formatter);
		String temp = "C:/Temp/workspace/Programmers/";
		ArrayList<String> list = new ArrayList<String>();
		list.add(temp + "JavaUtilProject/.settings/org.eclipse.jdt.core.prefs");
		list.add(temp + "JavaUtilProject/bin/utilPackage/BaekJoonProblemSync.class");
		list.add(temp + "JavaUtilProject/bin/utilPackage/CreateGitBat.class");
		list.add(temp + "JavaUtilProject/bin/utilPackage/MoveFile.class");
		list.add(temp + "JavaUtilProject/bin/module-info.class");
		list.add(temp + "JavaUtilProject/src/utilPackage/BaekJoonProblemSync.java");
		list.add(temp + "JavaUtilProject/src/utilPackage/CreateGitBat.java");
		list.add(temp + "JavaUtilProject/src/utilPackage/MoveFile.java");
		list.add(temp + "JavaUtilProject/src/module-info.java");
		list.add(temp + "JavaUtilProject/.classpath");
		list.add(temp + "JavaUtilProject/.project");
		list.add(temp + "JavaUtilProject/test2022-10-03.bat");
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
