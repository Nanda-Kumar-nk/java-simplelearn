package base;

/**
 * @author Nanda Kumar
 * @since 07/10/2022
 */
public class Intupdate {

    public static void main(String[] args) {

        double totalCount=101;
        int batch=50;

        int totalIterationsRequired=(int)Math.ceil(totalCount/batch);

        System.out.println(totalIterationsRequired);

    }
}
