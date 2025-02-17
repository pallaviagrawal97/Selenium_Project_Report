package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class JSONUtils {

    private static final Logger log = LoggerFactory.getLogger(JSONUtils.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Reads the Record and returns the testData
     * @param path
     * @param type
     * @return
     * @param <T>
     */
    public static <T> T getData(String path, Class<T> type){
        try(InputStream stream = ResourceLoader.getResources(path)){
            return mapper.readValue(stream, type);
        }catch (Exception e) {
            log.error("Unable To Read Test data {}", path,e);
        }
        return null;
    }
}
