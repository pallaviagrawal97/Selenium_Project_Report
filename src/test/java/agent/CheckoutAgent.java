package agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wiring.CheckOutYourInformationWiring;

import static utils.Commons.logsReporter;

public class CheckoutAgent extends CheckOutYourInformationWiring {
    private static final Logger log = LoggerFactory.getLogger(CheckoutAgent.class);
    public CheckoutAgent(WebDriver driver) {
        super(driver);
    }

    public CheckoutAgent enterFirstName(String firstname){
        logsReporter("Entering the FirstName: "+ firstname, log);
        firstName.sendKeys(firstname);
        return this;
    }

    public CheckoutAgent enterLastName(String lastname){
        logsReporter("Entering the LastName: "+lastname, log);
        lastName.sendKeys(lastname);
        return this;
    }

    public CheckoutAgent enterZip(String postalCode){
        logsReporter("Entering the postal code: "+postalCode, log);
        zip.sendKeys(postalCode);
        return this;
    }

    public CheckoutOverviewAgent clickOnContinueBtn(){
        logsReporter("Click on Continue Shopping Button --> Navigate to Checkout Overview Page", log);
        continueButton.click();
        return new CheckoutOverviewAgent(driver);
    }


}
