package com.srm.utils;

/**
 * Wait utilities have been consolidated into BasePage.
 * BasePage.waitForElement(), waitForClickable(), and waitForInvisibility()
 * use WebDriverWait with ExpectedConditions for all timing needs.
 * Thread.sleep() is strictly prohibited per project requirements.
 */
public class WaitHelper {
    // All wait logic lives in com.srm.base.BasePage
}
