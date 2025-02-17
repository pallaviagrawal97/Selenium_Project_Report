package agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import wiring.CheckOutOverviewWiring;

import static utils.Commons.logsReporter;

public class CheckoutOverviewAgent extends CheckOutOverviewWiring {

    private static final Logger log = LoggerFactory.getLogger(CheckoutOverviewAgent.class);

    public CheckoutOverviewAgent(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewAgent assertTotalPrice(Double totalprice){
        logsReporter("Asserting if Cart contains Expected items count: "+totalprice, log);
        Assert.assertTrue(totalPrice.getText().contains(String.valueOf(totalprice)));
        return this;
    }

    public CheckOutCompleteAgent clickOnFinishButton(){
        logsReporter("Click on Finish Button --> Navigate to Checkout Complete Page", log);
        finishButton.click();
        return new CheckOutCompleteAgent(driver);
    }
}
