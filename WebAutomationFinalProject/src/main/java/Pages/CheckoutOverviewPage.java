package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By ItemTotalText = By.className("summary_subtotal_label");
    By FinishBtn = By.id("finish");

    //Actions

    public double getItemTotalValue() {
        // Example: Item total: $45.98
        String totalText = driver.findElement(ItemTotalText).getText();
        String totalNumber = totalText.replace("Item total: $", "");

        return Double.parseDouble(totalNumber);
    }
    public void clickOnFinishButton() {
        driver.findElement(FinishBtn).click();
    }

}
