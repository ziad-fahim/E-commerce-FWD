package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class HoverCategoriesStepDef {

    HomePage Home = new HomePage(Hooks.driver);
    Actions hover = new Actions(Hooks.driver);

    @Given("Hover the header menu and select random category then hover it")
        public void hoverHeader() {
        hover.moveToElement(Home.headerMenu).perform();
        Hooks.rest();
        hover.moveToElement(Home.menuComputers).perform();
        Hooks.rest();
        }

    @When("Click on random sub-category if found")
    public void clickSubCategory() {
        hover.moveToElement(Home.submenuSoftware);
        Hooks.rest();
        hover.click().build().perform();
        Hooks.rest();
    }

    @Then("User could open sub-category page")
    public void hoverAssertion(){
        SoftAssert registrationAssertion = new SoftAssert();
        registrationAssertion.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/software");
        registrationAssertion.assertAll();

    }



}
