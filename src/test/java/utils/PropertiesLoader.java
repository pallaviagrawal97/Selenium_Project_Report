package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties;

    private static final String DEFAULT_PROPERTIES = "config.properties";
    protected PropertiesLoader(String filePath) {
        properties = loadProperties();
    }

    protected String getProperty(String propertyName) {
        String propertyValue = System.getProperty(propertyName) != null ? System.getProperty(propertyName) : properties.getProperty(propertyName);
        assert propertyValue != null : "Property \"" + propertyName + "\" is not specified in the config.properties file";
        return propertyValue;
    }

    /**
     * Loads properties from a given file path.
     *
     *
     * @return a `Properties` object containing the loaded properties
     * @throws RuntimeException if an error occurs while processing the properties file
     */
    private Properties loadProperties() {
        Properties properties = new Properties();
        try(InputStream stream = ResourceLoader.getResources(DEFAULT_PROPERTIES)){
            properties.load(stream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process properties file " + DEFAULT_PROPERTIES, e);
        }
        return properties;
    }
}
