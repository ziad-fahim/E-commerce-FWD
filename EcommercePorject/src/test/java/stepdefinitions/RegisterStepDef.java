package stepdefinitions;


import org.testng.asserts.SoftAssert;
import pages.Rgister;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;


public class RegisterStepDef {

    Rgister Reg = new Rgister(Hooks.driver);

    @Given("Click on Register tab")
    public void clickRegisterTab(){
        HomePage Home = new HomePage(Hooks.driver);
        Home.registerTab.click();
    }

    @When("Click on any radio button to chose gender")
    public void choseGender(){
        Reg.gender.click();
    }

    @And("User enter First name and Last name")
    public void fillName(){
        Reg.firstName.sendKeys("Gherkin");
        Reg.lastName.sendKeys("Cucumber");
    }

    @And("User Select Date of Birth: Select [Day, Month, Year]")
    public void pickDate(){
        Reg.dobDay.click();
        Reg.dobMonth.click();
        Reg.dobYear.click();
    }

    @And("^User enter email: \"(.*)\"$")
    public void fillEmail(String email){
        Reg.email.sendKeys(email);
    }

    @And("Fill Company name")
    public void fillCompanyName(){
        Reg.company.sendKeys("Selenium");
    }

    @And("^User enter Password and Confirm it: \"(.*)\"$")
    public void fillPassword(String password){
        Reg.password.sendKeys(password);
        Reg.confirmPassword.sendKeys(password);
    }

    @And("Click on REGISTER button")
    public void clickRegisterButton(){
        Reg.registerButton.click();
        Hooks.rest();
    }

    @Then("User could register successfully")
    public void RegistrationAssertion(){
        SoftAssert registrationAssertion = new SoftAssert();
        registrationAssertion.assertTrue(Reg.registrationComplete.getText().contains("Your registration completed"));
        registrationAssertion.assertEquals(Reg.registrationComplete.getCssValue("color"), "rgba(76, 177, 124, 1)");
        registrationAssertion.assertAll();
    }

    @And("Click on CONTINUE button")
    public void clickContinue(){
        Reg.continueButton.click();
        Hooks.rest();
    }

}
