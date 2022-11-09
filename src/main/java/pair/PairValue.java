package pair;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;

/**
 * @author Nanda Kumar
 * @since 24/04/2022
 */
public class PairValue {

    public static void main(String[] args) {

        Pair<String, String[]> orderingPersonData=getOrderingPersonData();
        System.out.println(orderingPersonData.getKey());
        System.out.println(Arrays.toString(orderingPersonData.getValue()));
    }

    private static Pair<String, String[]> getOrderingPersonData() {
        Pair<String, String[]> pairValue= ImmutablePair.of("key", new String[] {"nanda", "kumar"});
         return pairValue;
    }
}
