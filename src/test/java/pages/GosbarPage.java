package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Arkuz on 20.09.2016.
 */
public class GosbarPage extends BasePage {

    public GosbarPage(WebDriver driver){
        super(driver);
    }

    //locators
    public By siteMap = By.xpath("//div[@class='portal-header-gosbar']//a[@href='#!/site-map']");

    public void clickSiteMap() throws InterruptedException {
        getElementClick(siteMap);
    }
}
