package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By Product_Name_Locator = By.className("inventory_item_name");
    By Product_Price_Locator = By.className("inventory_item_price");
    By Continue_Shopping_Btn_Locator = By.id("continue-shopping");
    By Checkout_Btn_Locator = By.id("checkout");
    By allPrices = By.className("inventory_item_price");
    By cartItemName = By.className("inventory_item_name");
    By cartItemPrice = By.className("inventory_item_price");
    By removeButton = By.id("remove-sauce-labs-backpack");

    //Actions
    public void getProductName() {
        driver.findElement(Product_Name_Locator).getText();
    }
    public void getProductPrice() {
        driver.findElement(Product_Price_Locator).getText();
    }
    public void clickOnContinueShopping() {
        driver.findElement(Continue_Shopping_Btn_Locator).click();
    }
    public String getProductPrice(String productName) {

        WebElement priceElement = driver.findElement(
                By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']")
        );

        return priceElement.getText();
    }
    public String getProductName(String productName) {
        By productTitle = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']");
        return driver.findElement(productTitle).getText();
    }
    public double convertPriceToDouble(String priceText) {
        return Double.parseDouble(priceText.replace("$", ""));
    }
    public void clickOnCheckoutButton() {
        driver.findElement(Checkout_Btn_Locator).click();
    }
    public double getCartTotalPrice() {

        double total = 0;

        List<WebElement> pricesList = driver.findElements(allPrices);

        for (WebElement price : pricesList) {
            String priceText = price.getText();   // $29.99
            total += Double.parseDouble(priceText.replace("$", ""));
        }

        return total;
    }

    public String getproductName() {
      return driver.findElement(cartItemName).getText();
    }
    public String getproductPrice() {
       return driver.findElement(cartItemPrice).getText();
    }
    public void clickOnRemoveButton() {
        driver.findElement(removeButton).click();
    }
    public boolean isCartEmpty() {
        return driver.findElements(cartItemName).size() == 0;
    }

}
