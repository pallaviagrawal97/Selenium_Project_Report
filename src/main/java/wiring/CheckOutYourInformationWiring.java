package wiring;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutYourInformationWiring extends BasePage {

    @FindBy(xpath = "//span[text()='Checkout: Your Information']")
    protected WebElement checkoutTitle;

    @FindBy(xpath = "//input[@name='firstName']")
    protected WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    protected WebElement lastName;

    @FindBy(xpath = "//input[@name='postalCode']")
    protected WebElement zip;

    @FindBy(xpath = "//input[@name='continue']")
    protected WebElement continueButton;

    public CheckOutYourInformationWiring(WebDriver driver) {
        super(driver);
        pageReady();
    }

    @Override
    public boolean pageReady() {
       this.wait.until(ExpectedConditions.visibilityOf(checkoutTitle));
       return checkoutTitle.isDisplayed();
    }
}
