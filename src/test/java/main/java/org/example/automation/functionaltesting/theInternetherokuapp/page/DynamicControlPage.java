package main.java.org.example.automation.functionaltesting.theInternetherokuapp.page;

import main.java.org.example.automation.functionaltesting.theInternetherokuapp.robot.JSutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public void clickDynamicControls() {
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsButton)).click();
    }

    public void removeCheckbox() {
        removeButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(goneMsg, "It's gone!"));
    }

    public String getGoneMessage() {
        return goneMsg.getText();
    }

    public void addCheckboxBack() {
        removeButton.click();
        By checkbox = By.cssSelector(".example #checkbox");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
    }

    public boolean isCheckboxDisplayed() {
        By checkbox = By.cssSelector(".example #checkbox");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox)).isDisplayed();
    }

    public void enableInputAndType() {
        JSutils.scrollIntoView(enableButton, driver);
        enableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("Selenium Practice");
    }

    public boolean disableInput() {
        enableButton.click();
        wait.until(d -> !inputBox.isEnabled());
        return inputBox.isEnabled();
    }

}
