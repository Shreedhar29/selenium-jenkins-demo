package main.java.org.example.automation.functionaltesting.theInternetherokuapp.Drivermanager;

import main.java.org.example.automation.functionaltesting.theInternetherokuapp.robot.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    private static final ThreadLocal<WebDriver> tDriver=  new ThreadLocal<>();

    public static void initDriver(){
        if(tDriver.get()==null){
              switch (Config.readProperty("browser")){
                  case "chrome"-> {

                      ChromeOptions options = new ChromeOptions();
                      if(Config.readProperty("headless").equals("true")){
                          options.addArguments("--headless=new");
                          options.addArguments("--no-sandbox");
                          options.addArguments("--disable-dev-shm-usage");
                          options.addArguments("--window-size=1920,1080");
                      }

                      tDriver.set(new ChromeDriver(options));
                  }
                  case "firefox"-> {
                      FirefoxOptions options = new FirefoxOptions();
                      if(Config.readProperty("headless").equals("true")){
                          options.addArguments("--headless");
                      }
                      tDriver.set(new FirefoxDriver(options));
                  }
                  default -> {
                      throw new RuntimeException("Browser not defined");
                  }
              }
        }


    }
    public static WebDriver getDriver(){
        if(tDriver.get()==null){ initDriver();
        }System.out.println("Created Driver : "
                + tDriver.get().hashCode()
                + " Thread : "
                + Thread.currentThread().getId());
        return  tDriver.get();
    }
    public static void quitDriver(){
        if (tDriver.get() != null) {
            tDriver.get().quit();
        }
        tDriver.remove();
    }
}
