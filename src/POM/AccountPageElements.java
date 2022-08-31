package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPageElements {
    public AccountPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "bcf@gmail.com")
    public static WebElement accountInfoText;

    //@FindBy(xpath = "//span[text()='Login was unsuccessful. Please correct the errors and try again.']")
    //public WebElement unsuccessfulText;

    @FindAll(@FindBy(css = "div[class='validation-summary-errors']"))
    public List<WebElement> unsuccessfulText;

    @FindBy(id = "termsofservice")
    public WebElement termCondRadioButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement country;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    public WebElement state;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    public  WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement zipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phoneNumber;

    @FindBy(css = "input[value='Continue']")
    public WebElement continueButton;

    @FindBy(id = "billing-address-select")
    public WebElement billingAddress;

    @FindBy(id = "checkout-step-billing")
    public WebElement billingAddressFrame;

    @FindBy(css = "#billing-buttons-container > input")
    public WebElement continueBilling;

    @FindBy(css = "#shipping-buttons-container > input")
    public WebElement shippingAddressContinueButton;

    @FindBy(id = "shippingoption_0")
    public WebElement groundRadioButton;

    @FindBy(css = "#shipping-method-buttons-container > input")
    public WebElement shippingMethodContinueButton;

    @FindBy(id = "paymentmethod_3")
    public WebElement purchaseOrder;

    @FindBy(css = "#payment-method-buttons-container > input")
    public WebElement paymentMethodContinueButton;

    @FindBy(xpath = "//p[text()='You will pay by COD']")
    public WebElement paymentInfoText;

    @FindBy(css = "#payment-info-buttons-container > input")
    public WebElement paymentInfoContinueButton;

    @FindBy(css = "div[class='order-summary-content']")
    public WebElement orderSummary;

    @FindBy(css = "#confirm-order-buttons-container > input")
    public WebElement confirmButton;

    @FindBy(xpath = "//strong[text()= 'Your order has been successfully processed!']")
    public WebElement orderConfirmationText;





























}
