package Testcases;

import Pages.LoginPage;
import Pages.ProductsPage;
import baseClass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseClass {
    ProductsPage productsPage;
    LoginPage loginPage;
    @Test
    public void Logout() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);

        productsPage = loginPage.LoginWithValidCredentials();
        productsPage.clickOnMenuButton();
        Thread.sleep(3000);
        productsPage.selectLogout();
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.getCurrentUrl().contains("saucedemo.com"));

        Assert.assertTrue(loginPage.isLoginButtonDisplayed());

    }

}
