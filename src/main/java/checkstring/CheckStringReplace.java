package checkstring;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Nanda Kumar
 * @since 27/06/2022
 */
public class CheckStringReplace {

    private static final String REGEX_LEADING_ZEROS = "^0+(?!$)";

    public static void main(String[] args) {


        String b2b="0010021825_US01_02_01";

        SomeTest someTest=new SomeTest();
        someTest.setValue(removeLeadingZeros(b2b));

     //   System.out.println(someTest);

        String value=(b2b.split("_", 2))[1];


        System.out.println(value);
    }

    public static String removeLeadingZeros(String data) {
        if (StringUtils.isNotBlank(data)) {
            return data.replaceFirst(REGEX_LEADING_ZEROS, "");
        }
        return null;
    }
}
