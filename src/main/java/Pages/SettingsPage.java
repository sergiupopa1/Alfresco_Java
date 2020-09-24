package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

public class SettingsPage extends BasePage{

    public SettingsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private WebElement HomePageIdentification() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-tns-c136-1 ng-star-inserted'][contains(text(),'ALL')]")));
    }
    private WebElement ApplyButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("host-button")));
    }
    private WebElement ProviderDropDown() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("adf-provider-selector")));
    }
    private Collection<WebElement> ProviderDropDownElements() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("span.mat-option-text")));
    }

    public boolean CheckHomePageIsDisplayed() { return HomePageIdentification().isDisplayed(); }

    public void ClickApplyButton(){
        ApplyButton().click();
    }

    public void SelectProviderByName(String provider) throws Exception {
        ProviderDropDown().sendKeys(provider);
    }
}
