package utils;

public class ConfigLoader extends PropertiesLoader{
    private static ConfigLoader configurationLoader;

    private ConfigLoader() {
        super("src/test/resources/config.properties");
    }


    /**
     * Gets the singleton instance of the class.
     *
     * @return The ConfigLoader instance
     */
    public static ConfigLoader getInstance() {
        if (configurationLoader == null) {
            configurationLoader = new ConfigLoader();
        }
        return configurationLoader;
    }

    /**
     * Gets the URL from the config properties.
     *
     * @return The "url" property
     * @throws RuntimeException If property is not specified
     */
    public String getUrl() {
        return getProperty("url");
    }

    /**
     * Gets the username from the config properties.
     *
     * @return The "username" property
     * @throws RuntimeException If property is not specified
     */
    public String getUsername() {
        return getProperty("username");
    }

    /**
     * Gets the password from the config properties.
     *
     * @return The "password"  property
     * @throws RuntimeException If property is not specified
     */
    public String getPassword() {
        return getProperty("password");
    }

    /**
     * Gets the browser from the config properties.
     *
     * @return The "browser"  property
     * @throws RuntimeException If property is not specified
     */
    public String getBrowser() {
        return getProperty("browser");
    }

    /**
     * Gets the Selenium Grid Enabled from the config properties.
     *
     * @return The "browser"  property
     * @throws RuntimeException If property is not specified
     */
    public String getSeleniumGridEnabled(){ return getProperty("selenium.grid.enabled");}

    /**
     * Gets the Selenium Grid Url Format from the config properties.
     *
     * @return The "browser"  property
     * @throws RuntimeException If property is not specified
     */
    public String getSeleniumGridUrlFormat(){ return getProperty("selenium.grid.url.format");}

    /**
     * Gets the Selenium Grid Hub Host from the config properties.
     *
     * @return The "browser"  property
     * @throws RuntimeException If property is not specified
     */
    public String getSeleniumHubHost(){ return getProperty("selenium.grid.hub.host");}
}
