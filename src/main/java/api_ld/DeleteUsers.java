package api_ld;

import com.google.gson.*;
import com.sun.jersey.api.client.ClientResponse;

import static api_ld.UserConstants.FIELD_VALUES;

/**
 * @author Nanda Kumar
 * @since 06/10/2022
 */
public class DeleteUsers {

    public static final int BATCH_LIMIT = 50;
    private static final boolean exceptionFlag = false;
    private static final int WAIT_TIME_IN_SECS = 6;
    public static String SEARCH_ATTRIBUTE = UserConstants.FIELD_NAME;
    private static int count = 0;
    private static Double totalCount = Double.valueOf(0);
    private static int totalIterationsRequired = 0;
    private static int retryCount = 6;

    public static void main(String[] args) throws InterruptedException {
        DeleteUsers deleteUsers = new DeleteUsers();

        for (String value : FIELD_VALUES) {
            UserConstants.FIELD_VALUE = value;
            deleteUsers.executeDeletionLogic();
        }
    }

    public void executeDeletionLogic() throws InterruptedException {
        SEARCH_ATTRIBUTE = UserConstants.FIELD_NAME;
        System.out.println("Execution Started for Value " + UserConstants.FIELD_VALUE);
        UsersHelper usersHelper = new UsersHelper();
        DeleteUserHelper deleteUserHelper = new DeleteUserHelper();
        totalCount = usersHelper.getTotalUserCount();
        count=totalCount.intValue();

        if (totalCount <= 0) {
            System.out.println("total count is less than zero!!!");
            return;
        } else {
            System.out.println("total count is " + totalCount);
            totalIterationsRequired = (int) Math.ceil(totalCount / BATCH_LIMIT);
        }

        ClientResponse apiresponse = usersHelper.getUserResponse("https://app.launchdarkly.com/api/v2/user-search/default/" + UserConstants.ENV + "?filter=" + UserConstants.FIELD_NAME + ":" + UserConstants.FIELD_VALUE + "&limit=" + BATCH_LIMIT);

        if (apiresponse.getStatus() != 200) {
            throw new RuntimeException("Execution failed when count pending at : "
                    + count);
        }

        for (int iteration = 1; iteration <= totalIterationsRequired; iteration++) {
            String response = apiresponse.getEntity(String.class);
            String nextUrl = usersHelper.getNextLink(response);

            JsonParser parser = new JsonParser();
            JsonElement parsed = parser.parse(response);
            JsonObject asJsonObject = parsed.getAsJsonObject();
            JsonArray itemsArray = asJsonObject.getAsJsonArray("items");
            int itemSize = itemsArray.size();
            int itemCallCount = 0;
            String userName = null;
            String userKey = null;
            while (itemSize > 0 || itemsArray.size() < itemCallCount) {
                try {
                    JsonObject item = itemsArray.get(itemCallCount).getAsJsonObject();
                    JsonObject user = item.get("user").getAsJsonObject();
                    JsonElement custom = user.get("custom");
                    JsonPrimitive nameAsPrimitive = user.get("name").getAsJsonPrimitive();
                    userName = nameAsPrimitive.getAsString();
                    JsonElement element = null;
                    if (custom != null) {
                        JsonObject customObject = user.get("custom").getAsJsonObject();
                        element = customObject.get(SEARCH_ATTRIBUTE);
                    }

                    if (element != null) {
                        JsonPrimitive keyAsPrimitive = user.get("key").getAsJsonPrimitive();
                        userKey = keyAsPrimitive.getAsString();
                        ClientResponse deleteResponse = deleteUserHelper.deleteUser(userKey);

                        if (deleteResponse.getStatus() == 204) {
                            count = count - 1;
                            System.out.println("Delete Call Execution  " + count + "/" + totalCount + " | name=" + userName + " userKey=" + userKey);
                            itemSize = itemSize - 1;
                            itemCallCount = itemCallCount + 1;
                            retryCount = 3;
                        } else if (deleteResponse.getStatus() == 429 && retryCount != 0) {
                            System.out.println("Too Many requests. hence waiting for " + WAIT_TIME_IN_SECS + " secs");
                            Thread.sleep(WAIT_TIME_IN_SECS * 1000);
                            System.out.println("Wait completed ");
                            retryCount = retryCount - 1;
                        } else {
                            System.out.println("Delete Call Execution Failed for " + count + "/" + totalCount + " response code is " + deleteResponse.getStatus() + " status info " + deleteResponse.getStatusInfo());
                            return;
                        }
                    } else {
                        count = count - 1;
                        itemSize = itemSize - 1;
                        retryCount = 3;
                        itemCallCount = itemCallCount + 1;
                        System.out.println("Delete Call Skipped for " + count + "/" + totalCount + " name=" + userName + " | searchparams=" + SEARCH_ATTRIBUTE + " userKey=" + userKey);
                    }
                } catch (Exception ex) {
                    System.out.println("3 Execution count is " + count + " total count is " + totalCount);
                    System.out.println("exception thrown is " + ex.getMessage());
                }

            }

            if (retryCount > 0) {
                if (count == 0) {
                    System.out.println("1 Execution count is " + count + " total count is " + totalCount);
                    System.out.println("Execution completed Successfully!!!!");
                    return;
                } else {
                    apiresponse = usersHelper.getUserResponse(nextUrl);
                    System.out.println("Execution count is " + count + " total count is " + totalCount);
                    if (apiresponse.getStatus() != 200) {
                        System.out.println("Execution failed at count : "
                                + count);
                        throw new RuntimeException("Execution failed at count : "
                                + count);
                    } else {
                        System.out.println("Recollected api response ");
                    }
                }
            } else {
                System.out.println("retryCount is " + retryCount);
            }

        }
        System.out.println("Execution Completed for Value " + UserConstants.FIELD_VALUE);
    }
}