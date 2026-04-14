package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By loginSignupBtn  = By.linkText("Signup / Login");
    private final By emailField      = By.cssSelector("[data-qa='login-email']");
    private final By passwordField   = By.cssSelector("[data-qa='login-password']");
    private final By loginBtn        = By.xpath("//button[@data-qa='login-button']");
    private final By loggedInText    = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By logoutBtn       = By.linkText("Logout");
    private final By loginErrorMsg   = By.xpath("//p[contains(text(),'Your email or password is incorrect')]");
    private final By loginSignupLink = By.xpath("//a[contains(text(),'Signup / Login')]");

    public void open() {
        navigateTo("login");
    }

    public void clickLoginSignup() {
        click(loginSignupBtn);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginBtn);
    }

    public void login(String email, String password) {
        open();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isLoggedIn() {
        return isDisplayed(loggedInText);
    }

    public void clickLogout() {
        click(logoutBtn);
    }

    public boolean isLoginErrorDisplayed() {
        return isDisplayed(loginErrorMsg);
    }

    public String getLoginErrorMessage() {
        return getText(loginErrorMsg);
    }

    public boolean isLoginLinkVisible() {
        return isDisplayed(loginSignupLink);
    }
}
