package exceptionupdate;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author Nanda Kumar
 * @since 15/02/2022
 */
public class UpdateExceptionMessage {

    public static void main(String[] args) {

        String exceptionMessage = "Material not matching with Quote line item 000010 000000912401533668";

        exceptionMessage = updateExceptionMessage(exceptionMessage);
        System.out.println(exceptionMessage);

        String[] values=exceptionMessage.split(" ");
        System.out.println(values[values.length-112]);

    }

    private static String updateExceptionMessage(String exceptionMessage) {
        String updatedExceptionMessage = exceptionMessage;
        String lineNumber = null;
        String updatedLineNumber = null;

        try {
            lineNumber = exceptionMessage.substring((exceptionMessage.lastIndexOf(" ") - 6), exceptionMessage.lastIndexOf(" "));
            Integer lineNumberValue=Integer.parseInt(lineNumber);
            System.out.println(lineNumberValue);
            if (lineNumber.trim().endsWith("10")) {
                updatedLineNumber = "0000" + "40";
                updatedExceptionMessage = exceptionMessage.replaceFirst(lineNumber, updatedLineNumber);

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("exception caught!!!");
        }


        return updatedExceptionMessage;
    }
}
