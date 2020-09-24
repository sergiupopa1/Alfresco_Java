package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    private WebElement LoginPageIdentification(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adf-login-form")));
    }
    private WebElement UserNameInputField(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    }
    private WebElement PasswordInputField(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    }
    private WebElement LoginButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
    }
    public boolean CheckLoginPageIsDisplayed() { return LoginPageIdentification().isDisplayed(); }

    public void ClickLoginButton() { LoginButton().click(); }

    public void FillUserNameAndPassword(String userName, String password){
        UserNameInputField().sendKeys(userName);
        PasswordInputField().sendKeys(password);
    }
}
