package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.Drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SauceDemoSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private String productName;

    @Given("I am on the SauceDemo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    @When("I select a product")
    public void iSelectAProduct() {
        WebElement product = wait.until(d -> d.findElement(By.cssSelector("#item_2_title_link div")));
        productName = product.getText();
        product.click();
    }

    @When("I add it to the cart")
    public void iAddItToTheCart() {
        wait.until(d -> d.findElement(By.cssSelector("#add-to-cart"))).click();
        wait.until(d -> d.findElement(By.cssSelector(".shopping_cart_link"))).click();

        String itemName = wait.until(d -> d.findElement(By.xpath("//div[@data-test='inventory-item-name']"))).getText();
        Assert.assertEquals(itemName, productName);
    }

//    @When("I proceed to checkout")
//    public void iProceedToCheckout() {
//        wait.until(d -> d.findElement(By.cssSelector("#checkout"))).click();
//    }
//
//    @When("I fill shipping details with first name {string}, last name {string}, and zip {string}")
//    public void iFillShippingDetails(String firstName, String lastName, String zip) {
//        driver.findElement(By.cssSelector("#first-name")).sendKeys(firstName);
//        driver.findElement(By.cssSelector("#last-name")).sendKeys(lastName);
//        driver.findElement(By.cssSelector("#postal-code")).sendKeys(zip);
//    }
//
//    @When("I complete the purchase")
//    public void iCompleteThePurchase() {
//        driver.findElement(By.cssSelector("#finish")).click();
//    }
//
//    @Then("I should see the confirmation {string}")
//    public void iShouldSeeTheConfirmation(String expectedMessage) {
//        String actual = driver.findElement(By.cssSelector(".complete-header")).getText();
//        Assert.assertEquals(actual, expectedMessage);
//    }
}
