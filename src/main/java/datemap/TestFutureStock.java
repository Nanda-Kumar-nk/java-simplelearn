package datemap;

import org.apache.commons.collections4.MapUtils;
import org.joda.time.DateTimeComparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 17/01/2022
 */
public class TestFutureStock {

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private static final String PRODUCT = "9876545321";

    public static void main(String[] args) throws ParseException {
        SapProductAvailability productAvailability = new SapProductAvailability();
        Map<String, Map<Date, Long>> futureAvailability = new HashMap<>();
        Map<Date, Long> availabilityMap = new HashMap<>();
        availabilityMap.put(convertDate("2022-01-17"), 1234L);
        availabilityMap.put(convertDate("2022-01-18"), 2345L);

        futureAvailability.put(PRODUCT, availabilityMap);
        productAvailability.setFutureAvailability(futureAvailability);

        updateStockAvailabilityWithScarcityData(productAvailability);

        System.out.println(productAvailability);

    }

    private static void updateStockAvailabilityWithScarcityData(SapProductAvailability productAvailability) {
        if (productAvailability == null || MapUtils.isEmpty(productAvailability.getFutureAvailability())) return;

        Date currentDate= new Date();

        Map<String, Map<Date, Long>> futureAvailability = productAvailability.getFutureAvailability();
        for (String product : futureAvailability.keySet()) {
            Map<Date, Long> availabilityMap = futureAvailability.get(product);

            if(MapUtils.isNotEmpty(availabilityMap)){
                for (Map.Entry<Date,Long> availability : availabilityMap.entrySet()) {
                    int isMatching=DateTimeComparator.getDateOnlyInstance().compare(currentDate, availability.getKey());

                    if(isMatching==0){
                        System.out.println(availability.getKey()+"     "+availability.getValue());
                        availability.setValue(Math.max(0, availability.getValue() - 9999L));
                    }

                }
            }

        }

    }

    public static final Date convertDate(String strDate) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        Date date = df.parse(strDate);

        return (date);
    }
}