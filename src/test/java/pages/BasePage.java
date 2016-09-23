package pages;

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

    public BasePage(WebDriver driver){
        this.webDriver = driver;
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
        WebElement myDynamicElement = waitForClickabilityOfElement(locator);
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

    public WebElement waitForClickabilityOfElement(By locator) {
        WebElement element = (new WebDriverWait(webDriver, 15))
                .until(ExpectedConditions.elementToBeClickable(locator));
        return element;
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

    public boolean isFileExist(String path){
        File file = new File(path);
        return file.exists();
    }

    public void deleteFile(String path){
        File file = new File(path);
        if (isFileExist(path)) {
            file.delete();
        }
    }

    public boolean waitFileExist(String path) throws InterruptedException {
        int i = 0;
        while (i < 15) {
            if (isFileExist(path)) {
                return true;
            }
            sleep(1000);
            i++;
        }
        return false;
    }

}
