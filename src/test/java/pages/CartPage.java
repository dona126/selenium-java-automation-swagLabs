package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isProductInCart(String productName) {
        try {
            //Dynamic xpath
            String xpath = "//div[@class='cart_item']//div[@class='inventory_item_name' and text()='" + productName + "']";
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void removeProductFromCart(String productName) {
        String xpath = "//div[@class='cart_item']//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//button[text()='Remove']";
        driver.findElement(By.xpath(xpath)).click();

    }

    public double getCartTotal() {

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

        double total = 0.0;

        for (WebElement priceElement : prices) {
            String priceText = priceElement.getText();
            priceText = priceText.replace("$", "");
            total += Double.parseDouble(priceText);// Convert to double and add to total
        }

        return total;
    }

    public void continueShopping() {
        WebElement continueButton = driver.findElement(By.id("continue-shopping"));
        continueButton.click();
    }
}
