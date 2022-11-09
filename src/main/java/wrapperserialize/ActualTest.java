package wrapperserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import wrapperserialize.olingo.ODataDeltaFeedImpl;

import java.util.Date;

/**
 * @author Nanda Kumar
 * @since 31/10/2022
 */
public class ActualTest {

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {

        ODataDeltaFeedImpl oDataDeltaFeed=new ODataDeltaFeedImpl();
        jsonMapper.writeValueAsString(oDataDeltaFeed);
        System.out.println(oDataDeltaFeed);

    }
}
