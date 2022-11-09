package sometest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Nanda Kumar
 * @since 13/10/2022
 */
public class TestRDDProcess {

    public static void main(String[] args) {

        ScheduleLineData s1=new ScheduleLineData();
        s1.setConfirmedQuantity(BigDecimal.ZERO);
        ScheduleLineData s2=new ScheduleLineData();
        s2.setConfirmedQuantity(BigDecimal.ONE);

        s1.setReqDate(new Date());

        List<ScheduleLineData> scheduleLinesDTOFiltered= List.of(s1,s2);

        ScheduleLineData lineItemResponseData = scheduleLinesDTOFiltered
                .stream()
                .filter(line -> line.getConfirmedQuantity().equals(BigDecimal.ZERO))
                .findFirst()
                .orElseGet(()->scheduleLinesDTOFiltered.get(0));

      /*  if(lineItemResponseData.isPresent()) {
            System.out.println("value is "+ lineItemResponseData.get().getReqDate());
        }else {
            System.out.println("no value found");
        }*/

    }
}
