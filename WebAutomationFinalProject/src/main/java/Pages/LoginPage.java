package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login-button");
    By productsLocator = By.xpath("//span[@class=\"title\"]");

    //Actions
    public void enterUsername() {
        driver.findElement(usernameLocator).sendKeys("standard_user");
    }
    public void enterPassword() {
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
    }
    public ProductsPage clickOnLoginButton() {
        driver.findElement(loginButtonLocator).click();
        return null;
    }

    public ProductsPage LoginWithValidCredentials() {
        driver.findElement(usernameLocator).sendKeys("standard_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(loginButtonLocator).click();
        return new ProductsPage(driver);
    }

    public ProductsPage getProductsPage() {
        driver.findElement(productsLocator).getText();
        return new ProductsPage(driver);
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButtonLocator).isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void LoginWithInvalidCredentials() {
        driver.findElement(usernameLocator).sendKeys("standard_user");
        driver.findElement(passwordLocator).sendKeys("incorrect_password");
        driver.findElement(loginButtonLocator).click();
    }

    public void LoginWithLockedOutUser() {
        driver.findElement(usernameLocator).sendKeys("locked_out_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(loginButtonLocator).click();
    }
}
