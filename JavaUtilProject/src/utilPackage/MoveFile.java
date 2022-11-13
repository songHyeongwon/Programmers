package utilPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveFile {
	int startNum = 129;
	String asPath = "D:\\hitomi_downloaded\\새 폴더\\[Hanahanamaki, Etc] Angelic Link R (2203972)";
	String bePath = "C:\\Users\\iks16\\Documents\\Honeycam";
	
	String asMuve= asPath + "\\변환됨웹피";
	String beMuve= asPath + "\\변환완기프";
	public static void main(String[] args) {
		MoveFile test1 = new MoveFile();
		test1.fileRead();
	}
	
	public File[] fileRead() {
		File path1 = new File(asPath);
		File path2 = new File(bePath);
		String[] asList = path1.list();
		String[] converList = path2.list();
		
		for (int i = 0; i < converList.length; i++) {
			String newName = asList[i].substring(0 , asList[i].lastIndexOf("."));
			
			Path file = Paths.get(bePath +"\\"+ converList[i]);
			Path newFile = Paths.get(beMuve +"\\"+ newName + ".gif");
			
			Path asFile = Paths.get(asPath +"\\"+ asList[i]);
			Path newAsFile = Paths.get(asMuve +"\\"+ asList[i]);
			
			try {
				Path newFilePath = Files.move(file, newFile , StandardCopyOption.REPLACE_EXISTING);
				Path new2FilePath = Files.move(asFile, newAsFile , StandardCopyOption.REPLACE_EXISTING);
				System.out.println(newFilePath.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return null;
	}
}
