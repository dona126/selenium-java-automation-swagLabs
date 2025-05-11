package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {
    @Test
    public void testValidLogin()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.toLogin("standard_user", "secret_sauce");

        // Successful login goes to Products Page
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductTitleVisible(), "Login failed with valid credentials.");

    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.toLogin("invalid_user", "wrong_pass");

        Assert.assertTrue(loginPage.getErrorText().contains("Username and password do not match any user in this service"),  "Expected, error message for invalid credentials.");
    }

    @Test
    public void testEmptyUsernamePassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.toLogin("", "");

        Assert.assertTrue(loginPage.getErrorText().contains("Username is required"), "Expected,error message for empty credentials.");
    }

    @Test
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.toLogin("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorText().contains("locked out"), "Expected, locked out user error.");
    }
}

