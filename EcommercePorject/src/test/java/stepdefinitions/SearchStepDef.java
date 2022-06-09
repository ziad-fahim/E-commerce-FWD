package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class SearchStepDef {

    HomePage Home = new HomePage(Hooks.driver);
    String searchedProduct;

    @Given("^Type \"(.*)\" on search text box$")
    public void searchProduct(String product){
        Home.search.sendKeys(product);
        searchedProduct = product;
    }

    @When("Click on SEARCH button or hit enter key")
    public void clickSearch(){
        Home.searchButton.click();
        Hooks.rest();
    }

    @Then("User could find Apple products")
    public void searchAssertion(){
        SoftAssert searchAssertion = new SoftAssert();
        searchAssertion.assertEquals(Home.searchKeyword.getAttribute("value"),searchedProduct);
        searchAssertion.assertAll();
    }

    @Then("User could find Apple product")
    public void skuSearchAssertion(){
        SoftAssert searchAssertion = new SoftAssert();
        searchAssertion.assertEquals(Home.searchKeyword.getAttribute("value"),searchedProduct);
        searchAssertion.assertAll();
    }



}
