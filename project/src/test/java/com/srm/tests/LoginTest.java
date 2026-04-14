package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class,
          description = "Verify login with data from Excel")
    public void testLogin(String email, String password, boolean shouldSucceed) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(email, password);
        if (shouldSucceed) {
            Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in for valid credentials: " + email);
        } else {
            Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Error message should be shown for invalid credentials: " + email);
        }
    }

    @Test(description = "Verify logout redirects to login page")
    public void testLogout() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in first");
        loginPage.clickLogout();
        Assert.assertTrue(loginPage.isLoginLinkVisible(),
                "Login/Signup link should be visible after logout");
    }
}
