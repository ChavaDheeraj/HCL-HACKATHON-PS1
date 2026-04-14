package com.srm.tests;

import com.srm.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "signupData")
    public Object[][] getSignupData() {
        return ExcelUtils.getSignupData();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return ExcelUtils.getLoginData();
    }
}
