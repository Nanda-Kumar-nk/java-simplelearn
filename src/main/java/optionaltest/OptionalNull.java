package optionaltest;

import java.util.Optional;

public class OptionalNull {

    public static void main(String[] args) {

        Optional<String> op1= Optional.ofNullable(null);

        checkOptional(op1);

    }

    private static void checkOptional(Optional op1) {
        if(op1.isPresent()){
            System.out.println("Optional Present");
        }else {
            System.out.println("Optional Not Present");
        }
    }
}
