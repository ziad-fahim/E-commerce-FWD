package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.HomePage;


public class FollowUsStepDef {

    HomePage Home = new HomePage(Hooks.driver);
    Actions keys = new Actions(Hooks.driver);
    SoftAssert urlAssertion = new SoftAssert();

    @Given("Scroll down to the bottom")
    public void scrollDown(){
        JavascriptExecutor executor = (JavascriptExecutor) Hooks.driver;
        executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Hooks.rest();

    }

    @When("Click on facebook icon")
    public void clickFacebook() throws InterruptedException {
        Home.facebook.click();
        Thread.sleep(3000);
        keys.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.TAB));
    }

    @And("Click on twitter icon")
    public void clickTwitter() throws InterruptedException {
        Home.twitter.click();
        Thread.sleep(3000);
        keys.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.TAB));
    }

    @And("Click on rss icon")
    public void clickRSS() throws InterruptedException {
        keys.keyDown(Keys.LEFT_CONTROL).click(Home.rss).keyUp(Keys.LEFT_CONTROL).build().perform();
        Thread.sleep(3000);
        keys.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.TAB));
    }

    @And("Click on youtube icon")
    public void clickYoutube() throws InterruptedException {
        Home.youtube.click();
        Thread.sleep(3000);
        keys.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.TAB));
    }

    @Then("User could open facebook page")
    public void facebookAssertion(){
        urlAssertion.assertEquals(Home.facebook.getAttribute("href"),"http://www.facebook.com/nopCommerce");
        urlAssertion.assertAll();
    }

    @And("User could open twitter page")
    public void twitterAssertion(){
        urlAssertion.assertEquals(Home.twitter.getAttribute("href"),"https://twitter.com/nopCommerce");
        urlAssertion.assertAll();
    }

    @And("User could open rss page")
    public void rssAssertion(){
        urlAssertion.assertEquals(Home.rss.getAttribute("href"),"https://demo.nopcommerce.com/news/rss/1");
        urlAssertion.assertAll();
    }

    @And("User could open youtube page")
    public void youtubeAssertion(){
        urlAssertion.assertEquals(Home.youtube.getAttribute("href"),"http://www.youtube.com/user/nopCommerce");
        urlAssertion.assertAll();
    }

}
