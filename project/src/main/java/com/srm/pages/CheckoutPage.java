package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By commentBox      = By.name("message");
    private final By placeOrderBtn   = By.xpath("//a[contains(text(),'Place Order')]");
    private final By nameOnCard      = By.name("name_on_card");
    private final By cardNumber      = By.name("card_number");
    private final By cvc             = By.name("cvc");
    private final By expiryMonth     = By.name("expiry_month");
    private final By expiryYear      = By.name("expiry_year");
    private final By payConfirmBtn   = By.id("submit");
    private final By orderSuccessMsg = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed')]");

    public void enterComment(String comment) {
        type(commentBox, comment);
    }

    public void clickPlaceOrder() {
        click(placeOrderBtn);
    }

    public void enterPaymentDetails(String name, String number, String cvcCode,
                                    String month, String year) {
        type(nameOnCard, name);
        type(cardNumber, number);
        type(cvc, cvcCode);
        type(expiryMonth, month);
        type(expiryYear, year);
    }

    public void clickPayConfirm() {
        click(payConfirmBtn);
    }

    public boolean isOrderSuccessful() {
        return isDisplayed(orderSuccessMsg);
    }
}
