package datetimehelper;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Nanda Kumar
 * @since 25/11/2021
 */
public class zonalcheck {

    public static void main(String[] args) {
        String[] splitTime = "10A2301".split("(?<=\\G.{2})");
        int hour = Integer.valueOf(splitTime[0]);
        int min = Integer.valueOf(splitTime[1]);
        int sec = Integer.valueOf(splitTime[3]);
        ZonedDateTime now=ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("PST")));

        System.out.println(now.getYear()+"  "+now.getMonthValue()+"  "+now.getDayOfMonth());
        ZonedDateTime dateTime=ZonedDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth()
                , now.getHour(), now.getMinute(), now.getSecond(),00, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));

        System.out.println(dateTime);
    }
}
