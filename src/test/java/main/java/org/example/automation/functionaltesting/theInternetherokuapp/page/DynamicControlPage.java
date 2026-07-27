package main.java.org.example.automation.functionaltesting.theInternetherokuapp.page;

import main.java.org.example.automation.functionaltesting.theInternetherokuapp.robot.JSutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControlPage extends PageBase {

    @FindBy(xpath = "//a[contains(text(),'Dynamic Controls')]")
    WebElement dynamicControlsButton;

    @FindBy(css = ".example #checkbox-example button")
    WebElement removeButton;

    @FindBy(css = ".example div[id='checkbox'] input")
    WebElement checkboxButton;

    @FindBy(css = ".example #input-example button")
    WebElement enableButton;

    @FindBy(css = ".example #input-example input")
    WebElement inputBox;

    @FindBy(css =".example #checkbox-example p")
    WebElement goneMsg;

    WebDriver driver;

    public DynamicControlPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean dynamicControlFlow() {

       wait.until(ExpectedConditions.visibilityOf(dynamicControlsButton)).click();

        // Remove checkbox
        removeButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(goneMsg, "It's gone!"));
        Assert.assertEquals(goneMsg.getText(), "It's gone!");

        // Add checkbox
        removeButton.click();
        By checkbox = By.cssSelector(".example #checkbox");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
        Assert.assertTrue( wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox)).isDisplayed());

//
//        // Enable textbox
        JSutils.scrollIntoView(enableButton, driver);
        enableButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("Selenium Practice");
//
        // Disable textbox
        enableButton.click();
        wait.until(driver -> !inputBox.isEnabled());
        return inputBox.isEnabled();
    }


}
