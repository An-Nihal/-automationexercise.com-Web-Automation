package Test;

import Configs.BaseDriver;
import Pages.SignUpPage;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseDriver {
    SignUpPage signUpPage;

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void homeVisibilityVerify() throws InterruptedException {

        signUpPage = new SignUpPage(driver);

        signUpPage.homePageVisibility();

    }

    @Test(priority = 2, description = "Click on 'Signup / Login' button")
    public void clickLoginSignupButton() throws InterruptedException {
        signUpPage.gotoSignup();
        Thread.sleep(2000);
    }

    @Test(priority = 3, description = "Enter name and email address and click on Signup")
    public void signUpPerform() throws InterruptedException {
        signUpPage.enterNamePass();
        signUpPage.clickSignup();
        Thread.sleep(2000);

    }

    @Test(priority = 4, description = "Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void verifyAccountInfoVisibility() throws InterruptedException {
        signUpPage.verifyEnterAccInfo();
        Thread.sleep(500);
    }

    @Test(priority = 5, description = "Fill details: Title, Name, Email, Password, Date of birth")
    public void accountInfoFillup() throws InterruptedException {

        signUpPage.fillAccInfoDetails();
    }

    @Test(priority = 6, description = "Fill up Address information")
    public void addressInfoFillup() throws InterruptedException {
        signUpPage.fillAddressInfoDetails();
    }

    @Test (priority =7, description = "Click 'Create Account button'")
    public void createAccountClick() throws InterruptedException {
        signUpPage.clickCreateAccountButton();
        Thread.sleep(2000);
    }

    @Test(priority = 8,description = "Verify that 'ACCOUNT CREATED!' is visible")
    public void verifyAccountCreate(){

        signUpPage.accountCreationVerification();
    }


}


