package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By firstAddToCartBtn = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    By shoppingCartLinkLocator = By.className("shopping_cart_link");
    By secondAddToCartBtn = By.xpath("(//button[contains(text(),'Add to cart')])[2]");
    By menuButton = By.id("react-burger-menu-btn");
    By logoutBtn = By.id("logout_sidebar_link");

    // Actions
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public void clickOnFirstAddToCart() {
        driver.findElement(firstAddToCartBtn).click();
    }
    public CartPage clickOnShoppingCart() {
        driver.findElement(shoppingCartLinkLocator).click();
        return new CartPage(driver);
    }
    public void clickOnSecondAddToCart() {
        driver.findElement(secondAddToCartBtn).click();
    }
    public void clickOnMenuButton() {
        driver.findElement(menuButton).click();
    }
    public void selectLogout() {
        driver.findElement(logoutBtn).click();
    }

}

