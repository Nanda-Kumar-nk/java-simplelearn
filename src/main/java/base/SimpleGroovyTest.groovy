package base

import groovy.json.JsonSlurper

class SimpleGroovyTest {

    def body = "{\n" +
            "\"productCode\":\"N4AVELI\"\n" +
            "}\n";

    def slurper = new JsonSlurper();
    def result = slurper.parseText(body);

    def codeValue = result.productCode;

   // print codeValue;




}
