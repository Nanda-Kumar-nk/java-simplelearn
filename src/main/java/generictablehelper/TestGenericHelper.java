package generictablehelper;

import java.util.List;
import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 24/11/2021
 */
public class TestGenericHelper {

    private static final String VKORG = "VKORG";
    private static final String DWERK = "DWERK";
    private static final String ROUTE = "ROUTE";

    public static void main(String[] args) {
        System.out.println(createFilterOptions("salesarea", "deliveryplant", "route"));
    }

    private static String createFilterOptions(String salesarea, String deliveryPlant, String route) {
        return VKORG + " = " + salesarea + " AND " + DWERK + " = " + deliveryPlant + " AND " + ROUTE + " = " + route;
    }

}
