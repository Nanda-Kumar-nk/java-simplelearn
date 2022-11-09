package base;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @author Nanda Kumar
 * @since 03/11/2022
 */
public class UUIDTest {

    public static void main(String[] args) {

        String value="MCjCUYYuWU";
        String result = UUID.nameUUIDFromBytes(value.getBytes()).toString();
        System.out.println(result);
        // e3fc527c-7747-3427-8875-88c729eac782
        // e3fc527c-7747-3427-8875-88c729eac782
    }
}
