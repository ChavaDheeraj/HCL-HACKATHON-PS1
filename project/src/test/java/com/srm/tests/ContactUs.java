package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUs extends BaseTest {

    @Test(description = "Verify contact form submission shows success message")
    public void contactFormTest() {
        ContactUsPage contact = new ContactUsPage();

        contact.clickContactUs();
        contact.enterName("Test User");
        contact.enterEmail("testuser@example.com");
        contact.enterSubject("Test Subject");
        contact.enterMessage("This is an automated test message");

        contact.clickSubmit();
        contact.acceptAlert();
        contact.clickHome();

        Assert.assertTrue(contact.isSuccessDisplayed(),
                "Success message should be displayed after form submission");
    }
}
