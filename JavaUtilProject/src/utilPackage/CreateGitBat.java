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
		startDate = LocalDate.parse("2026-07-04", formatter);
		String temp = "C:/Users/iks16/eclipse-workspace/Programmers/";
		ArrayList<String> list = new ArrayList<String>();
		list.add(temp + "JavaUtilProject/bin/.gitignore");
		list.add(temp + "JavaUtilProject/bin/utilPackage/CreateGitBat.class");
		list.add(temp + "JavaUtilProject/src/utilPackage/CreateGitBat.java");
		list.add(temp + "BaekJoon/src/step01/Main1000.java");
		list.add(temp + "BaekJoon/src/step01/Main1001.java");
		list.add(temp + "BaekJoon/src/step01/Main1008.java");
		list.add(temp + "BaekJoon/src/step03/Main2438.java");
		list.add(temp + "BaekJoon/src/step03/Main2439.java");
		list.add(temp + "BaekJoon/src/step01/Main2557.java");
		list.add(temp + "BaekJoon/src/step02/Main2563.java");
		list.add(temp + "BaekJoon/src/step02/Main2566.java");
		list.add(temp + "BaekJoon/src/step01/Main2588.java");
		list.add(temp + "BaekJoon/src/step02/Main2738.java");
		list.add(temp + "BaekJoon/src/step03/Main2739.java");
		list.add(temp + "BaekJoon/src/step03/Main8393.java");
		list.add(temp + "BaekJoon/src/step01/Main10171.java");
		list.add(temp + "BaekJoon/src/step01/Main10172.java");
		list.add(temp + "BaekJoon/src/step01/Main10430.java");
		list.add(temp + "BaekJoon/src/step02/Main10798.java");
		list.add(temp + "BaekJoon/src/step01/Main10869.java");
		list.add(temp + "BaekJoon/src/step01/Main10926.java");
		list.add(temp + "BaekJoon/src/step03/Main10950.java");
		list.add(temp + "BaekJoon/src/step03/Main10951.java");
		list.add(temp + "BaekJoon/src/step03/Main10952.java");
		list.add(temp + "BaekJoon/src/step01/Main10998.java");
		list.add(temp + "BaekJoon/src/step03/Main11021.java");
		list.add(temp + "BaekJoon/src/step03/Main11022.java");
		list.add(temp + "BaekJoon/src/step01/Main11382.java");
		list.add(temp + "BaekJoon/src/step03/Main15552.java");
		list.add(temp + "BaekJoon/src/step01/Main18108.java");
		list.add(temp + "BaekJoon/src/step03/Main25304.java");
		list.add(temp + "BaekJoon/src/step03/Main25314.java");
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
