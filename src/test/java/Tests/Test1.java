package Tests;

import Pages.ApplicationPage;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.SettingsPage;
import config.ConfigParameters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends BaseTest{

    @Test
    public void FirstTest() throws Exception {

        BasePage basePage = new BasePage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        SettingsPage settingsPage = new SettingsPage(driver, wait);
        ApplicationPage applicationPage = new ApplicationPage(driver, wait);

        //navigate to settings page and select provider
        basePage.NavigateToUrl(ConfigParameters.settingsURL);
        settingsPage.CheckHomePageIsDisplayed();
        settingsPage.SelectProviderByName(ConfigParameters.provider);
        settingsPage.ClickApplyButton();

        //login
        loginPage.CheckLoginPageIsDisplayed();
        loginPage.FillUserNameAndPassword(ConfigParameters.username, ConfigParameters.password);
        loginPage.ClickLoginButton();

        //check files page
        applicationPage.CheckHomePageIsDisplayed();
        basePage.NavigateToUrl(ConfigParameters.filesURL);
        applicationPage.CheckFilesPageIsDisplayed();

        //create new folder and check that folder has been created
        applicationPage.ClickNewFolderIcon();
        Assert.assertTrue(applicationPage.CheckNewFolderDialogIsDisplayed());
        applicationPage.FillNewFolderNameInput(ConfigParameters.username);
        Assert.assertEquals(applicationPage.GetNewFolderNameInput(), ConfigParameters.username);
        applicationPage.ClickCreateButton();
        Assert.assertTrue(applicationPage.CheckNewFolderDialogIsNotDisplayed());
        Assert.assertTrue(applicationPage.FindFolderByName(ConfigParameters.username));

        //try to create new folder with existing name
        applicationPage.ClickNewFolderIcon();
        Assert.assertTrue(applicationPage.CheckNewFolderDialogIsDisplayed());
        applicationPage.FillNewFolderNameInput(ConfigParameters.username);
        Assert.assertEquals(applicationPage.GetNewFolderNameInput(), ConfigParameters.username);
        applicationPage.ClickCreateButton();
        Assert.assertTrue(applicationPage.CheckNewFolderDialogIsDisplayed());
        Assert.assertEquals(applicationPage.GetNotificationText(), ConfigParameters.errorMessage);
        applicationPage.ClickCancelButton();

        //delete folder that has been created
        applicationPage.SelectFolderByName(ConfigParameters.username);
        applicationPage.ClickActionMenuButtonForFolderName(ConfigParameters.username);
        applicationPage.ClickDeleteButton();
    }
}
