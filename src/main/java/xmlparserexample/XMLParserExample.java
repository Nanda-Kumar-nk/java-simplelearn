package xmlparserexample;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;

/**
 * @author Nanda Kumar
 * @since 23/05/2022
 */
public class XMLParserExample {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException, XPathExpressionException {


        File file = new File("D:\\others\\odatainputxml\\scheduleLine.xml");


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);


        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "//*[local-name()='properties']/Doc_Type";
      //    String expression = "(//*[local-name()='feed']/entry/content/properties/ItmNumber)[1]";


        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                doc, XPathConstants.NODESET);


        System.out.println("number is "+nodeList.getLength());

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            System.out.println("NODE NAME IS "+nNode.getNodeName());
            System.out.println("NODE VALUE IS "+nNode.getTextContent());
            System.out.println("\n\n");
            if(nNode.getChildNodes().getLength()>0){
                System.out.println("Hit on "+i);
            }
        }




     /*   for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            System.out.println(nNode.getNodeName());
        }
*/



  /*
      NodeList nodeList = doc.getElementsByTagName("atom:feed");
        Node node=nodeList.item(0);
        node.getTextContent();
   NodeList nodeList = doc.getElementsByTagName("d:ItmNumber");
        NodeList childList = nodeList.item(0).getChildNodes();
        for (int itr = 0; itr < childList.getLength(); itr++) {
            Node node = childList.item(itr);
            System.out.println("\nNode Name :" + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("atom:entry")) {

               Node childNode= node.getFirstChild();
                childNode.getNodeName();
                childNode.getNodeValue();
            }
        }*/


        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
// initialize StreamResult with File object to save to file
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
        String xmlString = result.getWriter().toString();
     //   System.out.println(xmlString);

    }
}
