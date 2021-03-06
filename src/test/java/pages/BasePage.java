package pages;

import helpers.Waiters;
import lib.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

/**
 * Created by Arkuz on 15.09.2016.
 */
public class BasePage {

    protected WebDriver webDriver;
    static Waiters WAIT;

    public BasePage(WebDriver driver){

        this.webDriver = driver;
        WAIT = new Waiters(driver);
    }

    public WebDriver getDriver(){
        return webDriver;
    }

    public WebElement getElement(By locator) {
        return webDriver.findElement(locator);
    }

    public  Set<String>  getWindowsSet() {
        Set<String> windowsSet = webDriver.getWindowHandles();
        return windowsSet;
    }

    public void getElementClick(By locator) throws InterruptedException {
        WebElement myDynamicElement = WAIT.waitForClickabilityOfElement(locator);
        int i = 0;
        while (i < 20) {
            try {
                myDynamicElement.click();
                return;
            }
            catch (WebDriverException e){
                i++;
                sleep(1000);
                continue;
            }
        }
    }

    public void getElementSendKeys(By locator, String text) throws InterruptedException {
        WebElement myDynamicElement = WAIT.waitForClickabilityOfElement(locator);
        int i = 0;
        while (i < 20) {
            try {
                myDynamicElement.sendKeys(text);
                return;
            }
            catch (WebDriverException e){
                i++;
                sleep(1000);
                continue;
            }
        }
    }

    public String getElementText(By locator) {
        return webDriver.findElement(locator).getText();
    }

    public String getNewWindow(Set<String> oldWindowHandler) {
        Set<String> newWindowsHandler = getWindowsSet();
        newWindowsHandler.removeAll(oldWindowHandler);
        String currentWindow = newWindowsHandler.iterator().next();
        webDriver.switchTo().window(currentWindow);
        return currentWindow;
    }

    public void closeCurrentWindow(){
        webDriver.close();
    }

    public void getMainWindow(Set<String> WindowHandler){
        String currentWindow = WindowHandler.iterator().next();
        webDriver.switchTo().window(currentWindow);
    }

    public List<WebElement> getElements(By locator){
        List<WebElement> list = webDriver.findElements(locator);
        return list;
    }


}
