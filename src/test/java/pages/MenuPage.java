package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Arkuz on 24.09.2016.
 */
public class MenuPage extends BasePage {

    // Реестры
    public By registryItem = By.xpath("//div[@id='main-menu']//a[contains(text(),'Реестры')]");
    public By licensesRegistry = By.xpath("//div[@id='main-menu']//a[@href='#!/licenses']");

    public MenuPage(WebDriver driver){
        super(driver);
    }

    public void goToLicenseRegistrySubjectsPage() throws InterruptedException {
        getElementClick(registryItem);
        getElementClick(licensesRegistry);
        //String url = getDriver().getCurrentUrl()+"#!/licenses";
        //getDriver().get(url);
    }

}
