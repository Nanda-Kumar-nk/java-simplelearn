package filterunique;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

/**
 * @author Nanda Kumar
 * @since 25/11/2021
 */
public class TimeLimitExampleComparator implements Comparator<TimeLimitExample> {

    @Override
    public int compare(TimeLimitExample ex1, TimeLimitExample ex2) {

        if (comparefields(ex1.getSalesarea(), ex2.getSalesarea())
                && comparefields(ex1.getDeliveryPlant(), ex2.getDeliveryPlant())
                && comparefields(ex1.getRoute(), ex2.getRoute())) {

             return 0;
        }

        return 1;
    }

    private boolean comparefields(String value1, String value2) {
        value1 = StringUtils.defaultString(value1);
        value2 = StringUtils.defaultString(value2);

        return value1.equalsIgnoreCase(value2);
    }
}
