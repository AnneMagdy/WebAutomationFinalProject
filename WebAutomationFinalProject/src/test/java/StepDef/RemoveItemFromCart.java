package StepDef;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RemoveItemFromCart {
    ProductsPage productsPage;
    LoginPage loginPage;
    CartPage cartPage;
    @Given("user is on products page")
    public void user_is_on_products_page() {
        productsPage = new ProductsPage(Hook.driver);
        loginPage = new LoginPage(Hook.driver);
        cartPage = new CartPage(Hook.driver);
        productsPage = loginPage.LoginWithValidCredentials();
    }
    @When("user adds a product to the cart and clicks Remove button")
    public void user_adds_a_product_to_the_cart_and_clicks_remove_button() throws InterruptedException {
        productsPage.clickOnFirstAddToCart();
        Thread.sleep(3000);
        productsPage.clickOnShoppingCart();
        Thread.sleep(3000);
        cartPage.clickOnRemoveButton();
    }
    @Then("product should be removed from the cart")
    public void product_should_be_removed_from_the_cart() throws InterruptedException {
        String expectedMessage = "Cart is not empty after removing product!";
        boolean actualMessage = cartPage.isCartEmpty();
        Assert.assertTrue(actualMessage,"Cart is not empty after removing product!");
        Thread.sleep(3000);
    }

}
