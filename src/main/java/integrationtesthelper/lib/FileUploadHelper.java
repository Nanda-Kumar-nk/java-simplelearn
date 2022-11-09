package integrationtesthelper.lib;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 24/09/2022
 */
public class FileUploadHelper {

    public static String getInputParametersFileAsString(String fileName) throws IOException {

        FileInputStream fis = new FileInputStream("D:\\others\\int-tst\\" + fileName);
        String data = IOUtils.toString(fis, StandardCharsets.UTF_8);
        if (StringUtils.isBlank(data)) {
            throw new NullPointerException("file : " + fileName + " is empty. input Parameters NullPointerException thrown");
        }
        return data;
    }

    public static String getStoredXMLParametersFileAsString(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\others\\int-tst\\" + fileName);
        String data = IOUtils.toString(fis, StandardCharsets.UTF_8);
        if (StringUtils.isBlank(data)) {
            throw new NullPointerException("file : " + fileName + " is empty. Stored XML Parameters NullPointerException thrown");
        }
        return data;
    }

    public static Map<String, String> extractInputParameterValues(String inputValues) throws IOException {
        Map<String, String> mappedValues = new HashMap<>();

        BufferedReader bufReader = new BufferedReader(new StringReader(inputValues));
        String line;
        while ((line = bufReader.readLine()) != null) {
            if (StringUtils.isNotBlank(line)) {
                Pair<String, String> value = extractInputParameter(line);
                mappedValues.put(value.getKey(), value.getValue());
            }
        }

        if (MapUtils.isEmpty(mappedValues)) {
            throw new NullPointerException("Extract Input Parameters thrown NULL");
        }
        return mappedValues;
    }

    private static Pair<String, String> extractInputParameter(String line) {
        line = line.replace("Key:", "");

        String[] split = line.split("=");
        Pair<String, String> pair = new ImmutablePair<>(split[0], split[1]);

        return verifyAndReturnValues(pair);
    }

    private static Pair<String, String> verifyAndReturnValues(Pair<String, String> pair) {
        if (StringUtils.isBlank(pair.getKey()) || StringUtils.isBlank(pair.getValue())) {
            throw new NullPointerException("extract line failed. key=" + pair.getKey() + "  value=" + pair.getValue());
        }
        return pair;
    }

    public static Map<String, String> extractStoredParametersValues(String storedXMLRawValues) throws ParserConfigurationException, IOException, SAXException {
        Map<String, String> xmlValuesMap = new HashMap<>();

        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new InputSource(new StringReader(storedXMLRawValues)));

        Element element = (Element) doc.getElementsByTagName("pattern").item(0);

        for (int i = 0; i >=0; i++) {
            try {
                String name = element.getElementsByTagName("name").item(i).getTextContent();
                String value = element.getElementsByTagName("value").item(i).getTextContent();

                xmlValuesMap.put(name, value);
            }catch(NullPointerException ex){
                System.out.println("Exception breaks at "+i);
                break;
            }
        }

        return xmlValuesMap;
    }
}
