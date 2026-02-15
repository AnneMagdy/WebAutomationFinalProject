package Testcases;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import baseClass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveItemTest extends BaseClass {
    ProductsPage productsPage;
    LoginPage loginPage;
    CartPage cartPage;

    @Test
    public void RemoveItemFromCart() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);

        productsPage = loginPage.LoginWithValidCredentials();
        productsPage.clickOnFirstAddToCart();
        Thread.sleep(5000);
        productsPage.clickOnShoppingCart();
        Thread.sleep(5000);
        cartPage.clickOnRemoveButton();

        String expectedMessage = "Cart is not empty after removing product!";
        boolean actualMessage = cartPage.isCartEmpty();
        Assert.assertTrue(actualMessage,"Cart is not empty after removing product!");
        Thread.sleep(3000);

    }
}
