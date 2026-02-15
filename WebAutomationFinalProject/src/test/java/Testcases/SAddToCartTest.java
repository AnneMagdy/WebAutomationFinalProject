package Testcases;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SAddToCartTest extends BaseClass {
    ProductsPage productsPage;
    LoginPage loginPage;
    CartPage cartPage;

    @Test
    public void sAddToCart() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        
        productsPage = loginPage.LoginWithValidCredentials();
        productsPage.clickOnFirstAddToCart();
        Thread.sleep(5000);
        productsPage.clickOnShoppingCart();
        Thread.sleep(5000);
        cartPage.clickOnContinueShopping();
        Thread.sleep(5000);
        productsPage.clickOnSecondAddToCart();
        Thread.sleep(5000);
        productsPage.clickOnShoppingCart();
        Thread.sleep(5000);

        String expectedName = "Sauce Labs Backpack";
        String actualName = driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();
        Assert.assertTrue(actualName.contains(expectedName));

        String expectedPrice = "$29.99";
        String actualPrice = driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).getText();
        Assert.assertTrue(actualPrice.contains(expectedPrice));

        String expected_Name = "Sauce Labs Bolt T-Shirt";
        String actual_Name = driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();
        Assert.assertTrue(actualName.contains(expectedName));

        String expected_Price = "$15.99";
        String actual_Price = driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).getText();
        Assert.assertTrue(actualPrice.contains(expectedPrice));
    }

}


