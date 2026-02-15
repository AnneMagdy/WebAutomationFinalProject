package StepDef;

import Pages.*;
import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProceedToCheckoutStepDef {
    ProductsPage productsPage;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;
    double cartTotal;
    @Given("user is logged in and has products in the cart")
    public void user_is_logged_in_and_has_products_in_the_cart() {
        productsPage = new ProductsPage(Hook.driver);
        loginPage = new LoginPage(Hook.driver);
        productsPage = loginPage.LoginWithValidCredentials();
        productsPage.clickOnFirstAddToCart();
        productsPage.clickOnSecondAddToCart();
        productsPage.clickOnShoppingCart();

    }
    @When("user clicks Checkout button")
    public void user_clicks_checkout_button() throws InterruptedException {
        cartPage = new CartPage(Hook.driver);
        checkoutInformationPage = new CheckoutInformationPage(Hook.driver);
        Thread.sleep(3000);
        cartPage.clickOnCheckoutButton();
        checkoutInformationPage.enterFirstName();
        checkoutInformationPage.enterLastName();
        checkoutInformationPage.enterPostalCode();
        checkoutInformationPage.clickOnContinueButton();

    }
    @Then("total price should match the previous total on the cart page")
    public void total_price_should_match_the_previous_total_on_the_cart_page() throws InterruptedException {
        checkoutOverviewPage = new CheckoutOverviewPage(Hook.driver);
        checkoutCompletePage = new CheckoutCompletePage(Hook.driver);

        cartTotal = cartPage.getCartTotalPrice();
        System.out.println("Total products on page Cart = " + cartTotal);

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
}
