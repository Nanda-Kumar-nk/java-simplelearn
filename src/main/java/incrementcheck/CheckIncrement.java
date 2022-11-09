package incrementcheck;

/**
 * @author Nanda Kumar
 * @since 17/12/2021
 */
public class CheckIncrement {

    private static Integer i=1;

    public static void main(String[] args) {

        System.out.println("first i="+i);
        i=+1;
        System.out.println("second i="+i);
        i+=1;
        System.out.println("third i="+i);

    }
}
