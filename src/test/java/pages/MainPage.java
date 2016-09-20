package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Arkuz on 15.09.2016.
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver){
        super(driver);
    }
    //locators
    public By usefulLinksBtn = By.xpath("//useful-resources//a[@href='#!/useful-links']");
    public By consumersLink = By.xpath("//a[@href='#!/audience/consumers']");
    public By suppliersLink = By.xpath("//a[@href='#!/audience/suppliers']");
    public By authoritiesLink = By.xpath("//a[@href='#!/audience/authorities']");
    public By usefulLinksUnit = By.xpath("//ul[@class='useful-resources__list-items']");

    public boolean verifyUsefulLinksCount(){
        if(getElements(usefulLinksUnit).size()<=7){
            return true;
        } else return false;

    }
}
