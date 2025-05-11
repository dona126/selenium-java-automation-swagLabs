package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.WaitUtils;

import java.time.Duration;
import java.util.Collection;

public class LoginPage {
    private WebDriver driver;

    // Locators
    // NOTE IT!
    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.linkText("Epic sadface: Username and password do not match any user in this service");


    // NOTE IT!
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // NOTE IT!
    public void toLogin(String usernameInput, String passwordInput) {
        WebElement userNameE = driver.findElement(userName);
        WebElement passwordE = driver.findElement(password);
        WebElement loginButtonE = driver.findElement(loginButton);
        userNameE.clear();
        passwordE.clear();
        userNameE.sendKeys(usernameInput);
        passwordE.sendKeys(passwordInput);
        loginButtonE.click();

        WaitUtils waitUtils = new WaitUtils();
        waitUtils.sleep(5);

    }

    public boolean isErrorMessageVisible() {
        try {
            WebElement errorMessageE = driver.findElement(errorMessage);
            return errorMessageE.isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // If error message is not found, consider it as no error
        }
    }

    public String getErrorText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']"))
            );
            return errorElement.getText();
        } catch (TimeoutException e) {
            return "Error message not found.";
        }
    }
}
