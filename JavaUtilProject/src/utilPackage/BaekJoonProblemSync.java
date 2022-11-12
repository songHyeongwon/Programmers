package utilPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class BaekJoonProblemSync {
	public static String basePatn = "C:/Temp/workspace/Programmers/BaekJoon/src/";
	public static int lastStep = 54;
	public static void main(String[] args) {
		BaekJoonProblemSync t3 = new BaekJoonProblemSync();
		t3.run();
	}
	
	public void run() {
		//모든 코테 파일의 위치를 OUTTER로 초기화 합니다.
		for (int i = 0; i < lastStep; i++) {
			moveStopToOutter(i + 1);
		}
		//백준 사이트 크롤링 해서 id별 스텝으로 옮긴다.
		for (int i = 0; i < lastStep; i++) {
			moveOutterToStop(i + 1);
		}

		
	}
	
	private void moveOutterToStop(int i) {
		List<String> idList = getProblemIdList(i);//크롤링 해서 리스트를 받아옴
		for(String id : idList) {
			String fileName = "Main" + id + ".java";
			File file = new File(basePatn + "OUTTER/" + fileName);
			if(!file.exists()) {
				System.out.println("이문제 없다 빨리 풀어라 " + getStepPath(i) + " " + fileName);
				continue; // 대상 파일이 OUTTER에 없다면
			}
			//OUTTER -> Step 폴더로 옮긴다.
			fileMoveTo(basePatn + "OUTTER/" + fileName, basePatn + getStepPath(i) + "/" + fileName);
		}
	}

	private void moveStopToOutter(int i) {
		File file = new File(basePatn + getStepPath(i) + "/");
		if(!file.exists()) return;
		
		String[] asList = file.list();
		for(String s : asList) {
			fileMoveTo(basePatn + getStepPath(i) + "/" + s, basePatn + "OUTTER/" + s);
		}
	}

	public boolean fileMoveTo(String asFile, String toFile) {
		Path oldfile = Paths.get(asFile);
		Path newfile = Paths.get(toFile);
		try {
			File dir = newfile.getParent().toFile();
			if(dir.mkdir()) {
				System.out.println("mkdir = " + newfile.getParent().toString());
			}
			Files.move(oldfile, newfile, StandardCopyOption.ATOMIC_MOVE);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	//페이지 크롤링 문제번호 리스트 반환
	public List<String> getProblemIdList(int step) {
		List<String> resultSet = new ArrayList<String>();
		
		String find = "<td class=\"list_problem_id\">";
		String findEnd = "</td>";
		String document = getDocument(step);
		
		while(document.indexOf(find) > -1) {
			document = document.substring(document.indexOf(find));
			String findProblemId = document.substring(document.indexOf(">") +1, document.indexOf(findEnd));
			resultSet.add(findProblemId);
			document = document.substring(document.indexOf(findEnd));
		}
		
		return resultSet;
	}
	
	//페이지 크롤링 텍스트 반환
	public String getDocument(int step) {
		String sUrl = "https://www.acmicpc.net/step/" + step;
		try {
			URL url = new URL(sUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buf = new StringBuffer();
			
			String line ="";
			while((line = br.readLine()) != null) {
				buf.append(line + "\n");
			}
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	//스텝 인트를 step00형식으로 반환
	public String getStepPath(int step) {
		return String.format("step%02d", step);
	}
}
