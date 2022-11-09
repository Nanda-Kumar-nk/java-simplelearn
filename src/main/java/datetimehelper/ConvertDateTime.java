package datetimehelper;

import org.apache.commons.collections4.MapUtils;


import java.time.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 24/11/2021
 */
public class ConvertDateTime {

    public static void main(String[] args) {

        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);
        //   23:30:
        LocalDateTime cutoffDate;
        try {
             cutoffDate = LocalDateTime.of(currentTime.getYear(), currentTime.getMonth(), currentTime.getDayOfMonth()
                    , 23, 30);
        } catch (DateTimeException ex) {
            cutoffDate=LocalDateTime.now(ZoneOffset.UTC);
        }

        System.out.println("****************************************************************************************************************");

     /*   for(String availablezone:ZoneIdTester.getAvailableZoneIds()){
            System.out.println(availablezone);
            ZoneIdTester zoneId=ZoneIdTester.of(availablezone);

        }*/


       Map<String, String> zonalID =new HashMap(ZoneId.SHORT_IDS);
        zonalID.put("PST", "PST_UPDATED");
        String zone=ZoneId.SHORT_IDS.get("PST");
       // if(StringUtils.isEmpty(zone)){zone= ZoneOffset.UTC.getId();}
        ZonedDateTime  localDateTime=ZonedDateTime.now(ZoneId.of(zone));

        ZonedDateTime dateTime=ZonedDateTime.of(2021, 12, 1, 10, 00, 30, 00, ZoneId.of(zone));

        System.out.println("dateTime : "+dateTime);


        System.out.println(localDateTime);
        LocalDateTime pstlocal = localDateTime.toLocalDateTime();
        System.out.println(pstlocal);

        boolean isCutOffPassed=false;
        if(pstlocal.compareTo(cutoffDate)>0){
            isCutOffPassed=true;
        }

        System.out.println(currentTime.compareTo(cutoffDate));

        System.out.println(currentTime);
        System.out.println(cutoffDate);
        System.out.println(isCutOffPassed);


        /*
         boolean isCutOffPassed=false;
        if(currentTime.compareTo(cutoffDate)>0){
            isCutOffPassed=true;
        }
         */

}
}
