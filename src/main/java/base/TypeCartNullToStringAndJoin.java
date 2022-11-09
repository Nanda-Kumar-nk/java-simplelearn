package base;

import java.util.Arrays;

public class TypeCartNullToStringAndJoin {

    public static void main(String[] args) {

        Object somevalue=null;
        String salesOrg=(String)"IE001";
        String distChannel=(String)"01";
        String division=(String)null;

        String salesArea = String.join("_", Arrays.asList(salesOrg, distChannel,division));

        System.out.println(salesArea);

    }

}
