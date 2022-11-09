package datemap;

import java.util.*;

/**
 * @author Nanda Kumar
 * @since 19/10/2022
 */
public class DateStreamCalculator {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        Date currentDate=cal.getTime();
        ScheduleDate date1=new ScheduleDate();
        date1.setId(1);
        date1.setDate(currentDate);

        ScheduleDate date2=new ScheduleDate();
        date2.setId(2);
        cal.add(Calendar.DAY_OF_MONTH, 3);
        date2.setDate(cal.getTime());

        List<ScheduleDate> scheduleDateList= List.of(date1, date2);

        Comparator<ScheduleDate> employeeAgeComparator = Comparator
                .comparing(ScheduleDate::getDate);

        ScheduleDate selected= scheduleDateList.stream()
                .max(employeeAgeComparator)
                .get();

        System.out.println(selected.getDate());
    }
}
