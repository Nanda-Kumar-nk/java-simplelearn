package api_ld.v2;

import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Nanda Kumar
 * @since 07/11/2022
 */
public class LDExecutor {

    private static final String BASE_URL = "https://app.launchdarkly.com";
    private final static Pattern UUID_REGEX_PATTERN = Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");
    private final int totalIterationsRequired;
    private final Client client;
    private final LDConfiguration ldConfiguration;
    private final int totalCount;

    private int iterationsCount = 0;
    private ClientResponse apiResponse;
    private String nextUrl;
    private int totalRetryCount=5;
    private int count=1;

    public LDExecutor(LDConfiguration ldConfiguration) {
        this.client = Client.create();
        this.ldConfiguration = ldConfiguration;
        this.totalCount = setTotalCount(ldConfiguration);
        this.totalIterationsRequired = (int) Math.ceil(totalCount / ldConfiguration.getBatchLimit());
    }

    private int setTotalCount(LDConfiguration ldConfiguration) {
        ClientResponse response = getResponse(ldConfiguration.getSearchURLInitial(), ldConfiguration.getAuthenticationKey());
        return extractTotalCountOfExecution(response);
    }

    private int extractTotalCountOfExecution(ClientResponse response) {
        if (response.getStatus() != 200) {
            throw new RuntimeException("Total count of execution calc Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);

        JsonParser parser = new JsonParser();
        JsonElement parsed = parser.parse(output);
        JsonObject asJsonObject = parsed.getAsJsonObject();
        JsonElement data = asJsonObject.get("totalCount");
        Double count = data.getAsDouble();

        System.out.println("totalCount=" + count);
        if (count.intValue() == 0) {
            System.out.println("Total Iteration Count Evaluated is Zero");
        } else {
            System.out.println("Total Iteration Count Evaluated is : " + count.intValue());
        }

        return count.intValue();
    }

    private WebResource getWebSource(String url) {
        return client
                .resource(url);
    }

    private ClientResponse getResponse(String url, String authenticationKey) {
        return getWebSource(url).accept("application/json")
                .header("Authorization", authenticationKey)
                .get(ClientResponse.class);
    }

    private ClientResponse delete(String url, String authenticationKey) {
        return getWebSource(url).accept("application/json")
                .header("Authorization", authenticationKey)
                .delete(ClientResponse.class);
    }

    public boolean isExecutionRequired() {
        return totalCount > 0;
    }

    public boolean isNextSetAvailable() {
        return this.iterationsCount <= totalIterationsRequired;
    }

    public List<String> getNextSetOfUsers() {

        List<String> userKeyList=new ArrayList();

        String searchURL = null;
        if (this.iterationsCount == 0) {
            searchURL = ldConfiguration.getSearchURL();
        } else {
            searchURL = nextUrl;
        }
        ClientResponse apiresponse = getResponse(searchURL, ldConfiguration.getAuthenticationKey());
        this.apiResponse = apiresponse;

        String response = apiresponse.getEntity(String.class);
        nextUrl = getNextLink(response);

        JsonParser parser = new JsonParser();
        JsonElement parsed = parser.parse(response);
        JsonObject asJsonObject = parsed.getAsJsonObject();
        JsonArray itemsArray = asJsonObject.getAsJsonArray("items");

        if(itemsArray.size()>0){
            for(int itemcount=0; itemsArray.size()>itemcount; itemcount++){
                JsonObject object=(JsonObject) itemsArray.get(itemcount);
                JsonObject user=(JsonObject) object.get("user");
                JsonPrimitive userKey=(JsonPrimitive) user.get("key");
                userKeyList.add(userKey.getAsString());
            }
        }
        iterationsCount=iterationsCount+1;

        return userKeyList;

    }

    public String getNextLink(String output) {


        JsonParser parser = new JsonParser();
        JsonElement parsed = parser.parse(output);
        JsonObject asJsonObject = parsed.getAsJsonObject();
        JsonObject links = asJsonObject.get("_links").getAsJsonObject();
        JsonObject nextNode = links.get("next").getAsJsonObject();
        JsonPrimitive nextLink = nextNode.getAsJsonPrimitive("href");
        String nextURL = BASE_URL + nextLink;
        nextURL = nextURL.replace("\"", "");
        return nextURL;
    }

    public void deleteUsers(List<String> userKeyList) {
        for(String userKey: userKeyList)
        if(isUserKeyValidUUID(userKey)){
              deleteUser(userKey);

        }
    }

    private void deleteUser(String userKey) {
        String deleteURL=ldConfiguration.getDeleteURL(userKey);
        int retryCount=0;
        boolean isCallSuccessFull = false;

        while(retryCount<=totalRetryCount){
            isCallSuccessFull=false;
            ClientResponse deleteResponse=delete(deleteURL, ldConfiguration.getAuthenticationKey());
            if(deleteResponse.getStatus() == 204 || deleteResponse.getStatus() == 200){
                System.out.println("Delete Call Execution  " + count + "/" + totalCount + " | userKey=" + userKey+ " response status="+deleteResponse.getStatus()+" response info="+deleteResponse.getStatusInfo());
                count=count+1;
                isCallSuccessFull=true;
                break;
            } else if (deleteResponse.getStatus() == 429 || deleteResponse.getStatus() == 504 && retryCount != totalRetryCount) {
                System.out.println("Too Many requests or gateway timeout. hence waiting for " + ldConfiguration.getWaitForSeconds() + " secs. retrycount="+retryCount+" /"+totalRetryCount+ " response status="+deleteResponse.getStatus()+" response info="+deleteResponse.getStatusInfo());
                try {
                    Thread.sleep(ldConfiguration.getWaitForSeconds() * 1000);
                    retryCount=retryCount+1;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } else if(deleteResponse.getStatus() == 404 ) {
                String exceptionMessage="Delete Call skipped For URL "+deleteURL;
                System.out.println(exceptionMessage);
                isCallSuccessFull=true;
                break;
            }else {
                String exceptionMessage="Delete Call Execution Failed for " + count + "/" + totalCount + " response code is " + deleteResponse.getStatus() + " status info " + deleteResponse.getStatusInfo()+" url="+deleteURL;
                System.out.println(exceptionMessage);
                throw new RuntimeException(exceptionMessage);
            }
        }

        if(!isCallSuccessFull ){
            String exceptionMessage="Delete Call Execution Failed for " + count + "/" + totalCount + " retry ended by call still ends unsuccessfully! deleteURL : "+deleteURL;
            System.out.println(exceptionMessage);
            throw new RuntimeException(exceptionMessage);
        }else{
            retryCount=0;
        }
    }

    private boolean isUserKeyValidUUID(String userKey) {
        if (userKey == null) {
            return false;
        }
        return UUID_REGEX_PATTERN.matcher(userKey).matches();
    }

}
