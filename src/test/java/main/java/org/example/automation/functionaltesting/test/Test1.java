package main.java.org.example.automation.functionaltesting.test;

import org.apache.commons.io.FileUtils;
import main.java.org.example.automation.functionaltesting.page.FlipkartPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Test1 {
  FlipkartPage page;

    @Test
    public void test() throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        page = new FlipkartPage(driver);

        Actions actions = new Actions(driver);
        actions.scrollToElement(page.searchElement).build();
        Select select = new Select(page.searchElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(page.searchElement)).sendKeys("Iphone", Keys.ENTER);
        wait.until(dr->dr.findElement(By.cssSelector(".RG5Slk"))
                .getText().contains("Iphone"));
        List<WebElement> iphone = wait.until(ele-> ele.findElements(By.cssSelector(".RG5Slk")));

           iphone.stream().filter(ele->ele.getText().contains("Pink")).findAny().ifPresent(WebElement::click);
           String parent = driver.getWindowHandle();
           Set<String> windowHandles = driver.getWindowHandles();
          // Iterator<String> iterator = windowHandles.iterator();
           for (String window: windowHandles) {
               if(!window.equals(parent)){
                   driver.switchTo().window(window);
                   break;
               }
           }
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("window.scrollBy(0,500)");
           TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
           File src=  takesScreenshot.getScreenshotAs(OutputType.FILE);
             FileUtils.copyFile(src,new File("src/screenshots.png"));
    }
}
