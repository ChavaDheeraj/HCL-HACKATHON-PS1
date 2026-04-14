package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class SignupTest extends BaseTest {

    @Test(dataProvider = "signupData", dataProviderClass = DataProviders.class,
          description = "Verify registration with data from Excel")
    public void signupTest(String name, String lastname, String title,
                           String day, String month, String year,
                           String email, String password,
                           String company, String address,
                           String city, String state,
                           String zip, String mobile) {

        LoginPage loginPage = new LoginPage();
        SignupPage signupPage = new SignupPage();

        // Generate unique email to avoid duplicate account errors
        String uniqueEmail = "test_" + UUID.randomUUID().toString().substring(0, 8) + "@test.com";

        loginPage.open();
        loginPage.clickLoginSignup();

        signupPage.enterSignupNameEmail(name, uniqueEmail);
        signupPage.fillAccountInfo(password, day, month, year);
        signupPage.fillAddressInfo(name, lastname, company, address, city, state, zip, mobile);
        signupPage.clickCreateAccount();

        Assert.assertTrue(signupPage.isAccountCreated(),
                "Account should be created successfully for: " + uniqueEmail);
    }
}
