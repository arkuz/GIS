package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Arkuz on 20.09.2016.
 */
public class SiteMapPage extends BasePage {

    public SiteMapPage(WebDriver driver){
        super(driver);
    }

    //locators
    public By usefulLinks = By.xpath("//a[@href='#!/useful-links']");

    public void clickUsefulLinks() throws InterruptedException {
        getElementClick(usefulLinks);
    }
}
