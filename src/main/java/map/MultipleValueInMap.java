package map;

import java.util.HashMap;
import java.util.Map;

public class MultipleValueInMap {

    public static void main(String[] args) {

        Map<String, String> mapValue=new HashMap();
        mapValue.put("1", "one");
        mapValue.put("1", "two");
        mapValue.put(null, "two");


        System.out.println(mapValue.get("1"));

    }
}
