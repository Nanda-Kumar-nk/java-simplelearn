package misc;

import java.util.Arrays;

/**
 * @author Nanda Kumar
 * @since 25/11/2021
 */
public class SplitString {

    public static void main(String[] args) {

        String str = null;

        String[] strSubstrings = str.split("(?<=\\G.{2})");

        System.out.println(strSubstrings[0]);
        System.out.println(strSubstrings[1]);
        System.out.println(strSubstrings[2]);
        System.out.println(strSubstrings[3]);

    }
}
