package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class NullSafeStream {

    public static void main(String[] args) {

        List<SomeObject> someObjectList=new ArrayList<>();
       // someObjectList.add(new SomeObject("Ship-To", "WE"));
      //  someObjectList.add(new SomeObject("Sold-To", "AG"));

        Optional<SomeObject> result=Optional.ofNullable(someObjectList.stream().filter(someObject -> "WE".equals(someObject.getSomePartner())).findFirst()).orElse(null);


        if(result.isPresent()){
            System.out.println(result.get().getSomeValue());
        }

        System.out.println();

    }
}
