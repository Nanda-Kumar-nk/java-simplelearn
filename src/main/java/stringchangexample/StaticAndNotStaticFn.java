package stringchangexample;

public class StaticAndNotStaticFn {
    public static void changeInStaticFunction(String someValue) {
        someValue = "00" + someValue;
    }

    public void changeInFn(String someValue) {
        someValue = "00" + someValue;
    }

    public String changeInFnWithreturn(String someValue) {
        return someValue = "00" + someValue;
    }

}
