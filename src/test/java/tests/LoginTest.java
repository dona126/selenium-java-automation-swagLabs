package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void testSearchFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.toLogin();
        System.out.println("LoginTest executed!");
    }
}

