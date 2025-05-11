package pages;
import org.openqa.selenium.*;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    // Locator for product tile
    private By productTile = By.cssSelector(".inventory_item_name");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }



    public boolean isProductTitleVisible() {
        try{
            WebElement productTileE = driver.findElement(productTile);
            return productTileE.isDisplayed();
        }
        catch (Exception e) {
            return false;  // If element not found or other error occurs, return false
        }
    }
}
