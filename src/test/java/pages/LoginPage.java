package pages;

import org.openqa.selenium.*;
import utils.WaitUtils;

public class LoginPage {
    private WebDriver driver;

    // Locators for username and password fields
    // NOTE IT!
    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");


    // NOTE IT!
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // NOTE IT!
    public void toLogin() {
        WebElement userNameE = driver.findElement(userName);
        WebElement passwordE = driver.findElement(password);
        WebElement loginButtonE = driver.findElement(loginButton);
        userNameE.clear();
        passwordE.clear();
        userNameE.sendKeys("standard_user");
        passwordE.sendKeys("secret_sauce");
        loginButtonE.click();

        WaitUtils waitUtils = new WaitUtils();
        waitUtils.sleep(5);

    }
}
