package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties;

    protected PropertiesLoader(String filePath) {
        properties = loadProperties(filePath);
    }

    protected String getProperty(String propertyName) {
        String propertyValue = System.getProperty(propertyName) != null ? System.getProperty(propertyName) : properties.getProperty(propertyName);
        assert propertyValue != null : "Property \"" + propertyName + "\" is not specified in the config.properties file";
        return propertyValue;
    }

    /**
     * Loads properties from a given file path.
     *
     * @param filePath the path to the properties file
     * @return a `Properties` object containing the loaded properties
     * @throws RuntimeException if an error occurs while processing the properties file
     */
    private Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to process properties file " + filePath, e);
        }
        return properties;
    }
}
