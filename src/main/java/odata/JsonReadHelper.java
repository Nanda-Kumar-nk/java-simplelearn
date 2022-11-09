package odata;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Nanda Kumar
 * @since 03/11/2022
 */
public class JsonReadHelper {

    private static final String DEFAULT_CHARSET = "UTF-8";

    public static void main(String[] args) throws IOException {
 /*       String str = "{\n" +
                "\"ReqDate\":\"/Date(1667433600000)/\",\n" +
                "\"place\": {\n" +
                "  \"name\":\"World!\"\n" +
                "  }\n" +
                "}";
        InputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        */

        String response=getResponse();
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
        final InputStream content = new ByteArrayInputStream(bytes);
        JsonReader reader = createJsonReader(content);


        while (reader.hasNext()) {
            JsonToken jsonToken = reader.peek();
            if (jsonToken == JsonToken.BEGIN_OBJECT) {
                reader.beginObject();
            } else if (jsonToken == JsonToken.END_OBJECT) {
                reader.endObject();
            }
            if (jsonToken == JsonToken.STRING) {
                System.out.print(reader.nextString() + " "); // print Hi World!
            } else {
                reader.skipValue();
            }
        }
        reader.close();
    }

    private static JsonReader createJsonReader(InputStream content) throws UnsupportedEncodingException {
        if (content == null) {
            throw new IllegalStateException("Got not supported NULL object as content to de-serialize.");
        }

        if (content instanceof InputStream) {
            return new JsonReader(new InputStreamReader((InputStream) content, DEFAULT_CHARSET));
        }
        throw new IllegalStateException("Got not supported NULL object as content to de-serialize.");
    }

    private static String getResponse() {
        return "{\"d\":{\"__metadata\":{\"id\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOHDRSet(Doc_Type='ZE01',SalesOrg='IE01',DistrChan='01',Division='01')\",\"uri\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOHDRSet(Doc_Type='ZE01',SalesOrg='IE01',DistrChan='01',Division='01')\",\"type\":\"ZGW_MYLIGHTING_API_SRV.SOHDR\"},\"Doc_Type\":\"ZE01\",\"SalesOrg\":\"IE01\",\"DistrChan\":\"01\",\"Division\":\"01\",\"ReqDateH\":\"20221103\",\"Message\":\"\",\"OrderToItems\":{\"results\":[{\"__metadata\":{\"id\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOITEMSet('000000')\",\"uri\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOITEMSet('000000')\",\"type\":\"ZGW_MYLIGHTING_API_SRV.SOITEM\"},\"ItmNumber\":\"000000\",\"Material\":\"000915004203301\",\"Plant\":\"\",\"TargetQty\":\"0000000001000\",\"ReqQty\":\"0000000001000\",\"ReqDate\":\"20221103\"}]},\"OrderToPartners\":{\"results\":[{\"__metadata\":{\"id\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOPARTNERSSet(PartnRole='SP',PartnNumb='35300222')\",\"uri\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOPARTNERSSet(PartnRole='SP',PartnNumb='35300222')\",\"type\":\"ZGW_MYLIGHTING_API_SRV.SOPARTNERS\"},\"PartnRole\":\"SP\",\"PartnNumb\":\"35300222\"},{\"__metadata\":{\"id\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOPARTNERSSet(PartnRole='SH',PartnNumb='35300222')\",\"uri\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOPARTNERSSet(PartnRole='SH',PartnNumb='35300222')\",\"type\":\"ZGW_MYLIGHTING_API_SRV.SOPARTNERS\"},\"PartnRole\":\"SH\",\"PartnNumb\":\"35300222\"}]},\"OrderToSchline\":{\"results\":[{\"__metadata\":{\"id\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOSCH_OUTSet(ItmNumber='000010',SchedLine='0001')\",\"uri\":\"http://cigwq20.ssn.intra.lighting.com:8020/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/SOSCH_OUTSet(ItmNumber='000010',SchedLine='0001')\",\"type\":\"ZGW_MYLIGHTING_API_SRV.SOSCH_OUT\"},\"Operation\":\"\",\"DocNumber\":\"\",\"ItmNumber\":\"000010\",\"SchedLine\":\"0001\",\"SchedType\":\"CP\",\"Relfordel\":true,\"ReqDate\":\"\\/Date(1667433600000)\\/\",\"ReqTime\":\"PT08H00M00S\",\"ReqQty\":\"1\",\"ConfirQty\":\"0\",\"SalesUnit\":\"PCE\",\"Isocodunit\":\"\",\"ReqQty1\":\"0\",\"BaseUom\":\"PCE\",\"Isobasunit\":\"\",\"ReqDate1\":null,\"ReqType\":\"05\",\"Pltype\":\"0\",\"Busidocnr\":\"\",\"Busiitnr\":\"000000\",\"SchedLin1\":\"0000\",\"EarlDate\":null,\"MaintReq\":\"0\",\"PreqNo\":\"\",\"PoType\":\"\",\"DocCat\":\"\",\"ConfStat\":\"\",\"IrInd\":false,\"Returndate\":null,\"DateType\":\"1\",\"TpDate\":\"\\/Date(1666828800000)\\/\",\"MsDate\":\"\\/Date(1666569600000)\\/\",\"LoadDate\":\"\\/Date(1666828800000)\\/\",\"GiDate\":\"\\/Date(1666828800000)\\/\",\"CorrQty\":\"1\",\"ReqDlvBl\":\"\",\"GrpDefin\":\"000\",\"Releastyp\":\"\",\"ForcastNr\":\"0000000000\",\"CommitQty\":\"0\",\"Size2\":\"0.000\",\"Size3\":\"0.000\",\"UnitMeas\":\"\",\"IsoRomei\":\"\",\"Formulakey\":\"\",\"Salesqtynr\":\"1\",\"Salesqtyde\":\"1\",\"AvailCon\":true,\"MoveType\":\"601\",\"PreqItem\":\"00000\",\"LintypEdi\":\"\",\"Orderid\":\"\",\"Planordnr\":\"\",\"BomexplNo\":\"\",\"Custchstat\":\"\",\"Guranteed\":\"0\",\"MsTime\":\"PT23H59M55S\",\"TpTime\":\"PT23H59M58S\",\"LoadTime\":\"PT23H59M58S\",\"GiTime\":\"PT23H59M58S\",\"Routesched\":\"\"}]}}}";
    }

}

