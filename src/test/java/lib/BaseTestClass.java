package lib;


import java.util.concurrent.TimeUnit;

import helpers.FunctionsOS;
import helpers.Waiters;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTestClass {

  public static WebDriver webDriver;
  public static String homePageURL = "http://dom.gosuslugi.ru/";
  //public static String homePageURL = "https://lanit:tv,n8!Ya@kpak.dom.test.gosuslugi.ru/";

  @BeforeMethod
  public void getHomePage(){
    webDriver.get(homePageURL);
  }

  @BeforeClass
  public static void startBrowser() {
    BasePage BASE_PAGE = new BasePage(webDriver);
    //webDriver = new FirefoxDriver();
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

  @AfterClass
  public static void stopBrowser() {
    webDriver.quit();
  }

}
