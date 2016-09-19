package lib;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

public class BaseTestClass {

  public static WebDriver webDriver;
  public static String mainPageURL = "http://dom.gosuslugi.ru/#!/main";

  @BeforeClass
  public static void startBrowser() {
    BasePage BASE_PAGE = new BasePage(webDriver);
    //webDriver = new FirefoxDriver();
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    webDriver.get(mainPageURL);
  }

  @AfterClass
  public static void stopBrowser() {
    webDriver.quit();
  }

}
