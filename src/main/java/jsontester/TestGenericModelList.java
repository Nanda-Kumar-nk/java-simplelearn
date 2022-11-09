package jsontester;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nanda Kumar
 * @since 02/12/2021
 */
public class TestGenericModelList {

    private List<TestGenericModel> genericModelList=new ArrayList<>();

    public void addEntry(TestGenericModel model){
        this.genericModelList.add(model);
    }

    @Override
    public String toString() {
        return "TestGenericModelList{" +
                "genericModelList=" + genericModelList +
                '}';
    }
}
