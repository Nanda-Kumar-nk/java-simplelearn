package api_ld.v2;

import api_ld.DeleteUsers;
import org.apache.commons.collections4.MapUtils;

/**
 * @author Nanda Kumar
 * @since 03/11/2022
 */
public class LDConfiguration {

    public static final String AUTHORIZATION_KEY = "api-169a7695-d3bb-4d62-9777-9852afcf4248";
    private static final String BASE_URL = "https://app.launchdarkly.com";
    private static final String DELETE_ID = "{{DELETE_UID}}";
    public int waitForSeconds;
    private String searchURLInitial;
    private String searchURL;
    private String deleteURL;

    private int batchLimit;

    private LDConfiguration(){
        this.searchURLInitial = null;
    }

    public int getWaitForSeconds() {
        return waitForSeconds;
    }

    public void setWaitForSeconds(int waitForSeconds) {
        this.waitForSeconds = waitForSeconds;
    }

    public LDConfiguration(UserConfiguration cf){
        this.searchURLInitial = configureInitialSearchURL(BASE_URL + "/api/v2/user-search/default/" + getEnv(cf.getEnv()), cf);
        this.searchURL = configureSearchURL(searchURLInitial, cf);
        this.deleteURL = configureDeleteURL(BASE_URL+"/api/v2/users/default/"+getEnv(cf.getEnv()));
        this.waitForSeconds =cf.getWaitForSeconds();
    }

    private String configureSearchURL(String initial_search_url, UserConfiguration cf) {
        String searchURL=initial_search_url;

        if(cf.getBatchLimit()!=0){
            searchURL  = searchURL + "&limit="+ cf.getBatchLimit();
            this.batchLimit=cf.getBatchLimit();
        } else {
            this.batchLimit=UserConfiguration.DEFAULT_BATCH_LIMIT;
        }
        return searchURL;
    }

    private String configureDeleteURL(String url) {
        return url+DELETE_ID;
    }

    private String configureInitialSearchURL(String searchURL, UserConfiguration cf) {
        if(MapUtils.isNotEmpty(cf.getFields())){
            String fieldName=cf.getFields().entrySet().iterator().next().getKey();
            String fieldValue=cf.getFields().get(fieldName);
            String filter=fieldName+":"+fieldValue;
            filter="?filter="+filter;
            searchURL=searchURL+filter;
        }

      return searchURL;
    }

    private String getEnv(ENV env) {
        return env.toString();

    }

    public String getSearchURLInitial() {
        return searchURLInitial;
    }

    public void setSearchURLInitial(String searchURLInitial) {
        this.searchURLInitial = searchURLInitial;
    }

    public String getSearchURL() {
        return searchURL;
    }

    public void setSearchURL(String searchURL) {
        this.searchURL = searchURL;
    }

    public String getDeleteURL(String userKey) {
        String deleteURL=this.deleteURL;
         deleteURL=deleteURL.replace(DELETE_ID,"/"+userKey);
        return deleteURL;
    }

    public void setDeleteURL(String deleteURL) {
        this.deleteURL = deleteURL;
    }

    public String getAuthenticationKey(){
        return AUTHORIZATION_KEY;
    }

    public int getBatchLimit() {
        return batchLimit;
    }

    public void setBatchLimit(int batchLimit) {
        this.batchLimit = batchLimit;
    }
}
