package integrationtesthelper;

import integrationtesthelper.lib.FileUploadHelper;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 24/09/2022
 */
public class IntegrationTestComparator {

    private static final String FILE_NAME="10-PIQ_CALCULATE-20221028-163647.xml";
    private static final String PARAMS="params.txt";


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        String testInputParametersRawValues = FileUploadHelper.getInputParametersFileAsString(PARAMS);
        String storedXMlParametersRawValues = FileUploadHelper.getStoredXMLParametersFileAsString(FILE_NAME);


        compareAndShowChanges(testInputParametersRawValues, storedXMlParametersRawValues);
    }

    private static void compareAndShowChanges(String testInputParametersRawValues, String storedXMlParametersRawValues) throws IOException, ParserConfigurationException, SAXException {

        Map<String, String> inputParametersJUnit = FileUploadHelper.extractInputParameterValues(testInputParametersRawValues);
        Map<String, String> storedParametersJUnit = FileUploadHelper.extractStoredParametersValues(storedXMlParametersRawValues);

        Map<String, String> missingValues = getMissingValues(inputParametersJUnit, storedParametersJUnit);

        if(MapUtils.isNotEmpty(missingValues)){
            System.out.println("*************************************************************************************************** ");
            for (Map.Entry<String, String> missingEntry : missingValues.entrySet()) {
                System.out.println("key="+missingEntry.getKey()+ " | value="+missingEntry.getValue());
            }
            System.out.println("*************************************************************************************************** ");
        }else {
            System.out.println("no missing values found");
        }

    }

    private static Map<String, String> getMissingValues(Map<String, String> inputParametersJUnit, Map<String, String> storedParametersJUnit) {
        Map<String, String> missingValues = new HashMap<>();

        for (Map.Entry<String, String> inputEntry : inputParametersJUnit.entrySet()) {

            String value = storedParametersJUnit.get(inputEntry.getKey());
            if (StringUtils.isNotBlank(value)) {
                if (!inputEntry.getValue().equals(value)) {
                    missingValues.put(inputEntry.getKey(), inputEntry.getValue());
                }
            } else {
                missingValues.put(inputEntry.getKey(), inputEntry.getValue());
            }
        }
        return missingValues;
    }
}
