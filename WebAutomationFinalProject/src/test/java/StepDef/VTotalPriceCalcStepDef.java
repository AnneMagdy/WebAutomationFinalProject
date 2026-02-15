package StepDef;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VTotalPriceCalcStepDef {
    ProductsPage productsPage;
    LoginPage loginPage;
    CartPage cartPage;

    @Given("user is logged in")
    public void user_is_logged_in() {
        productsPage = new ProductsPage(Hook.driver);
        loginPage = new LoginPage(Hook.driver);
        productsPage = loginPage.LoginWithValidCredentials();
    }
    @When("user has two products in the cart")
    public void user_has_two_products_in_the_cart() {
        productsPage.clickOnFirstAddToCart();
        productsPage.clickOnSecondAddToCart();
        productsPage.clickOnShoppingCart();
    }
    @Then("record prices of both products from the cart")
    public void record_prices_of_both_products_from_the_cart() {
        cartPage = new CartPage(Hook.driver);

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
