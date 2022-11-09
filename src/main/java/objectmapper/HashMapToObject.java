package objectmapper;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author Nanda Kumar
 * @since 01/06/2022
 */
public class HashMapToObject {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Map<String, Object> map=getMap();

        EmployeeObject object=new EmployeeObject();

        BeanUtils.setProperty(object, "name", map.get("id"));

        System.out.println(object);

        Map<String, String> stringFieldMapper = new HashMap();
        stringFieldMapper.put("dataObjectField","map value");

        stringFieldMapper.put("itemNumber","ItmNumber"); // string
        stringFieldMapper.put("baseUom","BaseUom");  // String
        stringFieldMapper.put("confirmedQuantity","ConfirQty"); //Bigdecimal
        stringFieldMapper.put("reqType","ReqType");  //String
        stringFieldMapper.put("salesUnit","SalesUnit");  //PCE
        stringFieldMapper.put("requestedQuantity","ReqQty"); // BigDecimal
        stringFieldMapper.put("scheduleLine1","SchedLin1");// String

        Map<String, String> dateFieldMapper = new HashMap();
        stringFieldMapper.put("reqTime","ReqTime");    // java.util.Date
        stringFieldMapper.put("loadData","LoadDate");
        stringFieldMapper.put("reqDate","ReqDate");


        BeanUtils.setProperty(object, "name", map.get("id"));

    }

    private static Map<String, Object> getMap() {
        Map<String, Object> map=new HashMap<>();
        map.put("id", "nandu");
        map.put("date",new Date());
        map.put("setValue", true);
        map.put("addresssAsString","no address now");
        return map;
    }
}
