package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Arkuz on 15.09.2016.
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver){
        super(driver);
    }
    //locators
    public By usefulLinksBtn = By.xpath("//useful-resources//a[@href='#!/useful-links']");

}