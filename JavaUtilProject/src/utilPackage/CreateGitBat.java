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
		startDate = LocalDate.parse("2026-05-21", formatter);
		String temp = "C:/Users/iks16/eclipse-workspace/Programmers/";
		ArrayList<String> list = new ArrayList<String>();
		list.add(temp + "JavaUtilProject/.classpath");
		list.add(temp + ".idea/.gitignore");
		list.add(temp + "BaekJoon/bin/.gitignore");
		list.add(temp + "ProgrammersCode/bin/.gitignore");
		list.add(temp + "JavaUtilProject/bin/utilPackage/AnimeUtil.class");
		list.add(temp + "JavaUtilProject/bin/utilPackage/CreateGitBat.class");
		list.add(temp + "JavaUtilProject/src/utilPackage/CreateGitBat.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main1002.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main1002.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1003.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1004.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main1010.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main1010.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1011.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main1021.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main1021.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main1065.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main1065.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main1110.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main1110.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main1358.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main1358.java");
		list.add(temp + "BaekJoon/src/OUTTER/Main1676.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main1712.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main1712.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main1874.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main1874.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main1966.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main1966.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main2004.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main2004.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main2477.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main2477.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main2577.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main2577.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main2609.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main2609.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main2741.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main2741.java");
		list.add(temp + "BaekJoon/bin/OUTTER/Main2742.class");
		list.add(temp + "BaekJoon/src/OUTTER/Main2742.java");
		list.add(temp + ".idea/misc.xml");
		list.add(temp + ".idea/modules.xml");
		list.add(temp + "JavaUtilProject/bin/utilPackage/NyaaNextEpisodeFinder.class");
		list.add(temp + "JavaUtilProject/src/utilPackage/NyaaNextEpisodeFinder.java");
		list.add(temp + ".idea/Programmers.iml");
		list.add(temp + ".idea/vcs.xml");
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
