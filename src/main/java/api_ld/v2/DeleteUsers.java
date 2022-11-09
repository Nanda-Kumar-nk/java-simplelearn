package api_ld.v2;


import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 03/11/2022
 */
public class DeleteUsers {

    public static void main(String[] args) {

        UserConfiguration cf=new UserConfiguration()
                .setFieldIdentifier(Map.of("name","commerce-tst"))
                .setBatchLimit(50)
                .setWithWaitForSeconds(3)
                .setEnv(ENV.test);

        DeleteUserHelper deleteUserHelper=new DeleteUserHelper(cf);
        deleteUserHelper.executeDelete();
    }

}
