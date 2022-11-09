package ldhelper;

/**
 * @author Nanda Kumar
 * @since 19/11/2021
 */
public class SignifyFeatureFlagCaller {

    public static void main(String[] args) {

        LDService ldService=new LDService(true);
        boolean isFlagEnabled=ldService.isFlagEnabled("someKey", false);
        System.out.println(isFlagEnabled);

    }
}
