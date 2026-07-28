package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.Drivermanager.DriverManager;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.page.HeroKuPage;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.robot.Config;
import org.testng.Assert;

public class DynamicLoadingSteps {

    private HeroKuPage heroKuPage;

    @Given("I am on the herokuapp homepage")
    public void iAmOnTheHerokuappHomepage() {
        DriverManager.getDriver().get(Config.readProperty("baseurl"));
    }

    @When("I navigate to Dynamic Loading")
    public void iNavigateToDynamicLoading() {
        heroKuPage = new HeroKuPage(DriverManager.getDriver());
        heroKuPage.clickDynamicLoadingButton();
    }

    @When("I open Example 1")
    public void iOpenExample1() {
        heroKuPage.clickExample1Button();
    }

    @When("I click Start")
    public void iClickStart() {
        heroKuPage.clickStartButton();
    }

    @Then("I should see {string}")
    public void iShouldSee(String expectedText) {
        Assert.assertEquals(heroKuPage.clickLoadingButton(), expectedText);
    }
}
