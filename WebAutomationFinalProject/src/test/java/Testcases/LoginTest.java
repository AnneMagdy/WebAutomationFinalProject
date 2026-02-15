package Testcases;

import Pages.LoginPage;
import Pages.ProductsPage;
import baseClass.BaseClass;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
     ProductsPage productsPage;
     LoginPage loginPage;
    @Test
    public void LoginWithValidCredentials() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = loginPage.LoginWithValidCredentials();
        Thread.sleep(3000);

        Assert.assertTrue(productsPage.getCurrentUrl().contains("inventory.html"));

        String expectedMessage = "Products";
        String actualMessage = driver.findElement(By.xpath("//span[@class=\"title\"]")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        Thread.sleep(3000);

    }

    @Test
    public void LoginWithInvalidCredentials() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.LoginWithInvalidCredentials();
        Thread.sleep(3000);

        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        Thread.sleep(3000);

    }

    @Test
    public void LoginWithLockedOutUser() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);

        loginPage.LoginWithLockedOutUser();
        Thread.sleep(3000);

        String expected_error_Message = "Epic sadface: Sorry, this user has been locked out.";
        String actual_error_Message = driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]")).getText();
        Assert.assertTrue(actual_error_Message.contains(expected_error_Message));
        Thread.sleep(3000);

    }
}
