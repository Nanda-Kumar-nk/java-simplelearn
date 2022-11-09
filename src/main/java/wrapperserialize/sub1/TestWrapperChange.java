package wrapperserialize.sub1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 02/11/2022
 */
public class TestWrapperChange {

    public static void main(String[] args) {

        Map<Integer,Object> entry=new HashMap<>();
        ObjectForTest obj1=new ObjectForTest();
        obj1.setId(1);
        obj1.setValue("one");
        ObjectForTest obj2=new ObjectForTest();
        obj2.setId(2);
        obj2.setValue("two");
        entry.put(1,obj1);
        entry.put(2,obj2);

        for (Map.Entry<Integer,Object> mapEntry : entry.entrySet()){
            if(mapEntry!=null && mapEntry.getValue() instanceof ObjectForTest){

            }
        }

    }
}
