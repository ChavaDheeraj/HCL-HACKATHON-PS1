package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private final By productsBtn      = By.xpath("//a[@href='/products']");
    private final By allProducts      = By.className("product-image-wrapper");
    private final By searchBox        = By.id("search_product");
    private final By searchBtn        = By.id("submit_search");
    private final By addToCartBtn     = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    private final By continueShopBtn  = By.xpath("//button[text()='Continue Shopping']");
    private final By viewCartBtn      = By.xpath("//u[text()='View Cart']");
    private final By firstProductName = By.xpath("(//div[@class='productinfo text-center']/p)[1]");
    private final By firstProductPrice = By.xpath("(//div[@class='productinfo text-center']/h2)[1]");

    public void open() {
        navigateTo("products");
    }

    public void clickProducts() {
        click(productsBtn);
    }

    public int getProductsCount() {
        List<WebElement> products = driver.findElements(allProducts);
        return products.size();
    }

    public boolean areSearchResultsDisplayed() {
        return driver.findElements(allProducts).size() > 0;
    }

    public void searchProduct(String productName) {
        type(searchBox, productName);
        click(searchBtn);
    }

    public void addFirstProductToCart() {
        jsClick(addToCartBtn);
    }

    public void clickContinueShopping() {
        click(continueShopBtn);
    }

    public void clickViewCart() {
        jsClick(viewCartBtn);
    }

    public String getFirstProductName() {
        return getText(firstProductName);
    }

    public String getFirstProductPrice() {
        return getText(firstProductPrice);
    }
}
