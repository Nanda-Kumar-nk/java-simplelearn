package xmlvalidator;

import base.FileRetriever;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Nanda Kumar
 * @since 10/12/2021
 */
public class SimpleXmlValidatorImpl {

    public static void main(String[] args) throws FileNotFoundException {

        FileRetriever fileRetriever = new FileRetriever();
        File schemaFile = fileRetriever.getFileFromResources("inputValidation_sample.xsd");
        Source xmlFile = new StreamSource(fileRetriever.getFileFromResources("input_sample.xml"));

        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException | IOException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
        }
    }
}