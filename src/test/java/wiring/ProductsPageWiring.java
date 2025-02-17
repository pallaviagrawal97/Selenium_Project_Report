package wiring;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPageWiring extends BasePage {

    @FindBy(xpath="//div[text()='Sauce Labs Backpack']/parent::a/parent::div/following-sibling::div/button")
    protected WebElement productButton;

    @FindBy(xpath = "//span[text()='Products']")
    protected WebElement productPageTitle;

    @FindBy(xpath = "//div/a[@class='shopping_cart_link']")
    protected WebElement cartButton;

    public ProductsPageWiring(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductRemoveButton(String productName){
        WebElement element = driver.findElement(new By.ByXPath("//div[text()='"+productName+"']/ancestor::div/following-sibling::div/button[text()='Remove']"));
        return element;
    }

    public WebElement getProductAddToCartButton(String productName){
        WebElement element = driver.findElement(new By.ByXPath("//div[text()='"+productName+"']/ancestor::div/following-sibling::div/button[text()='Add to cart']"));
        return element;
    }

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(productPageTitle));
        return productPageTitle.isDisplayed();
    }
}
