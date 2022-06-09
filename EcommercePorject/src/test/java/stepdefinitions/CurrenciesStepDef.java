package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class CurrenciesStepDef {

    HomePage Home = new HomePage(Hooks.driver);
    Select selector = new Select(Home.customerCurrency);
    String Currency;

    @Given("Look for products currency")
    public void lookProductsCurrency(){
        if (Home.productCurrency.getText().contains("$") == true)
            Currency = "US Dollar";
        else
            Currency = "Euro";
    }

    @When("Change the currency")
    public void changeCurrency(){
        if (Currency == "US Dollar") {
            selector.selectByVisibleText("Euro");
            Currency = "Euro";
        }else {
            selector.selectByVisibleText("US Dollar");
            Currency = "US Dollar";
        }
        Hooks.rest();
    }

    @Then("User could find the selected currency")
    public void currencyAssertion(){
        SoftAssert currencyAssertion = new SoftAssert();
        Home.customerCurrency = selector.getFirstSelectedOption();
        currencyAssertion.assertTrue(Home.customerCurrency.getText().contains(Currency));
        currencyAssertion.assertAll();
    }

}
