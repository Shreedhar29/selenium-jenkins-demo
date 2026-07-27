package main.java.org.example.automation.functionaltesting.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPage {

    private WebDriver driver;

    @FindBy(css = "form .nw1UBF.v1zwn25")
    public WebElement searchElement;

    public FlipkartPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver,this);

    }


}
