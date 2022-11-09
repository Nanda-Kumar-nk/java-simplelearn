package base;

import java.util.List;
import java.util.Optional;

/**
 * @author Nanda Kumar
 * @since 08/11/2022
 */
public class IfPresentCheck {

    public static void main(String[] args) {

        TestObject tobj1=new TestObject();
        tobj1.setId(1);
        tobj1.setValue("one");
        TestObject tobj2=new TestObject();
        tobj2.setId(2);
        tobj2.setValue("two");

        List<TestObject> testObjects= List.of(tobj1,tobj2);

        System.out.println(isAvailable("scDcsdc",testObjects));
    }

    private static boolean isAvailable(String value, List<TestObject> testObjects) {
        return testObjects
                .stream()
                .filter(test-> value.equalsIgnoreCase(test.getValue())).findFirst().isPresent();
    }
}
