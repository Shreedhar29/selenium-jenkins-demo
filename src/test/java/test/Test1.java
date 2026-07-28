package test;

import main.java.org.example.automation.functionaltesting.theInternetherokuapp.Drivermanager.DriverManager;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.hooks.Base;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.page.DynamicControlPage;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.page.HeroKuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends Base {

    @Test(groups = "sanity")
    public void test1() {
        HeroKuPage heroKuPage = new HeroKuPage(DriverManager.getDriver());
        heroKuPage.clickDynamicLoadingButton();
        heroKuPage.clickExample1Button();
        heroKuPage.clickStartButton();
        Assert.assertEquals(heroKuPage.clickLoadingButton(),"Hello World!");
    }

    @Test(groups = "smoke")
    public void test2() throws InterruptedException {
        DynamicControlPage dynamicControlPage = new DynamicControlPage(DriverManager.getDriver());
        dynamicControlPage.clickDynamicControls();
        dynamicControlPage.removeCheckbox();
        dynamicControlPage.addCheckboxBack();
        dynamicControlPage.enableInputAndType();
        Assert.assertFalse(dynamicControlPage.disableInput());
    }
}
