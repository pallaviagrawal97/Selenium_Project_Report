package wiring;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutOverviewWiring extends BasePage {
    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    protected WebElement checkoutOverviewTitle;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    protected WebElement totalPrice;

    @FindBy(xpath = "//button[@name='finish']")
    protected  WebElement finishButton;

    public CheckOutOverviewWiring(WebDriver driver) {
        super(driver);
        pageReady();
    }

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(checkoutOverviewTitle));
        return checkoutOverviewTitle.isDisplayed();
    }
}
