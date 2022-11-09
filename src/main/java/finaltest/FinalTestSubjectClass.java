package finaltest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import static java.util.Map.entry;

/**
 * @author Nanda Kumar
 * @since 06/06/2022
 */
public final class FinalTestSubjectClass {

    private static Map<String, BiConsumer<ScheduleLineItemResponseData, String>> stringFieldConsumerMap = Map.ofEntries(
            entry("ItmNumber", ScheduleLineItemResponseData::setItemNumber), //string
            entry("BaseUom", ScheduleLineItemResponseData::setBaseUom), //string
            entry("ReqType", ScheduleLineItemResponseData::setReqType), //string
            entry("SalesUnit", ScheduleLineItemResponseData::setSalesUnit), //string
            entry("SchedLin1", ScheduleLineItemResponseData::setScheduleLine1)//string
    );

    private static Map<String, BiConsumer<ScheduleLineItemResponseData, BigDecimal>> bigDecimalFieldConsumerMap = Map.ofEntries(
            entry("ConfirQty", ScheduleLineItemResponseData::setConfirmedQuantity),
            entry("ReqQty", ScheduleLineItemResponseData::setRequestedQuantity)
    );

    public static List<Map> fieldMapper = List.of(stringFieldConsumerMap, bigDecimalFieldConsumerMap);

    private FinalTestSubjectClass(){

    }
}
