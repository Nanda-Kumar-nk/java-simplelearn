package longtest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Nanda Kumar
 * @since 18/01/2022
 */
public class BigDecimalConversion {

    public static void main(String[] args) {

        BigDecimal zero= new BigDecimal(0.000000000);

        if(zero.compareTo(BigDecimal.ZERO)==0){
            System.out.println("success!!!");
        }


        long scarcityValue = zero.setScale(0, RoundingMode.UP).longValue();

        System.out.println(scarcityValue);



    }
}
