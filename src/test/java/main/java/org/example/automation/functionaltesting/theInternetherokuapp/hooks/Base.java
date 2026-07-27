package main.java.org.example.automation.functionaltesting.theInternetherokuapp.hooks;

import main.java.org.example.automation.functionaltesting.theInternetherokuapp.Drivermanager.DriverManager;
import main.java.org.example.automation.functionaltesting.theInternetherokuapp.robot.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {



    @BeforeMethod
    public void beforeTest(){
         DriverManager.getDriver().get(Config.readProperty("baseurl"));



    }

    @AfterMethod
    public void closeDriver(){
        DriverManager.quitDriver();
    }
}
