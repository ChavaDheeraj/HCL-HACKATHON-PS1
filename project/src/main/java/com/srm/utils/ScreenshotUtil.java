package com.srm.utils;

import com.srm.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String takeScreenshot(String testName) {
        try {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String path = "screenshot" + File.separator + testName + "_" + timestamp + ".png";
            Files.createDirectories(Paths.get("screenshot"));
            Files.write(Paths.get(path), screenshot);
            return path;
        } catch (IOException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
            return null;
        }
    }
}
