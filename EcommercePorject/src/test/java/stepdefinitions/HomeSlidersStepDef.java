package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;


public class HomeSlidersStepDef {

    HomePage Home = new HomePage(Hooks.driver);

    @Given("Click on Nokia banner controller")
    public void clickNokiaController(){
        Home.controllerNokia.click();
    }

    @When("Click on Nokia banner")
    public void clickNokiaBanner(){
        Home.bannerNokia.click();
        Hooks.rest();
    }

    @Then("User could click on the banner and redirect to the Nokia link")
    public void slidersAssertionNokia(){
        SoftAssert slidersAssertion = new SoftAssert();
        slidersAssertion.assertEquals(Home.bannerNokia.getAttribute("href"), "http://demo.nopcommerce.com/");
        slidersAssertion.assertAll();
    }

    @Given("Click on IPhone banner controller")
    public void clickIPhoneController(){
        Home.controllerIPhone.click();
    }

    @When("Click on IPhone banner")
    public void clickIPhoneBanner(){
        Home.bannerIPhone.click();
    }

    @Then("User could click on the banner and redirect to the IPhone link")
    public void slidersAssertionIPhone(){
        SoftAssert slidersAssertion = new SoftAssert();
        slidersAssertion.assertEquals(Home.bannerIPhone.getAttribute("href"), "http://demo.nopcommerce.com/");
        slidersAssertion.assertAll();
    }

}
