package StepDef;

import Pages.LoginPage;
import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginLockedOutUserStepDef {
    LoginPage loginPage;
    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(Hook.driver);
    }
    @When("user enter with locked_out_user and valid password")
    public void user_enter_with_locked_out_user_and_valid_password() {
        loginPage.LoginWithLockedOutUser();
    }
    @Then("An error message is displayed")
    public void an_error_message_is_displayed() throws InterruptedException {
        String expected_error_Message = "Epic sadface: Sorry, this user has been locked out.";
        String actual_error_Message = Hook.driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]")).getText();
        Assert.assertTrue(actual_error_Message.contains(expected_error_Message));
        Thread.sleep(2000);
    }

}
