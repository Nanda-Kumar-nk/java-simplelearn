package stringchangexample;

public class MainStringExample {

    public static void main(String[] args) {

        String someValue="123456";
        StaticAndNotStaticFn.changeInStaticFunction(someValue);
        System.out.println(someValue);


        StaticAndNotStaticFn obj1=new StaticAndNotStaticFn();
        obj1.changeInFn(someValue);
        System.out.println(someValue);

        someValue=obj1.changeInFnWithreturn(someValue);
        System.out.println(someValue);



    }
}
