package Pages;

import Configs.BaseDriver;
import Utilities.Utilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUpPage extends BaseDriver {

    @FindBy(xpath = "//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]")
    public WebElement name;
    @FindBy(xpath = "//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]")
    public WebElement email;
    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    public WebElement signUpButton;
    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    public WebElement EnterAccountInfoForm;
    @FindBy(xpath = "//div[@id='uniform-id_gender1']")
    public WebElement genderMale;
    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement genderFemale;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameField;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordField;
    @FindBy(xpath = "//select[@id='days']")
    public WebElement dayDropdown;
    @FindBy(xpath = "//select[@id='months']")
    public WebElement monthDropdown;
    @FindBy(xpath = "//select[@id='years']")
    public WebElement yearDropdown;
    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement newsLetterCheckBox;
    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastnameField;
    @FindBy(xpath = "//input[@id='company']")
    public WebElement companyField;
    @FindBy(xpath = "//input[@id='address1']")
    public WebElement AddressField;
    @FindBy(xpath = "//select[@id='country']")
    public WebElement countryDropDown;
    @FindBy(xpath = "//input[@id='state']")
    public WebElement stateField;
    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityField;
    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipField;
    Utilities utilities = new Utilities();
    //WebElements
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement logSignbutton;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='optin']")
    WebElement offerCheckBox;
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement mobileField;
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createAccountButton;
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;
    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
    WebElement logOutButton;
    public SignUpPage() {

        PageFactory.initElements(driver, this);
    }


    //Test Methods//

    //Verify that home page is visible successfully
    public void homePageVisibility() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    //Click on 'Signup / Login' button
    public void gotoSignup() {
        logSignbutton.click();
    }

    //Enter name and email address
    public void enterNamePass() throws InterruptedException {

        name.clear();
        email.clear();

        name.sendKeys(utilities.LastName);
        Thread.sleep(1000);
        email.sendKeys(utilities.EMAIL);
        Thread.sleep(1000);
    }

    //Click 'Signup' button
    public void clickSignup() throws InterruptedException {

        signUpButton.click();
        Thread.sleep(2000);
    }

    //Verify that 'ENTER ACCOUNT INFORMATION' is visible
    public void verifyEnterAccInfo() {

        Assert.assertTrue(EnterAccountInfoForm.isDisplayed(), "ENTER ACCOUNT INFORMATION is not visible");

    }

    // Fill details: Title, Name, Email, Password, Date of birth
    public void fillAccInfoDetails() throws InterruptedException {


        genderMale.click();

        if (nameField.getAttribute("value").isEmpty()) {
            nameField.sendKeys(utilities.LastName);
        }
        if (emailField.getAttribute("value").isEmpty()) {
            emailField.sendKeys(utilities.EMAIL);
        }

        passwordField.sendKeys(utilities.PASSWORD);

        dayDropdown.click();
        for (int i = 0; i < 7; i++) {
            dayDropdown.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(300);
        }
        dayDropdown.sendKeys(Keys.ENTER);

        monthDropdown.click();
        for (int i = 0; i < 6; i++) {
            monthDropdown.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(300);
        }
        monthDropdown.sendKeys(Keys.ENTER);

        yearDropdown.click();
        for (int i = 0; i < 3; i++) {
            yearDropdown.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(300);
        }
        yearDropdown.sendKeys(Keys.ENTER);

        newsLetterCheckBox.click();
        offerCheckBox.click();
        Thread.sleep(1000);
    }

    //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    public void fillAddressInfoDetails() throws InterruptedException {


        firstNameField.sendKeys(utilities.FirstName);
        Thread.sleep(500);

        lastnameField.sendKeys(utilities.LastName);
        Thread.sleep(500);

        companyField.sendKeys(utilities.CompanyName);
        Thread.sleep(500);

        AddressField.sendKeys(utilities.Address);
        Thread.sleep(500);

        countryDropDown.click();
        Select select = new Select(countryDropDown);
        select.selectByValue("United States");
        Thread.sleep(500);

        stateField.sendKeys(utilities.State);
        Thread.sleep(500);
        cityField.sendKeys(utilities.City);
        Thread.sleep(500);
        zipField.sendKeys(utilities.Zip);
        Thread.sleep(500);
        mobileField.sendKeys(utilities.MobileNumber);
        Thread.sleep(500);
    }

    //Click 'Create Account button'
    public void clickCreateAccountButton() {
        createAccountButton.click();
    }
    //Verify that 'ACCOUNT CREATED!' is visible

    public void accountCreationVerification() {

        String expectedTitle = "Automation Exercise - Account Created";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Click on 'continue' and then Logout
    public void continueAndLogout() {
        continueButton.click();
        logOutButton.click();
    }

}







