package Pages;

import Configs.BaseDriver;
import Utilities.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseDriver {

    Utilities utilities = new Utilities();
    //WebElements
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement logSignbutton;
    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    WebElement loginToYourAccountText;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passWordField;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//li[10]//a[1]")
    WebElement loggedInAs;
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement deleteAccountButton;
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement accountDeletedConfirmation;
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    //Test Methods//

    //Click on 'Signup / Login' button
    public void clickLogSign() {

        logSignbutton.click();
    }

    //Verify 'Login to your account' is visible
    public void LoginToYourAccountVerify() {
        Assert.assertTrue(loginToYourAccountText.isDisplayed(), "Login to Your account is not visible");
    }

    //Enter correct email address and password and  Click 'login' button
    public void performLogin() throws InterruptedException {
        emailField.sendKeys(utilities.EMAIL);
        Thread.sleep(500);
        passWordField.sendKeys(utilities.PASSWORD);
        Thread.sleep(500);
        loginButton.click();
    }

    //Verify that 'Logged in as username' is visible
    public void loggedInAsVerification() {

        String expectedUserLoggedIn = "Logged in as " + utilities.LastName;
        String actualUserLoggedIn = loggedInAs.getText();

        Assert.assertEquals(actualUserLoggedIn, expectedUserLoggedIn);
    }

    //Click 'Delete Account' button
    public void clickOnDeleteButton() {
        deleteAccountButton.click();
    }

    //Verify that 'ACCOUNT DELETED!' is visible

    public void verifyAccountIsDeleted() {
        Assert.assertTrue(accountDeletedConfirmation.isDisplayed(), "'ACCOUNT DELETED!' is not visible");
        continueButton.click();
    }


}
