package com.srm.base;

import com.srm.driver.DriverFactory;
import com.srm.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
        switchToMainTab();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    private void switchToMainTab() {
        String mainTab = DriverFactory.getDriver().getWindowHandles().iterator().next();
        DriverFactory.getDriver().switchTo().window(mainTab);
    }
}
