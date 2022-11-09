package trim;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 07/01/2022
 */
public class TestTrim {

    public static void main(String[] args) {

        OrderItem item1=new OrderItem("value1    ");
        OrderItem item2=new OrderItem(null);

       List<OrderItem> orderItems = List.of(item1, item2);

       orderItems.forEach(item->item.setCode(StringUtils.trim(item.getCode())));


        System.out.println(orderItems);

    }
}
