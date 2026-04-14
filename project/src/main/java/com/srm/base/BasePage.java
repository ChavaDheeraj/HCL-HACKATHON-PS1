package com.srm.base;

import com.srm.driver.DriverFactory;
import com.srm.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver,
                Duration.ofSeconds(Long.parseLong(ConfigReader.get("timeout"))));
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void handleAds() {
        try {
            By adIframe = By.xpath("//iframe[contains(@id,'aswift') or contains(@id,'ad_iframe')]");
            if (!driver.findElements(adIframe).isEmpty()) {
                driver.switchTo().frame(driver.findElement(adIframe));
                By dismissBtn = By.xpath("//div[@id='dismiss-button'] | //span[text()='Close']");
                if (!driver.findElements(dismissBtn).isEmpty()) {
                    driver.findElement(dismissBtn).click();
                }
                driver.switchTo().defaultContent();
            }
            ((JavascriptExecutor) driver).executeScript(
                "var ads = document.getElementsByTagName('ins');" +
                "for (var i = 0; i < ads.length; i++) { ads[i].style.display = 'none'; }"
            );
        } catch (Exception e) {
            driver.switchTo().defaultContent();
        }
    }

    protected void click(By locator) {
        handleAds();
        waitForClickable(locator).click();
    }

    protected void jsClick(By locator) {
        handleAds();
        WebElement el = waitForElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    protected void type(By locator, String text) {
        handleAds();
        WebElement el = waitForElement(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected String getText(By locator) {
        handleAds();
        return waitForElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        handleAds();
        try {
            return waitForElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void navigateTo(String path) {
        driver.get(ConfigReader.get("baseUrl") + path);
    }
}
