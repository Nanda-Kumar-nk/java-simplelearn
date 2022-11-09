package trim;

/**
 * @author Nanda Kumar
 * @since 07/01/2022
 */
public class OrderItem {

    private String  code;

    public OrderItem(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "code='" + code + '\'' +
                '}';
    }
}