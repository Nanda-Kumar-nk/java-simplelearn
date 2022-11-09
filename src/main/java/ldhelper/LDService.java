package ldhelper;



/**
 * @author Nanda Kumar
 * @since 19/11/2021
 */
public class LDService {

   private final boolean isInitialized;

   public LDService(boolean isInitialized){
       this.isInitialized=isInitialized;
   }

    public boolean isFlagEnabled(String someKey, boolean defaultValue) {
        if(someKey.equals("someKey")){
            return true;
        }else{
            return defaultValue;
        }
    }




}
