package StepDef;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddFirstProductStepDef {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    @Given("user is on the products page")
    public void user_is_on_the_products_page() {
        loginPage = new LoginPage(Hook.driver);
        productsPage = new ProductsPage(Hook.driver);
        productsPage = loginPage.LoginWithValidCredentials();
    }
    @When("user adds to cart for Sauce Labs Backpack")
    public void user_adds_to_cart_for_sauce_labs_backpack() {
        productsPage.clickOnFirstAddToCart();
        productsPage.clickOnShoppingCart();
    }
    @Then("Product Sauce Labs Backpack appears in the cart")
    public void product_sauce_labs_backpack_appears_in_the_cart() {
        cartPage = new CartPage(Hook.driver);
        String expectedName = "Sauce Labs Backpack";
        String actualName = Hook.driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();
        Assert.assertTrue(actualName.contains(expectedName));

        String expectedPrice = "$29.99";
        String actualPrice = Hook.driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).getText();
        Assert.assertTrue(actualPrice.contains(expectedPrice));
    }
}
