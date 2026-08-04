package utilPackage;


import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NyaaNextEpisodeFinder {

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

            LocalDate yesterday = LocalDate.now().minusDays(0);

            // 🔹 이미 가지고 있는 파일명 저장 (중복 체크용)
            Set<String> existingFiles = new HashSet<>();
            for (File f : files) {
                existingFiles.add(f.getName());
            }

            // 🔹 이미 체크한 (title + nextEpisode) 중복 방지
            Set<String> processed = new HashSet<>();

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
                    String nextEpisodeStr = String.format("%02d", nextEpisode);

                    String key = title + "-" + nextEpisodeStr;

                    // 🔹 이미 처리한 경우 스킵
                    if (processed.contains(key)) continue;
                    processed.add(key);

                    // =========================
                    // 2. 이미 다음 화가 있는지 체크
                    // =========================
                    boolean alreadyExists = false;

                    for (String existing : existingFiles) {
                        if (existing.contains(title) &&
                                existing.contains(" - " + nextEpisodeStr + " ")) {
                            alreadyExists = true;
                            break;
                        }
                    }

                    if (alreadyExists) {
                        System.out.println("\n⏩ 이미 있음 (스킵): " + title + " - " + nextEpisodeStr);
                        continue;
                    }

                    System.out.println("\n🔍 체크: " + title + " - " + nextEpisodeStr);

                    // =========================
                    // 3. 크롤링
                    // =========================
                    String query = URLEncoder.encode("[SubsPlease]", StandardCharsets.UTF_8);
                    String url = "https://nyaa.si/?f=0&c=0_0&q=" + query;

                    Document doc = Jsoup.connect(url)
                            .userAgent("Mozilla/5.0")
                            .get();

                    Elements rows = doc.select("table tbody tr");

                    boolean found = false;

                    for (Element row : rows) {

                        String name = row.select("td:nth-child(2) a").text();
                        String dateStr = row.select("td:nth-child(5)").text();

                        // 🔹 어제 날짜만
                        if (!dateStr.startsWith(yesterday.toString())) continue;

                        if (name.contains(title) &&
                                name.contains(" - " + nextEpisodeStr + " ")) {

                            // (480p 필터)
                            if (!name.contains("(480p)")) continue;

                            String magnet = row.select("a[href^=magnet]").attr("href");

                            System.out.println("✅ 발견!");
                            System.out.println("파일명: " + name);
                            System.out.println("마그넷: " + magnet);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("❌ 없음");
                    }

                } catch (Exception e) {
                    System.out.println("⚠️ 파싱 실패: " + fileName);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}