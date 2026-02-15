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

public class AddSecondProductStepDef {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    @Given("user on the products page")
    public void userOnTheProductsPage() {
        loginPage = new LoginPage(Hook.driver);
        productsPage = new ProductsPage(Hook.driver);
        productsPage = loginPage.LoginWithValidCredentials();
    }

    @When("user adds to cart for Sauce Labs Bolt T-Shirt")
    public void userAddsToCartForSauceLabsBoltTShirt() {
        cartPage = new CartPage(Hook.driver);
        productsPage.clickOnFirstAddToCart();
        productsPage.clickOnShoppingCart();
        cartPage.clickOnContinueShopping();
        productsPage.clickOnSecondAddToCart();
        productsPage.clickOnShoppingCart();
    }

    @Then("Product Sauce Labs Backpack and Sauce Labs Bolt T-Shirt appears in the cart")
    public void productSauceLabsBackpackAndSauceLabsBoltTShirtAppearsInTheCart() {
        String expectedName = "Sauce Labs Backpack";
        String actualName = Hook.driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();
        Assert.assertTrue(actualName.contains(expectedName));

        String expectedPrice = "$29.99";
        String actualPrice = Hook.driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).getText();
        Assert.assertTrue(actualPrice.contains(expectedPrice));

        String expected_Name = "Sauce Labs Bolt T-Shirt";
        String actual_Name = Hook.driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();
        Assert.assertTrue(actualName.contains(expectedName));

        String expected_Price = "$15.99";
        String actual_Price = Hook.driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).getText();
        Assert.assertTrue(actualPrice.contains(expectedPrice));
    }

}
