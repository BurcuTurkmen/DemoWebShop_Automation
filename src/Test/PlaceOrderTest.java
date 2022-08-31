package Test;

import POM.AccountPageElements;
import POM.HomePageElements;
import POM.LoginPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    AccountPageElements accountPageElements;

    @Parameters({"username", "password", "country", "state", "city", "address", "zipCode", "phoneNumber"  })
    @Test
    public void PlaceAnOrder(String username, String password, String country, String state, String city, String address, String zipCode, String phoneNumber) {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        accountPageElements = new AccountPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.loginButton)).click();

        wait.until(ExpectedConditions.visibilityOf(loginPageElements.emailInput)).sendKeys("bcf@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(loginPageElements.passwordInput)).sendKeys("123987");
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.loginButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.addToCart)).click();

       //for (WebElement we : homePageElements.productList) {
         //  homePageElements.productList.get(2);
           //we.click(); }

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.shoppingCart)).click();

        wait.until(ExpectedConditions.urlToBe("http://demowebshop.tricentis.com/cart"));

        accountPageElements.termCondRadioButton.click();
        accountPageElements.checkoutButton.click();


        Select selectCountry = new Select(accountPageElements.country);
        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.country));
        selectCountry.selectByVisibleText("United States");

        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.state)).click();

        Select selectState = new Select(accountPageElements.state);
        selectState.selectByVisibleText("Illinois");

        accountPageElements.city.sendKeys("Libertyville");
        accountPageElements.address.sendKeys("BlueWater");
        accountPageElements.zipCode.sendKeys("60048");
        accountPageElements.phoneNumber.sendKeys("8479863520");
        accountPageElements.continueButton.click();

        wait.until(ExpectedConditions.urlToBe("http://demowebshop.tricentis.com/onepagecheckout"));



        //wait.until(ExpectedConditions.elementToBeSelected(accountPageElements.billingAddress));

        driver.switchTo().frame("frame1");

        wait.until(ExpectedConditions.visibilityOf(accountPageElements.billingAddressFrame));

        //wait.until(ExpectedConditions.stalenessOf(accountPageElements.billingAddress));
        Select selectAddress = new Select(accountPageElements.billingAddress);
        selectAddress.selectByVisibleText("Betty Swanson, BlueWater, Libertyville, Illinois, 60048, United States");

        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.continueBilling)).click();
        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.shippingAddressContinueButton)).click();

        wait.until(ExpectedConditions.visibilityOf(accountPageElements.groundRadioButton)).click();
        accountPageElements.shippingMethodContinueButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.purchaseOrder)).click();
        accountPageElements.paymentMethodContinueButton.click();

        wait.until(ExpectedConditions.visibilityOf(accountPageElements.paymentInfoText));
        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.paymentInfoContinueButton)).click();

        wait.until(ExpectedConditions.visibilityOf(accountPageElements.orderSummary));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        accountPageElements.confirmButton.click();

        wait.until(ExpectedConditions.urlToBe("http://demowebshop.tricentis.com/checkout/completed/"));

        wait.until(ExpectedConditions.visibilityOf(accountPageElements.orderConfirmationText));
        String expectedConfirmationText = "Your order has been successfully processed!";

        Assert.assertTrue(accountPageElements.orderConfirmationText.isDisplayed());
        Assert.assertEquals(accountPageElements.orderConfirmationText.getText(), expectedConfirmationText);

    }

}
