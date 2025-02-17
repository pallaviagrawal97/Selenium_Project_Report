package wiring;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutCompleteWiring extends BasePage {
    @FindBy(xpath = "//span[text()='Checkout: Complete!']")
    protected WebElement checkoutCompleteTitle;

    @FindBy(xpath = "//h2[@class='complete-header']")
    protected  WebElement message;

    public CheckOutCompleteWiring(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(checkoutCompleteTitle));
        return checkoutCompleteTitle.isDisplayed();
    }
}
