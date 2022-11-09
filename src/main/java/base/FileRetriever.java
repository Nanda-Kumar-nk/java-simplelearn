package base;

import java.io.File;
import java.net.URL;

/**
 * @author Nanda Kumar
 * @since 10/12/2021
 */
public class FileRetriever {

    public File getFileFromResources(String fileName){
        URL url = this.getClass()
                .getClassLoader()
                .getResource(fileName);
       return new File(url.getFile());
    }
}
