package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(css = "div[class=\"buttons\"] button[type=\"submit\"]")
    public WebElement loginButton;

    public void enterLogin(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
    }

}
