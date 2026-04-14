package com.srm.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.srm.utils.ExtentReportManager;
import com.srm.utils.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentReportManager.getInstance()
                .createTest(result.getMethod().getMethodName(),
                        result.getMethod().getDescription());
        ExtentReportManager.setTest(test);
        ExtentReportManager.getTest().log(Status.INFO, "Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().log(Status.FAIL,
                "Test Failed: " + result.getThrowable());
        String screenshotPath = ScreenshotUtil.takeScreenshot(
                result.getMethod().getMethodName() + "_FAIL");
        if (screenshotPath != null) {
            try {
                ExtentReportManager.getTest()
                        .addScreenCaptureFromPath("../../" + screenshotPath, "Failure Screenshot");
            } catch (Exception e) {
                System.out.println("Could not attach screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().log(Status.SKIP,
                "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }
}
