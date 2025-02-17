package agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigLoader;
import wiring.LoginPageWiring;

import static utils.Commons.logsReporter;

public class LoginAgent extends LoginPageWiring {
    private static final Logger log = LoggerFactory.getLogger(LoginAgent.class);
    private static String autoUrl = ConfigLoader.getInstance().getUrl();

    public LoginAgent(WebDriver driver) {
        super(driver);
    }

    public LoginAgent enterUserName(){
        logsReporter("Entering the username: "+ConfigLoader.getInstance().getUsername(), log);
        userName.sendKeys(ConfigLoader.getInstance().getUsername());
        return this;
    }

    public LoginAgent enterPassword(){
        logsReporter("Entering the password: "+ConfigLoader.getInstance().getPassword(), log);
        password.sendKeys(ConfigLoader.getInstance().getPassword());
        return this;
    }

    public ProductsAgent clickLoginButton(){
        logsReporter("Clicking on Login Button --> Navigate to Product Page", log);
        loginButton.click();
        return new ProductsAgent(driver);
    }

    public LoginAgent goToLoginPage(){
        logsReporter("Navigating to Page: "+ConfigLoader.getInstance().getUrl().toString(), log);
        this.driver.get(autoUrl);
        pageReady();
        return this;
    }
}
