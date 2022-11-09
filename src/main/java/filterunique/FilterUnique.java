package filterunique;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Nanda Kumar
 * @since 25/11/2021
 */
public class FilterUnique {

    public static void main(String[] args) {

        TimeLimitExample example1 = new TimeLimitExample("saleaarea1", "deliveryplant1", "route1");
        TimeLimitExample example2 = new TimeLimitExample("saleaarea2", "deliveryplant2", "route2");
        TimeLimitExample example3 = new TimeLimitExample("saleaarea3", "deliveryplant3", "route3");
        TimeLimitExample example4 = new TimeLimitExample("saleaarea3", "deliveryplant3", "route3");
        TimeLimitExample example5 = new TimeLimitExample("saleaarea3", "deliveryplant3", "route3");

        List<TimeLimitExample> examples = List.of(example1, example2, example3, example4, example5);

        List<TimeLimitExample> withoutDuplicates=filterOutDuplicates(examples);

        withoutDuplicates.forEach(System.out::println);


    }

    private static List<TimeLimitExample> filterOutDuplicates(List<TimeLimitExample> examples) {

        Set<TimeLimitExample> timeLimitExamples = new TreeSet(new TimeLimitExampleComparator());
        for (TimeLimitExample car : examples) {
            timeLimitExamples.add(car);
        }
        List<TimeLimitExample> withoutDuplicates = new ArrayList(timeLimitExamples);
        return withoutDuplicates;


    }
}
