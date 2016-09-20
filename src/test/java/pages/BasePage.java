package pages;

import lib.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public  Set<String>  getWindowHandler() {
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
}
