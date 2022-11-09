package api_ld;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import static api_ld.UserConstants.ENV;

/**
 * @author Nanda Kumar
 * @since 06/10/2022
 */
public class DeleteUserHelper {

    private static final String DELETE_URL = "https://app.launchdarkly.com/api/v2/users/default/"+ENV+"/";

    Client client;

    public DeleteUserHelper() {
        client = Client.create();
    }
    public ClientResponse deleteUser(String userKey){
        String deleteURL=DELETE_URL+userKey;

        WebResource webResource = client
                .resource(deleteURL);

        ClientResponse response = webResource.accept("application/json")
                .header("Authorization", UserConstants.AUTHORIZATION_KEY)
                .delete(ClientResponse.class);

        return response;

    }
}
