package api_ld.v2;

import java.util.List;

/**
 * @author Nanda Kumar
 * @since 03/11/2022
 */
public class DeleteUserHelper {

    private final LDExecutor ldExecutor;

    public DeleteUserHelper(UserConfiguration cf) {
        LDConfiguration ldConfiguration = new LDConfiguration(cf);
        this.ldExecutor = new LDExecutor(ldConfiguration);
    }

    public void executeDelete() {
        if(!ldExecutor.isExecutionRequired())  {System.out.println("Execution is not Required!!!! Total count is Zero"); return;}

        while(ldExecutor.isNextSetAvailable()){
            List<String> userKeyList=ldExecutor.getNextSetOfUsers();
            if(userKeyList.size()!=0) {
                ldExecutor.deleteUsers(userKeyList);
            }else {
                System.out.println("user list count is zero. execution completed!");
            }
        }


    }
}
