package Testcases;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VTotalPriceCalcTest extends BaseClass {
    ProductsPage productsPage;
    LoginPage loginPage;
    CartPage cartPage;

    @Test
    public void TotalPriceCalc() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);

        productsPage = loginPage.LoginWithValidCredentials();
        productsPage.clickOnFirstAddToCart();
        Thread.sleep(3000);
        productsPage.clickOnSecondAddToCart();
        Thread.sleep(3000);
        productsPage.clickOnShoppingCart();
        Thread.sleep(3000);

        String backpackPriceText = cartPage.getProductPrice("Sauce Labs Backpack");
        String tshirtPriceText = cartPage.getProductPrice("Sauce Labs Bolt T-Shirt");

        double backpackPrice = cartPage.convertPriceToDouble(backpackPriceText);
        double tshirtPrice = cartPage.convertPriceToDouble(tshirtPriceText);

        System.out.println("BackpackPrice = " + backpackPrice);
        System.out.println("T-shirtPrice = " + tshirtPrice);

        double expectedTotal = backpackPrice + tshirtPrice;

        System.out.println("Total Amount = " + expectedTotal);


    }
}
