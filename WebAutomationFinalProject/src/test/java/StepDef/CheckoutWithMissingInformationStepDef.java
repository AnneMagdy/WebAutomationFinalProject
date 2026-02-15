package StepDef;

import Pages.CartPage;
import Pages.CheckoutInformationPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutWithMissingInformationStepDef {
    ProductsPage productsPage;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    @Given("user is on checkout page")
    public void user_is_on_checkout_page() throws InterruptedException {
        productsPage = new ProductsPage(Hook.driver);
        loginPage = new LoginPage(Hook.driver);
        cartPage = new CartPage(Hook.driver);
        productsPage = loginPage.LoginWithValidCredentials();
        productsPage.clickOnShoppingCart();
        Thread.sleep(2000);
        cartPage.clickOnCheckoutButton();
    }
    @When("user leaves the First Name field blank and clicks Continue button")
    public void user_leaves_the_first_name_field_blank_and_clicks_continue_button() throws InterruptedException {
        checkoutInformationPage = new CheckoutInformationPage(Hook.driver);
        checkoutInformationPage.clickOnContinueButton();
        Thread.sleep(2000);
    }
    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String string) throws InterruptedException {
        String expectedErrorMessage = "Error: First Name is required";
        String actualErrorMessage = Hook.driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        Thread.sleep(2000);
    }

}
