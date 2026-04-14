package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.CartPage;
import com.srm.pages.LoginPage;
import com.srm.pages.ProductsPage;
import com.srm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Verify product is added to cart with correct name")
    public void testAddToCart() {
        LoginPage loginPage   = new LoginPage();
        ProductsPage products = new ProductsPage();
        CartPage cart         = new CartPage();

        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        products.open();
        String expectedName = products.getFirstProductName();
        products.addFirstProductToCart();
        products.clickViewCart();

        Assert.assertTrue(cart.isProductPresent(), "Product should appear in cart");
        Assert.assertEquals(cart.getFirstProductName(), expectedName,
                "Product name in cart should match the product added");
    }

    @Test(description = "Verify product is removed from cart")
    public void testRemoveFromCart() {
        LoginPage loginPage   = new LoginPage();
        ProductsPage products = new ProductsPage();
        CartPage cart         = new CartPage();

        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        products.open();
        products.addFirstProductToCart();
        products.clickViewCart();

        cart.removeFirstItem(); // uses WebDriverWait internally — no Thread.sleep
        Assert.assertTrue(cart.isCartEmpty(), "Cart should be empty after removing the item");
    }

    @Test(description = "Verify cart count updates when product is added")
    public void testCartCountUpdates() {
        LoginPage loginPage   = new LoginPage();
        ProductsPage products = new ProductsPage();
        CartPage cart         = new CartPage();

        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        products.open();
        products.addFirstProductToCart();
        products.clickViewCart();

        Assert.assertEquals(cart.getCartItemCount(), 1, "Cart should contain exactly 1 item");
    }
}
