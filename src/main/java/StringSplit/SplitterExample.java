package StringSplit;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Nanda Kumar
 * @since 24/04/2022
 */
public class SplitterExample {

    private static final String SEPARATOR_SPACE = " ";

    public static void main(String[] args) {

        SplitterExample obj = new SplitterExample();
        String[] nameSplitted = obj.splitName("firstNamelastName");
        System.out.println("length is : "+nameSplitted.length);
        System.out.println(Arrays.toString(nameSplitted));
        String orderingPersonName=getOrderingPersonName(nameSplitted);
        System.out.println(orderingPersonName);
    }

    private static String getOrderingPersonName(String[] nameSplitted) {
        Collections.reverse(Arrays.asList(nameSplitted));
       return String.join(",", nameSplitted);
    }

    public String[] splitName(final String name) {
        final String trimmedName = StringUtils.trimToNull(name);
        return new String[]{StringUtils.substringBeforeLast(trimmedName, SEPARATOR_SPACE),
                StringUtils.substringAfterLast(trimmedName, SEPARATOR_SPACE)};
    }
}
