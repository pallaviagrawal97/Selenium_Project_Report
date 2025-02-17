package CartTests;

import Base.BaseTest;
import agent.LoginAgent;
import enumeration.ProductNameEnum;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import record.UserRecord;
import utils.JSONUtils;

import java.util.ArrayList;
import java.util.List;

public class VerifyDetailsOnCheckoutOverviewPage extends BaseTest {

    private LoginAgent loginPage;

    List<String> listOfProducts = new ArrayList<>();
    protected String testDataPath = "src/main/resources/test-data/";
    private UserRecord record = JSONUtils.getData(testDataPath+"userDetails1.json", UserRecord.class);


    @BeforeMethod
    public void setUpPage(){
        loginPage = new LoginAgent(driver);
    }

    @Test(groups = {"functional"},
            attributes = {@CustomAttribute(name="Pallavi")},
            description = "Validate End to End Checkout Functionality")
    public void verifyAllProductsTest(){
        listOfProducts.add(record.product1());
        listOfProducts.add(record.product2());

        loginPage.goToLoginPage()
                .enterUserName()
                .enterPassword()
                .clickLoginButton()
                .addproductsToCart(listOfProducts)
                .clickCartButton()
                .assertCartItems(listOfProducts.size())
                .removeProductsFromCartsPage(listOfProducts)
                .clickOnContinueShopping()
                .addproductsToCart(listOfProducts)
                .clickCartButton()
                .assertCartItems(listOfProducts.size())
                .clickOnCheckout()
                .enterFirstName(record.firstName())
                .enterLastName(record.lastName())
                .enterZip(record.zip())
                .clickOnContinueBtn()
                .assertTotalPrice(record.totalPrice())
                .clickOnFinishButton()
                .assertThankyouMessage("Thank you for your order!");
    }
}
