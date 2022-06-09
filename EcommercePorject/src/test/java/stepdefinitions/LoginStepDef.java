package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.Login;
import pages.HomePage;

public class LoginStepDef {

    Login Log = new Login(Hooks.driver);
    HomePage Home = new HomePage(Hooks.driver);

    @Given("Click on Login tab")
    public void clickLoginTab(){
    	Home.loginTab.click();
    }

    @When("^User enter \"(.*)\" and \"(.*)\"$")
    public void enterLoginCredentials(String email, String password){
        Log.enterLogin(email, password);
    }

    @And("Click on login button")
    public void clickLoginButton(){
        Log.loginButton.click();
        Hooks.rest();
    }

    @Then("User could login successfully")
    public void loginAssertion(){
        SoftAssert loginAssertion = new SoftAssert();
        loginAssertion.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        loginAssertion.assertTrue(Home.myAccountTab.isDisplayed());
        loginAssertion.assertAll();
    }


}
