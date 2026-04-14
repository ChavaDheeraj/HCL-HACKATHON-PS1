package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By cartMenu           = By.xpath("//a[@href='/view_cart']");
    private final By proceedCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private final By loginLink          = By.xpath("//u[text()='Register / Login']");
    private final By productRows        = By.xpath("//tr[contains(@id,'product')]");
    private final By deleteButtons      = By.className("cart_quantity_delete");
    private final By cartProductNames   = By.xpath("//td[@class='cart_description']//h4/a");

    public void open() {
        navigateTo("view_cart");
    }

    public void openCart() {
        click(cartMenu);
    }

    public void clickProceedToCheckout() {
        click(proceedCheckoutBtn);
    }

    public void clickRegisterLogin() {
        click(loginLink);
    }

    public boolean isProductPresent() {
        return isDisplayed(productRows);
    }

    public int getCartItemCount() {
        return driver.findElements(productRows).size();
    }

    public String getFirstProductName() {
        return getText(cartProductNames);
    }

    public void removeFirstItem() {
        List<WebElement> delBtns = driver.findElements(deleteButtons);
        if (!delBtns.isEmpty()) delBtns.get(0).click();
        waitForInvisibility(By.xpath("(//tr[contains(@id,'product')])[1]"));
    }

    public boolean isCartEmpty() {
        return driver.findElements(productRows).isEmpty();
    }
}
