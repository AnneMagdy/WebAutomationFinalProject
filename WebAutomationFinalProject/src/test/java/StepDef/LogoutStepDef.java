package StepDef;

import Pages.LoginPage;
import Pages.ProductsPage;
import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.Ha;
import org.testng.Assert;

public class LogoutStepDef {
    ProductsPage productsPage;
    LoginPage loginPage;
    @Given("user logged in")
    public void user_logged_in() {
        productsPage = new ProductsPage(Hook.driver);
        loginPage = new LoginPage(Hook.driver);
        productsPage = loginPage.LoginWithValidCredentials();

    }
    @When("user clicks on the Menu button and selects Logout")
    public void user_clicks_on_the_menu_button_and_selects_logout() throws InterruptedException {
        productsPage.clickOnMenuButton();
        Thread.sleep(3000);
        productsPage.selectLogout();
    }
    @Then("user should be redirected to Login page")
    public void user_should_be_redirected_to_login_page() {
        Assert.assertTrue(loginPage.getCurrentUrl().contains("saucedemo.com"));

        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

}
