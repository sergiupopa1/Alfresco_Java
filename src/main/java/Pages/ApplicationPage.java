package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

public class ApplicationPage extends  BasePage{

    public ApplicationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private WebElement FilesPageIdentification() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-panel-title[contains(text(),'Recent Files')]")));
    }
    private WebElement HomePageIdentification() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-home-view")));
    }
    private WebElement NewFolderIcon() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-automation-id='create-new-folder']")));
    }
    private WebElement NewFolderNameInput() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adf-folder-name-input")));
    }
    private WebElement CreateButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adf-folder-create-button")));
    }
    private WebElement NewFolderDialog() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("mat-dialog-container[aria-modal='true']")));
    }
    private WebElement Notification() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("snack-bar-container")));
    }
    private WebElement DeleteButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-automation-id='DOCUMENT_LIST.ACTIONS.FOLDER.DELETE']")));
    }
    private WebElement CancelButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adf-folder-cancel-button")));
    }
    private Collection<WebElement> FilesTableElements() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//adf-datatable-row[@aria-label]")));
    }

    public boolean CheckFilesPageIsDisplayed() { return FilesPageIdentification().isDisplayed(); }

    public boolean CheckHomePageIsDisplayed() { return HomePageIdentification().isDisplayed(); }

    public void ClickNewFolderIcon() { NewFolderIcon().click(); }

    public void ClickCreateButton() { CreateButton().click(); }

    public void FillNewFolderNameInput(String name) { NewFolderNameInput().sendKeys(name); }

    public String GetNewFolderNameInput() { return NewFolderNameInput().getAttribute("value"); }

    public String GetNotificationText() { return Notification().getText(); }

    public void ClickDeleteButton() { DeleteButton().click(); }

    public void ClickCancelButton() { CancelButton().click(); }

    public boolean CheckNewFolderDialogIsDisplayed() { return NewFolderDialog().isDisplayed(); }

    public boolean CheckNewFolderDialogIsNotDisplayed() { return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("mat-dialog-container[aria-modal='true']")));}

    public void ClickActionMenuButtonForFolderName(String folderName) {

        for(WebElement element : FilesTableElements())
        {
            if(element.getText().contains(folderName))
            {
                element.findElement(By.xpath(".//button[@aria-label='Actions']")).click();
                break;
            }
        }
    }
    public void SelectFolderByName(String folderName) {

        for(WebElement element : FilesTableElements())
        {
            if(element.getText().contains(folderName))
            {
                element.click();
                break;
            }
        }
    }
    public boolean FindFolderByName(String folderName) {

        boolean result = false;

        for (WebElement element : FilesTableElements())
        {
            if (element.getAttribute("aria-label").contains(folderName))
            {
                result = true;
                break;
            }
        }
        return result;
    }
}