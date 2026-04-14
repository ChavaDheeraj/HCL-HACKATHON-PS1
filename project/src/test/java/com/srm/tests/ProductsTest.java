package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test(description = "Verify products page loads with products listed")
    public void productsPageTest() {
        ProductsPage products = new ProductsPage();
        products.open();
        Assert.assertTrue(products.getProductsCount() > 0,
                "Products list should not be empty");
    }

    @Test(description = "Verify search returns results for a valid keyword")
    public void testProductSearch() {
        ProductsPage products = new ProductsPage();
        products.open();
        products.searchProduct("Tshirt");
        Assert.assertTrue(products.areSearchResultsDisplayed(),
                "Search results should appear for 'Tshirt'");
    }

    @Test(description = "Verify product name and price are shown on products page")
    public void testProductDetails() {
        ProductsPage products = new ProductsPage();
        products.open();
        String name  = products.getFirstProductName();
        String price = products.getFirstProductPrice();
        Assert.assertFalse(name.isEmpty(),  "Product name should not be empty");
        Assert.assertFalse(price.isEmpty(), "Product price should not be empty");
    }
}
