package StepDef;

import Pages.LoginPage;
import Pages.ProductsPage;
import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginValidStepDef {
    LoginPage loginPage;
    ProductsPage productsPage;
    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage = new LoginPage(Hook.driver);
        productsPage = new ProductsPage(Hook.driver);
    }

    @When("user enter with valid username and valid password")
    public void user_enter_with_valid_username_and_valid_password() {
        productsPage = loginPage.LoginWithValidCredentials();
    }
    @Then("user should be directed to Products page")
    public void user_should_be_directed_to_products_page() throws InterruptedException {
        Assert.assertTrue(productsPage.getCurrentUrl().contains("inventory.html"));

        String expectedMessage = "Products";
        String actualMessage = Hook.driver.findElement(By.xpath("//span[@class=\"title\"]")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        Thread.sleep(2000);
    }

}
