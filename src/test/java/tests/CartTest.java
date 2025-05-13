package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

//Scenario count: 4
public class CartTest extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    //For Login
    @BeforeMethod
    public void loginForCartTest() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage= new CartPage(driver);
        loginPage.toLogin("standard_user", "secret_sauce");
    }

    //Scenario 1: Add and verify products in cart
    @Test
    public void testAddAndVerifyProductsInCart() {
        productsPage.addProductToCart("Sauce Labs Onesie");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");

        productsPage.goToCart();

        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Onesie"), "Expected, product Sauce Labs Onesie in cart");
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Bolt T-Shirt"), "Expected, product T-shirt in cart.");
    }

    //Scenario 2: Remove product from cart
    @Test
    public void testRemoveProductFromCart() {
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.goToCart();
        cartPage.removeProductFromCart("Sauce Labs Backpack");

        Assert.assertFalse(cartPage.isProductInCart("Sauce Labs Backpack"), "Expected, Product should be removed.");
    }

    //Scenario 3: Verify total price
    @Test
    public void testVerifyTotalPrice() {
        productsPage.addProductToCart("Sauce Labs Backpack"); // $29.99
        productsPage.addProductToCart("Sauce Labs Bike Light"); // $9.99

        productsPage.goToCart();

        double expectedTotal = 29.99 + 9.99;
        double actualTotal = cartPage.getCartTotal();

        Assert.assertEquals(actualTotal, expectedTotal, 0.01, "Expected, correct total price");
    }


    //Scenario 4: Cart persistency after navigating back
    @Test
    public void testCartPersistencyAfterNavigatingBack() {
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.goToCart();
        cartPage.continueShopping();

        productsPage.goToCart();

        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "Expected, Cart persistency after navigating back");
    }

}
