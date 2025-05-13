package pages;
import org.openqa.selenium.*;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    // Locators
    private By productTile = By.cssSelector(".inventory_item_name");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    // Try catch added for assert methods.....
    public boolean isProductTitleVisible() {
        try{
            WebElement productTileE = driver.findElement(productTile);
            return productTileE.isDisplayed();
        }
        catch (Exception e) {
            return false;  // If element not found or other error occurs, return false
        }
    }

    public void addProductToCart(String productName) {
        String prodID = productName.toLowerCase().replaceAll(" ", "-");

        // Build locator dynamically
        By addToCartButton = By.id("add-to-cart-" + prodID);
        driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
