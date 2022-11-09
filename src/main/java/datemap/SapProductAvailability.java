package datemap;

import java.util.Date;
import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 17/01/2022
 */
public class SapProductAvailability {

    Long currentStockLevel;
    Map<String, Map<Date, Long>> futureAvailability;

    public Long getCurrentStockLevel() {
        return currentStockLevel;
    }

    public void setCurrentStockLevel(Long currentStockLevel) {
        this.currentStockLevel = currentStockLevel;
    }

    public Map<String, Map<Date, Long>> getFutureAvailability() {
        return futureAvailability;
    }

    public void setFutureAvailability(Map<String, Map<Date, Long>> futureAvailability) {
        this.futureAvailability = futureAvailability;
    }
}
