package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.driver.DriverFactory;
import com.srm.pages.CartPage;
import com.srm.pages.CheckoutPage;
import com.srm.pages.LoginPage;
import com.srm.pages.ProductsPage;
import com.srm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutFlowTest extends BaseTest {

    @Test(description = "Verify complete checkout flow from cart to order confirmation")
    public void fullCheckoutFlow() {
        LoginPage loginPage   = new LoginPage();
        ProductsPage products = new ProductsPage();
        CartPage cart         = new CartPage();
        CheckoutPage checkout = new CheckoutPage();

        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        products.open();
        products.addFirstProductToCart();
        products.clickViewCart();

        cart.clickProceedToCheckout();
        checkout.enterComment("Please deliver fast");
        checkout.clickPlaceOrder();

        checkout.enterPaymentDetails("Test User", "4111111111111111", "123", "12", "2028");
        checkout.clickPayConfirm();

        Assert.assertTrue(checkout.isOrderSuccessful(),
                "Order confirmation message should be displayed");
    }

    @Test(description = "Verify checkout without login redirects to login page")
    public void testCheckoutWithoutLogin() {
        ProductsPage products = new ProductsPage();
        CartPage cart         = new CartPage();

        products.open();
        products.addFirstProductToCart();
        products.clickViewCart();

        cart.clickProceedToCheckout();
        cart.clickRegisterLogin();

        Assert.assertTrue(
                DriverFactory.getDriver().getCurrentUrl().contains("login"),
                "User should be redirected to the login page");
    }
}
