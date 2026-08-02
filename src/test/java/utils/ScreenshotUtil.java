package utils;

import main.java.org.example.automation.functionaltesting.theInternetherokuapp.Drivermanager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        try {

            File src = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            String destination =
                    System.getProperty("user.dir")
                            + "/target/screenshots/"
                            + testName + "_" + timestamp + ".png";

            File dest = new File(destination);

            FileUtils.copyFile(src, dest);

            return destination;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}