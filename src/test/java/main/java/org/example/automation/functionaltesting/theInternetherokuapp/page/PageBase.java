    package main.java.org.example.automation.functionaltesting.theInternetherokuapp.page;

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class PageBase {

         WebDriverWait wait;

         public PageBase(WebDriver driver) {
             wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         }

    }
