package zoneid;

import java.time.ZoneId;
import java.util.List;
import java.util.Set;

/**
 * @author Nanda Kumar
 * @since 26/11/2021
 */
public class ZoneIdTester {

    public static void main(String[] args) {

        int hitcount=0;
        List<String> zonePatterns = List.of("CET",
                "Australia/ACT",
                "Brazil/East",
                "America/Montreal",
                "Asia/Shanghai",
                "Europe/Moscow",
                "America/Chicago",
                "America/New_York",
                "America/Los_Angeles",
                "Africa/Harare");

        for(String zonePattern : zonePatterns) {
            zonePattern=zonePattern.toLowerCase();
            Set<String> availableZones = ZoneId.getAvailableZoneIds();
            for (String zone : availableZones) {
                if (zone.toLowerCase().contains(zonePattern)) {
                    printMatching(zone);
                    hitcount++;
                }
            }
        }

        System.out.println("hitcount="+hitcount+"   orginalcount="+zonePatterns.size());

    }

    private static void printMatching(String pattern) {
        System.out.println(pattern);
    }
}
