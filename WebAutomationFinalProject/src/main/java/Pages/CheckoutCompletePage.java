package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    WebDriver driver;
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By confirmationMessage = By.className("complete-header");

    //Actions
    public String getConfirmationMessage() {
       return driver.findElement(confirmationMessage).getText();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
