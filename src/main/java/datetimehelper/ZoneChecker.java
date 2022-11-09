package datetimehelper;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Nanda Kumar
 * @since 25/11/2021
 */
public class ZoneChecker {

    public static void main(String[] args) {
        ZonedDateTime localDateTime=ZonedDateTime.now(ZoneId.of("INVALID_ZONE"));
        System.out.println(localDateTime);

    }
}
