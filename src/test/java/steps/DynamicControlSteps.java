package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.Drivermanager.DriverManager;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.page.DynamicControlPage;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.robot.Config;
import org.testng.Assert;

public class DynamicControlSteps {

    private DynamicControlPage dynamicControlPage;
    private boolean result;

    @When("I navigate to Dynamic Controls")
    public void iNavigateToDynamicControls() {
        DriverManager.getDriver().get(Config.readProperty("baseurl"));
        dynamicControlPage = new DynamicControlPage(DriverManager.getDriver());
        dynamicControlPage.clickDynamicControls();
        System.out.println("HAha a this code is updated *&^%$#@#$%^&*()(*&^%$#@#$%^&*()(*&^%$#$%^&*()(*&^%$#");
    }

    @When("I remove the checkbox")
    public void iRemoveTheCheckbox() {
        dynamicControlPage.removeCheckbox();
        Assert.assertEquals(dynamicControlPage.getGoneMessage(), "It's gone!");
    }

    @When("I add the checkbox back")
    public void iAddTheCheckboxBack() {
        dynamicControlPage.addCheckboxBack();
        Assert.assertTrue(dynamicControlPage.isCheckboxDisplayed());
    }

    @When("I enable the input and type text")
    public void iEnableTheInputAndTypeText() {
        dynamicControlPage.enableInputAndType();
    }

    @When("I disable the input")
    public void iDisableTheInput() {
        result = dynamicControlPage.disableInput();
    }

    @Then("the input should be disabled")
    public void theInputShouldBeDisabled() {
        Assert.assertFalse(result);
    }
}
