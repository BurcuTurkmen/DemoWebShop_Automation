package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements {

    public HomePageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "Log in")
    public WebElement loginButton;

    //@FindAll(@FindBy(css = "div[value='Add to cart']"))
    //public List<WebElement> productList;

    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-3 > div > div > div.product-grid.home-page-product-grid > div:nth-child(3) > div > div.details > div.add-info > div.buttons > input")
    public WebElement addToCart;

    @FindBy(xpath = "//span[text()='Shopping cart']")
    public WebElement shoppingCart;



}
