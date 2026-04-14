package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;

public class ContactUsPage extends BasePage {

    private final By contactUsBtn = By.linkText("Contact us");
    private final By nameField    = By.cssSelector("[data-qa='name']");
    private final By emailField   = By.cssSelector("[data-qa='email']");
    private final By subjectField = By.cssSelector("[data-qa='subject']");
    private final By messageField = By.id("message");
    private final By submitBtn    = By.cssSelector("[data-qa='submit-button']");
    private final By homeBtn      = By.cssSelector(".btn.btn-success");
    private final By successMsg   = By.xpath("//div[contains(@class,'alert-success')]");

    public void clickContactUs() {
        click(contactUsBtn);
    }

    public void enterName(String name) {
        type(nameField, name);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterSubject(String subject) {
        type(subjectField, subject);
    }

    public void enterMessage(String message) {
        type(messageField, message);
    }

    public void clickSubmit() {
        click(submitBtn);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void clickHome() {
        click(homeBtn);
    }

    public boolean isSuccessDisplayed() {
        return isDisplayed(successMsg);
    }
}
