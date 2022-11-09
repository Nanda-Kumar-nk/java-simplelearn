package optionaltest;

import java.util.Optional;

/**
 * @author Nanda Kumar
 * @since 25/11/2021
 */
public class OptionalTest {

    public static void main(String[] args) {

        Optional<SampleObject> object=getSampleObjectOptional();
        if(object.isPresent()){
            System.out.println("is available");
        }else{
            System.out.println("not available");
        }

    }


    private static Optional<SampleObject> getSampleObjectOptional() {
        return Optional.ofNullable(null);
    }
}
