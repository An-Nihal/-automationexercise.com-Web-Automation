package Pages;

import Configs.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseDriver {

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //WebElements
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement logSignbutton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']" )
    WebElement passWordField;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @FindBy()


}
