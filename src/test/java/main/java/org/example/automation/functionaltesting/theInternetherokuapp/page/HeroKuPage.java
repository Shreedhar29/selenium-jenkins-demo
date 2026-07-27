package main.java.org.example.automation.functionaltesting.theInternetherokuapp.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeroKuPage extends PageBase {

    @FindBy(xpath="//a[contains(text(),'Dynamic Loading')]")
    WebElement dynamicLoadingButton;

    @FindBy(xpath = "//a[contains(text(),'Example 1')]")
    WebElement example1Button;

    @FindBy(css = ".example #start button")
    WebElement startButton;

    @FindBy(css = ".example #loading")
    WebElement loadingButton;

    @FindBy(css = ".example #finish h4")
    WebElement finishButton;



    public HeroKuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickDynamicLoadingButton() {
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingButton)).click();
    }
    public void clickExample1Button() {
        wait.until(ExpectedConditions.visibilityOf(example1Button)).click();
    }
    public void clickStartButton() {
        startButton.click();
    }
    public String clickLoadingButton() {
        wait.until(ExpectedConditions.invisibilityOf(loadingButton));
        return finishButton.getText();
    }

}
