package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormValidationTest extends BaseTest {

    @Test(description = "Verify error is shown when submitting empty login fields")
    public void testLoginWithEmptyFields() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "Error message should appear for empty login fields");
    }

    @Test(description = "Verify error is shown for invalid email format")
    public void testLoginWithInvalidEmailFormat() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterEmail("notanemail");
        loginPage.enterPassword("anypassword");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "Error message should appear for invalid email format");
    }

    @Test(description = "Verify error message text for wrong credentials")
    public void testLoginErrorMessage() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("wrong@example.com", "wrongpassword");
        String error = loginPage.getLoginErrorMessage();
        Assert.assertTrue(error.toLowerCase().contains("incorrect"),
                "Error message should contain 'incorrect'");
    }
}
