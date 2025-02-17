package tests;

import Base.BaseTest;
import agent.LoginAgent;
import enumeration.ProductNameEnum;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class VerifyCartIsEmptyWhenProductsRemoved extends BaseTest {

    private LoginAgent loginPage;

    List<String> listOfProducts = new ArrayList<>();


    @BeforeMethod
    public void setUpPage(){
        loginPage = new LoginAgent(driver);
    }

    @Test(groups = {"functional"},
            attributes = {@CustomAttribute(name="Pallavi")},
            description = "Validate Cart Is Empty Functionality")
    public void verifyCartIsEmpty(){
        listOfProducts.add(ProductNameEnum.SAUCE_LABS_FLEECE_JACKET.product);
        listOfProducts.add(ProductNameEnum.SAUCE_LABS_BOLT_TSHIRT.product);

        loginPage.goToLoginPage()
                .enterUserName()
                .enterPassword()
                .clickLoginButton()
                .addproductsToCart(listOfProducts)
                .clickCartButton()
                .assertCartItems(listOfProducts.size())
                .removeProductsFromCartsPage(listOfProducts)
                .assertCartIsEmpty();

    }
}
