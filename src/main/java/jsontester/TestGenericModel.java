package jsontester;

/**
 * @author Nanda Kumar
 * @since 02/12/2021
 */
public class TestGenericModel {

     private String key;
     private Object value;

     public String getKey() {
          return key;
     }

     public void setKey(String key) {
          this.key = key;
     }

     public Object getValue() {
          return value;
     }

     public void setValue(Object value) {
          this.value = value;
     }

     @Override
     public String toString() {
          return  key + value;
     }
}