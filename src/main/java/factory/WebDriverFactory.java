package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class WebDriverFactory {

    private static ChromeOptions chromeOption = new ChromeOptions();

    private static final Supplier<WebDriver> chromeSupplier = () -> {
        chromeOption.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOption);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    };
    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        return driver;
    };
    private static final Supplier<WebDriver> edgeSupplier = EdgeDriver::new;

    private static Map<String,Supplier<WebDriver>> DRIVER_MAP_SUPPLIER = Map.of(
            "chrome" , chromeSupplier,
            "firefox", firefoxSupplier,
            "edge", edgeSupplier
    );

    public static WebDriver getDriver(String browser){return DRIVER_MAP_SUPPLIER.get(browser).get();}


    }

