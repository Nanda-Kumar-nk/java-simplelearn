package simpleitems;

/**
 * @author Nanda Kumar
 * @since 06/12/2021
 */
public class SimpleForLoop {


    public static void main(String[] args) {

        checkForLoop();
    }

    private static void checkForLoop() {

        int maxIteration=4;
        for(int iteration =1;iteration<=maxIteration;iteration++) {
            System.out.println("i="+iteration);
        }
    }
}
