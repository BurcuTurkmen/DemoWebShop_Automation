package Test;

import POM.AccountPageElements;
import POM.HomePageElements;
import POM.LoginPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginFunctionalityTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    AccountPageElements accountPageElements;

    String expectedText = "bcf@gmail.com";

    @Parameters({"username", "password"})
    @Test
    public void loginPositiveTest(String username, String password) {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        accountPageElements = new AccountPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.loginButton)).click();

        wait.until(ExpectedConditions.visibilityOf(loginPageElements.emailInput)).sendKeys("bcf@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(loginPageElements.passwordInput)).sendKeys("123987");
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.loginButton)).click();

            Assert.assertTrue(AccountPageElements.accountInfoText.isDisplayed());
            Assert.assertEquals(accountPageElements.accountInfoText.getText(), expectedText);
    }


    @Parameters({"username", "password"})
    @Test
    public void loginNegativeTest(String username, String password) {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        accountPageElements = new AccountPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.loginButton)).click();

        loginPageElements.emailInput.sendKeys("cbf@gmail.com");
        loginPageElements.passwordInput.sendKeys("987123");
        loginPageElements.loginButton.click();

        String expectedUnsuccessfulResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        for (WebElement wb : accountPageElements.unsuccessfulText) {
            Assert.assertEquals(wb.getText(), expectedUnsuccessfulResult);
            Assert.assertTrue(wb.isDisplayed());

        }






    }

}
