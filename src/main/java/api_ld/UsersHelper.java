package api_ld;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.lang3.StringUtils;

import static api_ld.UserConstants.ENV;

/**
 * @author Nanda Kumar
 * @since 06/10/2022
 */
public class UsersHelper {

    private static final String AUTHORIZATION_KEY = UserConstants.AUTHORIZATION_KEY;
    private static final String BASE_URL = "https://app.launchdarkly.com";
    String FIRST_URL = BASE_URL + "/api_ld/v2/user-search/default/" + ENV+"?filter=" + UserConstants.FIELD_NAME + ":" + UserConstants.FIELD_VALUE;
    Client client;

    public UsersHelper() {
        client = Client.create();
        FIRST_URL = BASE_URL + "/api/v2/user-search/default/" + ENV+"?filter=" + UserConstants.FIELD_NAME + ":" + UserConstants.FIELD_VALUE;
    }

    public Double getTotalUserCount() {
        Double count = Double.valueOf(0);

        ClientResponse response = getUserResponse(FIRST_URL);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);

        JsonParser parser = new JsonParser();
        JsonElement parsed = parser.parse(output);
        JsonObject asJsonObject = parsed.getAsJsonObject();
        JsonElement data = asJsonObject.get("totalCount");
        count = data.getAsDouble();

        return count;
    }

    public ClientResponse getUserResponse(String url) {
        if (StringUtils.isBlank(url)) {
            url = FIRST_URL + "?limit="+DeleteUsers.BATCH_LIMIT;
        } else {
            if (url.contains("?") && !url.contains("limit")) {
                url = url + "&limit="+DeleteUsers.BATCH_LIMIT;
            } else if(!url.contains("limit")){
                url = url + "?limit="+DeleteUsers.BATCH_LIMIT;
            }

        }

        WebResource webResource = client
                .resource(url);

        ClientResponse response = webResource.accept("application/json")
                .header("Authorization", AUTHORIZATION_KEY)
                .get(ClientResponse.class);

        return response;
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
}
