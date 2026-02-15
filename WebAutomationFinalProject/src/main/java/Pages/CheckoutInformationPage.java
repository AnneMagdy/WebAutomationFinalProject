package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
    WebDriver driver;

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By FirstName = By.name("firstName");
    By LastName = By.id("last-name");
    By PostalCode = By.name("postalCode");
    By ContinueBtn = By.id("continue");

    //Actions
    public void enterFirstName() {
        driver.findElement(FirstName).sendKeys("Ann");
    }
    public void enterLastName() {
        driver.findElement(LastName).sendKeys("Habib");
    }
    public void enterPostalCode() {
        driver.findElement(PostalCode).sendKeys("123456");
    }
    public void clickOnContinueButton() {
        driver.findElement(ContinueBtn).click();
    }

}
