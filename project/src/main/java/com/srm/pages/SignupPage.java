package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {

    private final By nameField       = By.name("name");
    private final By emailField      = By.xpath("//input[@data-qa='signup-email']");
    private final By signupBtn       = By.xpath("//button[@data-qa='signup-button']");

    private final By titleMrs        = By.id("id_gender2");
    private final By password        = By.id("password");
    private final By days            = By.id("days");
    private final By months          = By.id("months");
    private final By years           = By.id("years");

    private final By firstName       = By.id("first_name");
    private final By lastName        = By.id("last_name");
    private final By companyField    = By.id("company");
    private final By address         = By.id("address1");
    private final By state           = By.id("state");
    private final By city            = By.id("city");
    private final By zipcode         = By.id("zipcode");
    private final By mobile          = By.id("mobile_number");

    private final By createAccountBtn  = By.xpath("//button[@data-qa='create-account']");
    private final By continueBtn       = By.xpath("//a[@data-qa='continue-button']");
    private final By accountCreatedMsg = By.xpath("//b[text()='Account Created!']");

    public void enterSignupNameEmail(String name, String email) {
        type(nameField, name);
        type(emailField, email);
        click(signupBtn);
    }

    public void fillAccountInfo(String passwordValue, String day, String month, String year) {
        click(titleMrs);
        type(password, passwordValue);
        new Select(driver.findElement(days)).selectByValue(day);
        new Select(driver.findElement(months)).selectByValue(month);
        new Select(driver.findElement(years)).selectByValue(year);
    }

    public void fillAddressInfo(String first, String last, String company,
                                String addr, String cityVal,
                                String stateVal, String zip, String mobileVal) {
        type(firstName, first);
        type(lastName, last);
        type(companyField, company);
        type(address, addr);
        type(city, cityVal);
        type(state, stateVal);
        type(zipcode, zip);
        type(mobile, mobileVal);
    }

    public void clickCreateAccount() {
        click(createAccountBtn);
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public boolean isAccountCreated() {
        return isDisplayed(accountCreatedMsg);
    }
}
