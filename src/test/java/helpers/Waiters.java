package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class Waiters {

    //Таймаут для ждаторов
    public static final int GLOBAL_TIMEOUT = 30;
    private WebDriver driver;

    public Waiters(WebDriver driver){this.driver = driver;}

    public void waitForNotVisibilityOfElement(WebElement element) {
        int i = 0;

        while (i < GLOBAL_TIMEOUT) {
            i++;
            timeout(1);

            try {
                if (!element.isDisplayed()) {
                    return;
                }
            } catch (WebDriverException e) {
                return;
            }
        }

        //Assert.fail(MessageText.TIMEOUT_ERROR);
    }

    public void waitForNotVisibilityOfElement(By locator){
        int i = 0;

        while (i < GLOBAL_TIMEOUT) {
            i++;
            timeout(1);

            try {
                if (!driver.findElement(locator).isDisplayed()) {
                    return;
                }
            } catch (WebDriverException e) {
                return;
            }
        }

        //Assert.fail(MessageText.TIMEOUT_ERROR);
    }

    // ждем пока все элементы будет isDisplayed
    public List<WebElement> waitForVisibilityOfAllElements(By locator) {
        waitForPresenceOfAllElements(locator);
        List<WebElement> listAllElements=(new WebDriverWait(driver, 15))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return listAllElements;

    }

    // ждем пока все элементы будет isDisplayed
    public List<WebElement> waitForPresenceOfAllElements(By locator) {

        List<WebElement> listAllElements=(new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return listAllElements;

    }

    // ждем пока элемент будет isDisplayed
    public WebElement waitForVisibilityOfElement(By locator) {
        waitForPresenceOfElement(locator);
        WebElement element = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    // ждем пока элемент будет isDisplayed
    public WebElement waitForVisibilityOfElement(By locator, int duration) {
        waitForPresenceOfElement(locator, duration);
        WebElement element = (new WebDriverWait(driver, duration))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    // ждем пока элемент не появится в ДОМе
    public WebElement waitForPresenceOfElement(By locator) {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    // ждем пока элемент не появится в ДОМе в течение указанного времени
    public WebElement waitForPresenceOfElement(By locator, int duration) {
        WebElement element = (new WebDriverWait(driver, duration))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    // ждем пока элемент будет isDisplayed и isEnabled
    public WebElement waitForClickabilityOfElement(By locator) {
        waitForPresenceOfElement(locator);
        WebElement element = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    // ждем пока элемент пропадет из ДОМа
    public void waitForStalenessOfElement(WebElement element) {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.stalenessOf(element));
    }

    public void waitForPositiveValue(List<WebElement> list) {
        int i = 0;

        while (i < GLOBAL_TIMEOUT) {
            i++;
            timeout(1);
            if (list.size() >= 1) {
                return;
            }
        }
        //Assert.fail(MessageText.TIMEOUT_ERROR);
    }

    public List waitForPositiveValue(By listLocator) {

        int i = 0;

        while (i < GLOBAL_TIMEOUT) {
            List<WebElement> list = driver.findElements(listLocator);
            i++;
            timeout(1);
            if (list.size() > 0) {
                return list;
            }
        }

        //Assert.fail(MessageText.TIMEOUT_ERROR);
        return null;
    }

    // ждем пока адрес будет содержать строку
    public void waitForUrlContains(String urlContains) {
        (new WebDriverWait(driver, 30 )).until(ExpectedConditions.urlContains(urlContains));
    }

    public void timeout(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElement(final WebElement element) {
        (new WebDriverWait(driver, 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return element.isEnabled();
            }
        });
    }

}
