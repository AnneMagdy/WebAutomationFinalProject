package StepDef;

import Pages.LoginPage;
import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginInvalidStepDef {
    LoginPage loginPage;
   @Given("user on the login page")
   public void user_on_the_login_page() {
       loginPage = new LoginPage(Hook.driver);
   }
    @When("user enter with valid username and invalid password")
    public void user_enter_with_valid_username_and_invalid_password() {
        loginPage.LoginWithInvalidCredentials();
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() throws InterruptedException {
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = Hook.driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        Thread.sleep(2000);
    }

}
