package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ResourceLoader {
    private static Logger log = LoggerFactory.getLogger(ResourceLoader.class);

    /**
     * Reads the properties from the file path
     * @param propertiesFilePath
     * @return
     */
    public static InputStream getResources (String propertiesFilePath) throws Exception{
        log.info("Reading Resource from Location: {}", propertiesFilePath);
        InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(propertiesFilePath);

        if(Objects.nonNull(stream))
            return stream;
        else
            return Files.newInputStream(Path.of(propertiesFilePath));
    }
}
