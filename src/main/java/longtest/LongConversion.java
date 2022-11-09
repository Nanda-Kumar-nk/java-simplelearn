package longtest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Nanda Kumar
 * @since 18/01/2022
 */
public class LongConversion {

    public static void main(String[] args) {

        String value = "-99999.99";

        BigDecimal bigDecimal = new BigDecimal(value);

        System.out.println(bigDecimal);

        bigDecimal = bigDecimal.setScale(1, RoundingMode.UP);

        long longValue = bigDecimal.longValue();

        System.out.println(longValue);
    }
}
