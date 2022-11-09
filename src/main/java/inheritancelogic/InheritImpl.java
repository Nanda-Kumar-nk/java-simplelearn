package inheritancelogic;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Nanda Kumar
 * @since 03/06/2022
 */
public class InheritImpl {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Child1 source=new Child1();
        source.setId(121);
        source.setName("nandu");
        source.setChild1Paramter1("childParameter1");
        source.setChild1Paramter2("childParameter2");

        Child2 destination= new Child2();

        BeanUtils.copyProperties(destination, source);

        System.out.println(source);


    }
}
