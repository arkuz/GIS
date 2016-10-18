package lib;


import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import helpers.FunctionsOS;
import helpers.Waiters;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
    webDriver = new FirefoxDriver();
    //webDriver = new ChromeDriver();
    //webDriver = startNewDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    BasePage BASE_PAGE = new BasePage(webDriver);
  }

  @AfterClass
  public static void stopBrowser() {
    webDriver.quit();
  }
/*
  public static WebDriver startNewDriver() {
    //System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\selenium_grid\\chromedriver_2.23.exe");
    DesiredCapabilities capabilities = getChromeCapabilities();
    LoggingPreferences prefs = new LoggingPreferences();
    prefs.enable(LogType.BROWSER, Level.SEVERE);
    capabilities.setCapability(CapabilityType.LOGGING_PREFS, prefs);
    return new ChromeDriver(capabilities);
  }

  private static DesiredCapabilities getChromeCapabilities() {
    HashMap<String, Object> chromePrefs = new HashMap<>();
    chromePrefs.put("download.prompt_for_download", false);
   // chromePrefs.put("download.default_directory", BaseTestClass.downloadDirPath + File.separator);
    chromePrefs.put("profile.default_content_setting_values.popups", 1);
    chromePrefs.put("profile.default_content_settings.popups", 1);
    ChromeOptions options = new ChromeOptions();
    HashMap<String, Object> chromeOptionsMap = new HashMap<>();
    options.setExperimentalOption("prefs", chromePrefs);
    options.addArguments("--test-type");
    options.addArguments("no-sandbox");
    DesiredCapabilities cap = DesiredCapabilities.chrome();
    cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
    cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    cap.setCapability(ChromeOptions.CAPABILITY, options);
    cap.setCapability(CapabilityType.LOGGING_PREFS, "OFF");
    return cap;
  }
*/
}
