package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ProductPage;

public class WishlistStepDef {

    @When("Click on add to wishlist icon")
    public void addProduct() throws InterruptedException {
        ProductPage Product = new ProductPage(Hooks.driver);
        Product.wishListIcon.click();
        Hooks.rest();
        Thread.sleep(1000);
    }

    @Then("the product is added to the user's wishlist and message appears says The product has been added to your wishlist")
    public void wishlistAssertion(){
        HomePage Home = new HomePage(Hooks.driver);
        SoftAssert wishlistAssertion = new SoftAssert();
        wishlistAssertion.assertEquals(Home.successNotificationContent.getText(),"The product has been added to your wishlist");
        wishlistAssertion.assertEquals(Home.successNotification.getCssValue("background-color"), "rgba(75, 176, 122, 1)");
        wishlistAssertion.assertAll();
    }

}
