package agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wiring.ProductsPageWiring;

import java.util.List;

import static utils.Commons.logsReporter;

public class ProductsAgent extends ProductsPageWiring {
    private static final Logger log = LoggerFactory.getLogger(ProductsAgent.class);
    public ProductsAgent(WebDriver driver) {
        super(driver);
        pageReady();
    }

    public ProductsAgent addproductsToCart(List<String> list){

        for(int i=0;i<list.size();i++){
            logsReporter("Click on product : "+list.get(i)+" Add to cart button", log);
            getProductAddToCartButton(list.get(i)).click();
        }
        return this;
    }

    public ProductsAgent removeProducts(List<String> list){
        for(int i=0;i<list.size();i++){
            logsReporter("Click on product : "+list.get(i)+" Remove button", log);
            getProductRemoveButton(list.get(i)).click();
        }
        return this;
    }

    public CartAgent clickCartButton(){
        logsReporter("Click Cart Button --> Navigate to Cart Page", log);
        cartButton.click();
        return new CartAgent(driver);
    }
}
