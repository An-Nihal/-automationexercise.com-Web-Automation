package Configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;
    public String baseURl = "https://automationexercise.com/";

    @BeforeSuite
    public void start() {
        String browser = System.getProperty("browser", "chrome");


        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseURl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(baseURl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get(baseURl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @AfterSuite
    public void close() {

        driver.quit();
    }
}
