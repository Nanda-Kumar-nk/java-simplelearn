package base;

public class DoubleCheck {

    public static void main(String[] args) {

        Double value=0.0000;

        if(Double.compare(value, Double.valueOf(0.0)) <= 0){
            System.out.println("less than zero");
        }else{
            System.out.println("greater than zero");
        }

    }
}
