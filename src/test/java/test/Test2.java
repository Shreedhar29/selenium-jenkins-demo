package test;

import main.java.org.example.automation.functionaltesting.theInternetherokuapp.robot.JSutils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Test2 {

    @Test
    public void test1(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

       // options.addArguments("--headless");
        Map<String,String> prefs = new HashMap<>();
        prefs.put("download.default_directory","C://downloads");
        Map<String,Boolean> prefs1 = new HashMap<>();
        prefs1.put("credentials_enable_service", false);
        prefs1.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs",prefs);
        options.setExperimentalOption("prefs",prefs1
        );
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        WebElement element =  driver.findElement(By.cssSelector("#login-button"));
        //driver.navigate().refresh();
        element =  wait.until(d->d.findElement(By.cssSelector("#login-button")));
        element.click();
//         Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        System.out.println(alert.getText());
//        driver.switchTo().alert().accept();
        WebElement product = wait.until(d->d.findElement(By.cssSelector("#item_2_title_link div")));
         String productName = product.getText();
        JSutils.scrollIntoView(product,driver);
        product.click();
        WebElement cartBtn =wait.until(d->d.findElement(By.cssSelector("#add-to-cart")));
        cartBtn.click();
        WebElement cart =wait.until(d->d.findElement(By.cssSelector(".shopping_cart_link")));
        cart.click();
        WebElement item =wait.until(d->d.findElement(By.xpath("//div[@data-test='inventory-item-name']")));

        String itemName =item.getText();
        Assert.assertEquals(itemName,productName);

        wait.until(d->d.findElement(By.cssSelector("#checkout"))).click();
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Shreedhar");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("V S");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("577528");
        driver.findElement(By.cssSelector("#finish")).click();
        String msg ="Thank you for your order!";
        Assert.assertEquals(driver.findElement(By.cssSelector(".complete-header")).getText(),msg);






    }
}
