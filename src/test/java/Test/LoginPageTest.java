package Test;

import Configs.BaseDriver;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseDriver {

    LoginPage loginPage;

    @Test(priority = 1, description = "Click on 'Signup / Login' button")
    public void clickLogSign() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.clickLogSign();
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Verify 'Login to your account' is visible")
    public void verifyLoginPage() throws InterruptedException {
        loginPage.LoginToYourAccountVerify();
        Thread.sleep(300);
    }

    @Test(priority = 3, description = "Enter correct email address and password and  Click 'login' button")
    public void doLogin() throws InterruptedException {
        loginPage.performLogin();
        Thread.sleep(2000);
    }

    @Test(priority = 4, description = "Verify that 'Logged in as username' is visible")
    public void verifyUserLoggedIn() throws InterruptedException {
        loginPage.loggedInAsVerification();
        Thread.sleep(300);
    }

    @Test(priority = 5, description = "Click 'Delete Account' button and Verify that 'ACCOUNT DELETED!' is visible")
    public void performAccountDeletionAndVerify() throws InterruptedException {
        loginPage.clickOnDeleteButton();
        loginPage.verifyAccountIsDeleted();
        Thread.sleep(2000);
    }


}
