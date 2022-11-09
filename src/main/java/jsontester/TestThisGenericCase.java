package jsontester;

/**
 * @author Nanda Kumar
 * @since 02/12/2021
 */
public class TestThisGenericCase {

    public static void main(String[] args) {

        TestGenericModel model1=new TestGenericModel();
        model1.setKey("booleanKey");
        model1.setValue(true);

        TestGenericModel model2=new TestGenericModel();
        model1.setKey("stringKey");
        model1.setValue("stringvalue");

        TestGenericModel model3=new TestGenericModel();
        model1.setKey("jsonKey");
        model1.setValue("{\n" +
                "        \"country\": \"india\",\n" +
                "        \"name\": \"nanda\",\n" +
                "        \"group\": \"ML_AGENT, MLF_OE_PROFILE\"\n" +
                "    }");


        TestGenericModelList modelList=new TestGenericModelList();
        modelList.addEntry(model1);
        modelList.addEntry(model2);
        modelList.addEntry(model3);

        System.out.println(modelList.toString());

    }
}
