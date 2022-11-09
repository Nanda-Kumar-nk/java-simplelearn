package streams;

public class SomeObject {
    private String someValue;
    private String somePartner;

    public SomeObject(String someValue, String somePartner) {
        this.someValue = someValue;
        this.somePartner = somePartner;
    }

    public String getSomePartner() {
        return somePartner;
    }

    public void setSomePartner(String somePartner) {
        this.somePartner = somePartner;
    }

    public String getSomeValue() {
        return someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }
}
