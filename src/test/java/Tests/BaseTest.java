package Tests;

import config.ConfigParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void Initialize() {
        System.setProperty("webdriver.chrome.driver", ConfigParameters.pathToChromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, ConfigParameters.timeout);
    }

    @AfterMethod
    public void CloseDriver() {
        driver.close();
    }

}
