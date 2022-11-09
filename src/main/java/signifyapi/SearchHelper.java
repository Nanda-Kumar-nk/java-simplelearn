package signifyapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nanda Kumar
 * @since 12/10/2022
 */
public class SearchHelper {

    private static final String BASE_URL_LOCAL = "https://localhost:9002";
    private static final String BASE_URL_DEV = "https://api.c3unusspe-signifyne3-d1-public.model-t.cc.commerce.ondemand.com";
    private static final String BASE_URL_TST = "https://api.c3unusspe-signifyne3-s1-public.model-t.cc.commerce.ondemand.com";
    private static final String BASE_URL_ACC = "https://api.c3unusspe-signifyne3-s2-public.model-t.cc.commerce.ondemand.com";
    private static String RELATIVE_URL = "/b2bocc/v2/{{BASE_STORE}}/{{CUSTOMER}}/{{DISTRIBUTOR}}/products/search?currentPage={{TOTAL_PAGES}}&pageSize=100";
    private static String URL;
    private final String AUTHORIZATION_TOKEN;

    JsonParser parser = new JsonParser();
    Client client;

    public SearchHelper(ENV env, String customer, String base_store, String jwtToken) {

        client = Client.create();
        switch (env) {
            case TST:
                URL = BASE_URL_TST;
                break;
            case ACC:
                URL = BASE_URL_ACC;
                break;
            case LOCAL:
                URL = BASE_URL_LOCAL;
                break;
            default:
                throw new RuntimeException("env " + env + " is not configured in system");
        }
        RELATIVE_URL = RELATIVE_URL.replace("{{CUSTOMER}}", customer)
                .replace("{{DISTRIBUTOR}}", customer)
                .replace("{{BASE_STORE}}", base_store);

        this.AUTHORIZATION_TOKEN = jwtToken;
        this.URL=URL+RELATIVE_URL;
    }


    public List<String> getMaterial12NCList(Integer totalCount) {
        List<String> material12NCList = new ArrayList();

        int startCount = 0;
        int totalPages = 0;
        int currentCount = 1;
        String url = getURL(startCount);


        WebResource webResource = client
                .resource(url);

        ClientResponse response = webResource.accept("application/json")
                .header("Authorization", "Bearer "+AUTHORIZATION_TOKEN)
                .get(ClientResponse.class);
        String output = response.getEntity(String.class);

        if (totalPages == 0) {
            totalPages = getTotalPages(output);
            if(totalCount==null) totalCount=getTotalCount(output);
        }

        for(int i=1;i<=totalPages;i++){

            JsonElement parsed = parser.parse(output);
            JsonObject asJsonObject = parsed.getAsJsonObject();
            JsonArray products=asJsonObject.getAsJsonArray("products");
            int productCount=products.size();
            int productIteration=0;
            while(productCount>0){
                System.out.println("Iteration number "+currentCount+"/"+totalCount+" executing");
                String productCode=products.get(productIteration).getAsJsonObject().get("code").getAsString();
                productIteration=productIteration+1;
                productCount=productCount-1;
                material12NCList.add(productCode);
                currentCount=currentCount+1;
            }
            url = getURL(i);
            WebResource webResource1 = client
                    .resource(url);
            ClientResponse response1 = webResource1.accept("application/json")
                    .header("Authorization", "Bearer "+AUTHORIZATION_TOKEN)
                    .get(ClientResponse.class);
            output = response1.getEntity(String.class);
        }



        return material12NCList;
    }

    private Integer getTotalCount(String output) {
        JsonElement parsed = parser.parse(output);
        JsonObject asJsonObject = parsed.getAsJsonObject();
        JsonElement data = asJsonObject.get("pagination").getAsJsonObject().get("totalResults");
        return data.getAsInt();
    }

    private int getTotalPages(String output) {
        JsonElement parsed = parser.parse(output);
        JsonObject asJsonObject = parsed.getAsJsonObject();
        JsonElement data = asJsonObject.get("pagination").getAsJsonObject().get("totalPages");;
        return data.getAsInt();
    }

    private String getURL(int startCount) {
        String url = URL;
        url=url.replace("{{TOTAL_PAGES}}", String.valueOf(startCount));

        return url;
    }

    public enum ENV {
        TST, ACC, LOCAL, PRODUCTION
    }
}
