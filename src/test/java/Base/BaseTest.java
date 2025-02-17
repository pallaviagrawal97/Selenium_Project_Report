package Base;

import driverFactory.WebDriverFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.ConfigLoader;
import utils.Listners.ExtentListeners;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners(ExtentListeners.class)
public class BaseTest {

    protected WebDriver driver;
    public static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    Capabilities capabilities;

    private WebDriver getRemoteDriver() throws MalformedURLException {
        //Capabilities capabilities;
        if(System.getProperty("browser").equalsIgnoreCase("chrome"))
            capabilities = new ChromeOptions();
        else if(System.getProperty("browser").equalsIgnoreCase("firefox"))
            capabilities = new FirefoxOptions();
        else capabilities = new EdgeOptions();

        String urlFormat = ConfigLoader.getInstance().getSeleniumGridUrlFormat();
        String hubHost = ConfigLoader.getInstance().getSeleniumHubHost();
        String url = String.format(urlFormat,hubHost);

        log.info("The Grid URL being Used: {}", url);
        return new RemoteWebDriver(new URL(url), capabilities);
    }

    private WebDriver getLocalDriver(){
        return WebDriverFactory.getDriver(ConfigLoader.getInstance().getBrowser());
    }

    @BeforeTest
    public void setDriver(ITestContext context) throws MalformedURLException {
        this.driver = Boolean.parseBoolean(ConfigLoader.getInstance().getSeleniumGridEnabled()) ? getRemoteDriver() : getLocalDriver();
        context.setAttribute("driver",this.driver);
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}

