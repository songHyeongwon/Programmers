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
		startDate = LocalDate.parse("2023-04-30", formatter);
		String temp = "C:/Temp/workspace/Programmers/";
		ArrayList<String> list = new ArrayList<String>();
		list.add(temp + "BaekJoon/bin/step14/Main1010.class");
		list.add(temp + "BaekJoon/bin/step14/Main1037.class");
		list.add(temp + "BaekJoon/bin/step14/Main1676.class");
		list.add(temp + "BaekJoon/bin/step14/Main1934.class");
		list.add(temp + "BaekJoon/bin/step14/Main2004.class");
		list.add(temp + "BaekJoon/bin/step14/Main2609.class");
		list.add(temp + "BaekJoon/bin/step14/Main2981.class");
		list.add(temp + "BaekJoon/bin/step14/Main3036.class");
		list.add(temp + "BaekJoon/bin/step14/Main5086.class");
		list.add(temp + "BaekJoon/bin/step14/Main9375.class");
		list.add(temp + "BaekJoon/bin/step14/Main11050.class");
		list.add(temp + "BaekJoon/bin/step14/Main11051.class");
		list.add(temp + "BaekJoon/bin/step15/Main2580.class");
		list.add(temp + "BaekJoon/bin/step15/Main9663.class");
		list.add(temp + "BaekJoon/bin/step15/Main14888.class");
		list.add(temp + "BaekJoon/bin/step15/Main14889.class");
		list.add(temp + "BaekJoon/bin/step15/Main15649.class");
		list.add(temp + "BaekJoon/bin/step15/Main15650.class");
		list.add(temp + "BaekJoon/bin/step15/Main15651.class");
		list.add(temp + "BaekJoon/bin/step15/Main15652.class");
		list.add(temp + "BaekJoon/bin/step16/Main1003.class");
		list.add(temp + "BaekJoon/bin/step18/Main1541.class");
		list.add(temp + "BaekJoon/bin/step18/Main1931$1.class");
		list.add(temp + "BaekJoon/bin/step18/Main1931.class");
		list.add(temp + "BaekJoon/bin/step18/Main11047.class");
		list.add(temp + "BaekJoon/bin/step18/Main11399.class");
		list.add(temp + "BaekJoon/bin/step18/Main13305.class");
		list.add(temp + "BaekJoon/bin/step18/Main1010.class");
		list.add(temp + "BaekJoon/bin/step18/Main1037.class");
		list.add(temp + "BaekJoon/bin/step18/Main1676.class");
		list.add(temp + "BaekJoon/bin/step18/Main1934.class");
		list.add(temp + "BaekJoon/bin/step18/Main2004.class");
		list.add(temp + "BaekJoon/bin/step18/Main2609.class");
		list.add(temp + "BaekJoon/bin/step18/Main2981.class");
		list.add(temp + "BaekJoon/bin/step18/Main3036.class");
		list.add(temp + "BaekJoon/bin/step18/Main5086.class");
		list.add(temp + "BaekJoon/bin/step18/Main9375.class");
		list.add(temp + "BaekJoon/bin/step18/Main11050.class");
		list.add(temp + "BaekJoon/bin/step18/Main11051.class");
		list.add(temp + "BaekJoon/bin/step19/Main1874.class");
		list.add(temp + "BaekJoon/bin/step19/Main4949.class");
		list.add(temp + "BaekJoon/bin/step19/Main9012.class");
		list.add(temp + "BaekJoon/bin/step19/Main10773.class");
		list.add(temp + "BaekJoon/bin/step19/Main10828.class");
		list.add(temp + "BaekJoon/bin/step19/Main17298.class");
		list.add(temp + "BaekJoon/bin/step19/Main2447.class");
		list.add(temp + "BaekJoon/bin/step19/Main10870.class");
		list.add(temp + "BaekJoon/bin/step19/Main10872.class");
		list.add(temp + "BaekJoon/bin/step19/Main11729.class");
		list.add(temp + "BaekJoon/bin/step19/Main24060.class");
		list.add(temp + "BaekJoon/bin/step19/Main25501.class");
		list.add(temp + "BaekJoon/bin/step20/Main1021.class");
		list.add(temp + "BaekJoon/bin/step20/Main1966.class");
		list.add(temp + "BaekJoon/bin/step20/Main2164.class");
		list.add(temp + "BaekJoon/bin/step20/Main5430.class");
		list.add(temp + "BaekJoon/bin/step20/Main10866.class");
		list.add(temp + "BaekJoon/bin/step20/Main11866.class");
		list.add(temp + "BaekJoon/bin/step20/Main18258.class");
		list.add(temp + "BaekJoon/bin/step20/Main1629.class");
		list.add(temp + "BaekJoon/bin/step20/Main1780.class");
		list.add(temp + "BaekJoon/bin/step20/Main1992.class");
		list.add(temp + "BaekJoon/bin/step20/Main2630.class");
		list.add(temp + "BaekJoon/bin/step20/Main11401.class");
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
