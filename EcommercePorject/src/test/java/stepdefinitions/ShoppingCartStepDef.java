package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ProductPage;

public class ShoppingCartStepDef {

    @When("Click on ADD TO CART button")
    public void addCart() throws InterruptedException {
        ProductPage Product = new ProductPage(Hooks.driver);
        Product.addCart.click();
        Hooks.rest();
        Thread.sleep(1000);
    }

    @Then("the product is added to the user's shopping cart and message appears says The product has been added to your shopping cart")
    public void cartAssertion(){
        HomePage Home = new HomePage(Hooks.driver);
        SoftAssert wishlistAssertion = new SoftAssert();
        wishlistAssertion.assertEquals(Home.successNotificationContent.getText(),"The product has been added to your shopping cart");
        wishlistAssertion.assertEquals(Home.successNotification.getCssValue("background-color"), "rgba(75, 176, 122, 1)");
        wishlistAssertion.assertAll();
    }

}
