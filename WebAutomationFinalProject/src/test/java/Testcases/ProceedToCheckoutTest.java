package Testcases;

import Pages.*;
import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProceedToCheckoutTest extends BaseClass {
    ProductsPage productsPage;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @Test
    public void Checkout() throws InterruptedException {
     productsPage = new ProductsPage(driver);
     loginPage = new LoginPage(driver);
     cartPage = new CartPage(driver);
     checkoutInformationPage = new CheckoutInformationPage(driver);
     checkoutOverviewPage = new CheckoutOverviewPage(driver);
     checkoutCompletePage = new CheckoutCompletePage(driver);

     productsPage = loginPage.LoginWithValidCredentials();
     productsPage.clickOnFirstAddToCart();
     productsPage.clickOnSecondAddToCart();
     productsPage.clickOnShoppingCart();
     double cartTotal = cartPage.getCartTotalPrice();
     System.out.println("Total products on page Cart = " + cartTotal);
     Thread.sleep(3000);
     cartPage.clickOnCheckoutButton();
     Thread.sleep(3000);
     checkoutInformationPage.enterFirstName();
     Thread.sleep(2000);
     checkoutInformationPage.enterLastName();
     Thread.sleep(2000);
     checkoutInformationPage.enterPostalCode();
     Thread.sleep(2000);
     checkoutInformationPage.clickOnContinueButton();
     Thread.sleep(3000);

     double overviewTotal = checkoutOverviewPage.getItemTotalValue();
     System.out.println("Total on page Overview = " + overviewTotal);

     Assert.assertEquals(overviewTotal, cartTotal);

     checkoutOverviewPage.clickOnFinishButton();
     Thread.sleep(3000);

     String expectedMessage = "Thank you for your order!";
     String actualMessage = checkoutCompletePage.getConfirmationMessage();
     Assert.assertTrue(actualMessage.contains(expectedMessage));

     String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
     String actualUrl = checkoutCompletePage.getCurrentUrl();
     Assert.assertTrue(actualUrl.contains(expectedUrl));

    }

    @Test
    public void CheckoutWithMissingInformation() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);

        productsPage = loginPage.LoginWithValidCredentials();
        Thread.sleep(3000);
        productsPage.clickOnShoppingCart();
        Thread.sleep(3000);
        cartPage.clickOnCheckoutButton();
        Thread.sleep(3000);
        checkoutInformationPage.clickOnContinueButton();
        Thread.sleep(2000);

        String expectedErrorMessage = "Error: First Name is required";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        Thread.sleep(2000);
    }
}
