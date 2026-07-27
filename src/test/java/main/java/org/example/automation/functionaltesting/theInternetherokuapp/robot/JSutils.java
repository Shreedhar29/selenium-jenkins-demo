package main.java.org.example.automation.functionaltesting.theInternetherokuapp.robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSutils {

    public static JavascriptExecutor js;

    public static void initJS(WebDriver driver){
        js = (JavascriptExecutor) driver;
    }
    public static void scrollIntoView(WebElement webElement, WebDriver driver) {
        initJS(driver);
         js.executeScript("arguments[0].scrollIntoView(true);",webElement);
    }
    public static void click(WebElement webElement, WebDriver driver) {
        initJS(driver);
        js.executeScript("arguments[0].click();",webElement);
    }
}
