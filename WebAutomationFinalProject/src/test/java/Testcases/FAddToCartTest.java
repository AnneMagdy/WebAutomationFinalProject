package Testcases;

import Pages.LoginPage;
import Pages.ProductsPage;
import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FAddToCartTest extends BaseClass {
    ProductsPage productsPage;
    LoginPage loginPage;

    @Test
    public void fAddToCart() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);

        productsPage = loginPage.LoginWithValidCredentials();
        productsPage.clickOnFirstAddToCart();
        Thread.sleep(5000);
        productsPage.clickOnShoppingCart();
        Thread.sleep(5000);

        String expectedName = "Sauce Labs Backpack";
        String actualName = driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();
        Assert.assertTrue(actualName.contains(expectedName));

        String expectedPrice = "$29.99";
        String actualPrice = driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).getText();
        Assert.assertTrue(actualPrice.contains(expectedPrice));
    }

}
