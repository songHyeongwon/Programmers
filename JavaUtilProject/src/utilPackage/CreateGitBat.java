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
		startDate = LocalDate.parse("2024-11-05", formatter);
		String temp = "C:/Temp/workspace/Programmers/";
		ArrayList<String> list = new ArrayList<String>();
		list.add(temp + "JavaUtilProject/bin/utilPackage/BaekJoonProblemSync.class");
		list.add(temp + "JavaUtilProject/bin/utilPackage/CreateGitBat.class");
		list.add(temp + "JavaUtilProject/bin/utilPackage/Test1.class");
		list.add(temp + "JavaUtilProject/src/utilPackage/BaekJoonProblemSync.java");
		list.add(temp + "JavaUtilProject/src/utilPackage/CreateGitBat.java");
		list.add(temp + "JavaUtilProject/src/utilPackage/Test1.java");
		list.add(temp + "BaekJoon/bin/step02/Main10798.class");
		list.add(temp + "BaekJoon/bin/step08/Main2720.class");
		list.add(temp + "BaekJoon/bin/step08/Main2745.class");
		list.add(temp + "BaekJoon/bin/step08/Main2903.class");
		list.add(temp + "BaekJoon/bin/step08/Main11005.class");
		list.add(temp + "BaekJoon/bin/step10/Main2501.class");
		list.add(temp + "BaekJoon/bin/step10/Main9506.class");
		list.add(temp + "BaekJoon/bin/step52/Main2444.class");
		list.add(temp + "BaekJoon/bin/step52/Main25206.class");
		list.add(temp + "BaekJoon/src/step02/Main10798.java");
		list.add(temp + "BaekJoon/src/step08/Main2720.java");
		list.add(temp + "BaekJoon/src/step08/Main2745.java");
		list.add(temp + "BaekJoon/src/step08/Main2903.java");
		list.add(temp + "BaekJoon/src/step08/Main11005.java");
		list.add(temp + "BaekJoon/src/step10/Main2501.java");
		list.add(temp + "BaekJoon/src/step10/Main9506.java");
		list.add(temp + "BaekJoon/src/step52/Main2444.java");
		list.add(temp + "BaekJoon/src/step52/Main25206.java");
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
