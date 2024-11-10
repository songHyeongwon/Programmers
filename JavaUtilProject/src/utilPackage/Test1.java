package utilPackage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test1 {
    public static void main(String[] args) {
        ZoneId zoneId1 = ZoneId.of("UTC");
        ZoneId zoneId2 = ZoneId.systemDefault();
        long minutes = getTimeDifferenceInMinutes(zoneId1, zoneId2);
        System.out.println("분 차이: " + minutes);
    }
   
	public static long getTimeDifferenceInMinutes(ZoneId zoneId1, ZoneId zoneId2) {
        LocalDateTime utcDateTime = LocalDateTime.now(zoneId1);
        
        ZonedDateTime utcZonedDateTime = utcDateTime.atZone(zoneId1);
        ZonedDateTime seoulZonedDateTime = utcZonedDateTime.withZoneSameInstant(zoneId2);

        LocalDateTime seoulDateTime = seoulZonedDateTime.toLocalDateTime();
        Duration duration = Duration.between(utcDateTime, seoulDateTime);
        return duration.toMinutes();
    }
}
