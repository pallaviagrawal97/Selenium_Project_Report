package wiring;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPageWiring extends BasePage {
    public CartPageWiring(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='cart_item']")
    protected List<WebElement> cartItem;

    @FindBy(xpath = "//span[text()='Your Cart']")
    protected WebElement yourCartTitle;

    @FindBy(xpath ="//button[@name='continue-shopping']")
    protected WebElement continueShoppingBtn;

    @FindBy(xpath ="//button[@name='checkout']")
    protected WebElement checkoutBtn;

    public WebElement getProductRemoveButtonOnCartPage(String productName){
        WebElement element = driver.findElement(new By.ByXPath("//div[text()='"+productName+"']/ancestor::a/following-sibling::div/button[text()='Remove']"));
        return element;
    }

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(yourCartTitle));
        return yourCartTitle.isDisplayed();
    }
}
