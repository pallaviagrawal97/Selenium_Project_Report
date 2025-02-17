package agent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import wiring.CartPageWiring;

import java.util.List;

import static utils.Commons.logsReporter;

public class CartAgent extends CartPageWiring {
    private static final Logger log = LoggerFactory.getLogger(CartAgent.class);

    public CartAgent(WebDriver driver) {
        super(driver);
        pageReady();
    }

    public CartAgent assertCartItems(int expectedCount){
        logsReporter("Asserting if Cart contains Expected items count: "+expectedCount, log);
        Assert.assertEquals(this.cartItem.size(),expectedCount);
        return this;
    }

    public CartAgent removeProductsFromCartsPage(List<String> list){
        for(int i=0;i<list.size();i++){
            logsReporter("Click on product : "+list.get(i)+" Remove button on Carts Page", log);
            getProductRemoveButtonOnCartPage(list.get(i)).click();
        }
        return this;
    }

    public void assertCartIsEmpty(){
        logsReporter("Asserting if Cart is Empty", log);
        Assert.assertEquals(this.cartItem.size(),0);
    }

    public ProductsAgent clickOnContinueShopping(){
        logsReporter("Click on Continue Shopping Button --> Navigate to Products Page", log);
        continueShoppingBtn.click();
        return new ProductsAgent(driver);
    }

    public CheckoutAgent clickOnCheckout(){
        logsReporter("Click on Continue Shopping Button --> Navigate to Products Page", log);
        checkoutBtn.click();
        return new CheckoutAgent(driver);
    }
}
