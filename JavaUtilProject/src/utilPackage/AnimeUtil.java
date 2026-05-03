package utilPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AnimeUtil {
	public static void main(String[] args) {
		String directoryPath = "E:/자막 대기중";

		try {
			File dir = new File(directoryPath);

			if (!dir.exists() || !dir.isDirectory()) {
				System.out.println("디렉토리 없음");
				return;
			}
			
			File[] files = dir.listFiles();
            if (files == null) return;
            
//            LocalDate yesterday = LocalDate.now().minusDays(1);
//            LocalDate today = LocalDate.now().minusDays(0);

            Set<String> existingFiles = new HashSet<>();
//            for (File f : files) {
//                existingFiles.add(f.getName());
//            }
            
            //타이틀과 다음화면 따로 담음 
            Map<String, Integer> processed = new HashMap<>();

            
            for (File file : files) {
                String fileName = file.getName();

                if (!fileName.contains(" - ")) continue;
                
                try {
                    // =========================
                    // 1. 파일명 파싱
                    // =========================
                    String[] parts = fileName.split(" - ");
                    String title = parts[0].trim();
                    
                    String episodeStr = parts[parts.length-1].split(" ")[0];
                    int episode = Integer.parseInt(episodeStr);

                    int nextEpisode = episode + 1;
                    
                    if(processed.containsKey(title)) {
                    	processed.put(title, Math.max(processed.get(title), nextEpisode));
                    } else {
                    	processed.put(title, nextEpisode);
                    }
                } catch (Exception e) {
                    System.out.println("⚠️ 파싱 실패: " + fileName);
                }
            }
            crawling(processed);
//            for(String s : processed.keySet()) {
//            	System.out.println(String.format("%s - %02d", s, processed.get(s)));
//            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void crawling(Map<String, Integer> processed) {
		try {
			//String query = URLEncoder.encode("[SubsPlease]", StandardCharsets.UTF_8);
	        String url = "https://nyaa.si/?f=0&c=0_0&q=SubsPlease";
	        
	        Document doc = Jsoup.connect(url)
	                .userAgent("Mozilla/5.0")
	                .get();

	        Elements rows = doc.select("table tbody tr");
	        
	       // System.out.println(doc.toString());
	        
	        
	        List<String> list = new ArrayList<>();
	        for(String title : processed.keySet()) {
		        String nextEpisodeStr = String.format("%02d", processed.get(title));

	        	boolean found = false;
	        	
	        	find: for (Element row : rows) {
	        		
	        		String name = row.select("td:nth-child(2) a").text();
	        		String dateStr = row.select("td:nth-child(5)").text();
	        		
	        		// 🔹 어제 날짜만
	        		
	        		if (name.contains(title) &&
	        				name.contains(" - " + nextEpisodeStr + " ")) {
	        			
	        			// (480p 필터)
	        			if (!name.contains("(480p)")) continue;
	        			
	        			String magnet = row.select("a[href^=magnet]").attr("href");
	        			
	        			System.out.println("✅ 발견!");
	        			System.out.println("파일명: " + name);
	        			System.out.println("마그넷: " + magnet);
	        			list.add(magnet);
	        			found = true;
	        			break find;
	        		}
	        	}
//	        	if (!found) {
//	        		System.out.println(String.format("%s - %02d", title, processed.get(title)) + " ❌ 없음");
//	        	}
	        }
	        if(!list.isEmpty()) {
	        	list.stream().forEach(e -> System.out.println(e));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
