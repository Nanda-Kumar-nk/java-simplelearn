package api_ld.v2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nanda Kumar
 * @since 03/11/2022
 */
public class UserConfiguration {

    public static final int DEFAULT_BATCH_LIMIT = 50;
    private Map<String, String> fields=new HashMap();

    public int waitForSeconds=0;
    private ENV env;

    public int getBatchLimit() {
        return batchLimit;
    }

    private int batchLimit;

    public UserConfiguration setFieldIdentifier(Map<String, String> fields) {
        this.fields=fields;
        return this;
    }

    public UserConfiguration setEnv(ENV env) {
        this.env=env;
        return this;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public ENV getEnv() {
        return env;
    }

    public UserConfiguration setBatchLimit(int batchLimit) {
        if(batchLimit==0){
            this.batchLimit=DEFAULT_BATCH_LIMIT;
        }else {
            this.batchLimit = batchLimit;
        }
        return this;
    }

    public UserConfiguration setWithWaitForSeconds(int seconds) {
        this.waitForSeconds=seconds;
        return this;
    }

    public int getWaitForSeconds() {
        return waitForSeconds;
    }
}