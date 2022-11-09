package sometest;

/**
 * @author Nanda Kumar
 * @since 28/04/2022
 */
public class SomeTest1 {

    public static void main(String[] args) {

      int a, b;
      for(a=1,b=4;a<b;a++,b--){
          System.out.println("a="+a);

      }
    }

    private static void show() {
        System.out.println("show");
        throw new RuntimeException();
    }
}
