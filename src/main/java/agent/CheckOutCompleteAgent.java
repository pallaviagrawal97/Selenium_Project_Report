package agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import wiring.CheckOutCompleteWiring;

import static utils.Commons.logsReporter;

public class CheckOutCompleteAgent extends CheckOutCompleteWiring {

    private static final Logger log = LoggerFactory.getLogger(CheckOutCompleteAgent.class);
    public CheckOutCompleteAgent(WebDriver driver) {
        super(driver);
    }

    public void assertThankyouMessage(String msg){
        logsReporter("Asserting the thankyou message: "+msg, log);
        Assert.assertEquals(message.getText(),msg);
    }
}
