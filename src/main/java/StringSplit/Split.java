package StringSplit;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Nanda Kumar
 * @since 09/12/2021
 */
public class Split {

    public static void main(String[] args) {

        String email="NandaKumar";
        String[] splitedNames= splitNames(email);
        String firstName=splitedNames[0];
        String secondName=splitedNames[1];

        System.out.println(firstName+" secondName="+secondName);
    }

    private static String[] splitNames(String email) {
        return new String[] { StringUtils.substringBeforeLast(email, " "),
                StringUtils.substringAfterLast(email, " ") };

    }
}
