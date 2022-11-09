package arraylist;

import com.google.common.collect.Lists;
import groovy.json.JsonOutput;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 14/03/2022
 */
public class SplitListBasedOnSize {

    // private static final

    public static void main(String[] args) {

        List<String> value121 = List.of
                ("913700501111");


        List<String> value111 = List.of
                ("913700501111", "927910982750", "927871203914"
                        , "912400213957"
                        , "929001318103"
                        , "929001201002"
                        , "927911484120"
                        , "928601150312"
                        , "823500500468"
                        , "928601150813"
                        , "912401476440"
                        , "927910984150"
                        , "927914084020"
                        , "823500500211"
                        , "912400789327"
                        , "912400358608"
                        , "912401476442"
                        , "927911082750"
                        , "823500407030"
                        , "912400217403"
                        , "823500407032"
                        , "911401733642"
                        , "913700362003");

        List<List<String>> batches = Lists.partition(value121, 10);

        System.out.println(batches);


        for (List<String> productCodeSet : batches) {
            System.out.println(productCodeSet.size());
        }

    }
}
