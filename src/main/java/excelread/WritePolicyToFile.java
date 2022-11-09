package excelread;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritePolicyToFile {

    private static final String DESTINATION_FILE_PATH = "D:\\others\\ldpolicygeneration\\destination";

    public void write(RolePolicyList rolePolicy) throws IOException, InterruptedException {


        Thread.sleep(1000);


        ObjectMapper objectMapper = new ObjectMapper();
        String rolePolicyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rolePolicy.getRolePolicies());


        rolePolicy.getRoleName();
        System.out.println(rolePolicyJson);

        FileWriter myWriter = new FileWriter(DESTINATION_FILE_PATH+"\\"+rolePolicy.getRoleName()+".txt");
        myWriter.write(rolePolicyJson);
        myWriter.close();



    }

    public void cleanDirectory() throws IOException {
        File policyDestination=new File(DESTINATION_FILE_PATH);
        FileUtils.cleanDirectory(policyDestination);
    }
}
