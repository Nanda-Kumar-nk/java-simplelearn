import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author Nanda Kumar
 * @since 25/05/2022
 */
public class odataCustomCall {

    public static void main(String[] args) throws IOException {


        String urlString="http://cigwd10.ssn.intra.lighting.com:8010/sap/opu/odata/sap/ZGW_MYLIGHTING_API_SRV/MATERIAL_AVAILABILITYSet?saml2=disabled&%24filter=IvPlant+eq+%27USB1%27+and+IvMaterial+eq+%27000000929000171101%27+and+IvUnit+eq+%27PCE%27&%24format=json";


        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("AuthToken", getAccessToken());
        con.setReadTimeout(15000);
        con.setConnectTimeout(15000);
        con.setDoOutput(false);

        con.connect();
        InputStream response = con.getInputStream();
        System.out.println(response.read());

    }

    private static String getAccessToken() {
        final byte[] userAndPassword = ("CWSUSER" + ':' + ";uTcVgxWNf0_").getBytes(StandardCharsets.UTF_8);
        return "Basic " + Base64.getEncoder().encodeToString(userAndPassword);
    }
}
