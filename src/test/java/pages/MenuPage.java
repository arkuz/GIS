package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Arkuz on 24.09.2016.
 */
public class MenuPage extends BasePage {

    // Реестры
    private By registryItem = By.xpath("//div[@id='main-menu']//a[contains(text(),'Реестры')]");
    private By licensesRegistry = By.xpath("//div[@id='main-menu']//a[@href='#!/licenses']");
    private By disqualifiedPersonsRegistry = By.xpath("//div[@id='main-menu']//a[@href='#!/licenses/person/search']");
    private By svodLicensesRegistry = By.xpath("//div[@id='main-menu']//a[@href='#!/srlLicenses']");

    public MenuPage(WebDriver driver){
        super(driver);
    }

    public void goToLicenseRegistrySubjectsPage() throws InterruptedException {
        getElementClick(registryItem);
        getElementClick(licensesRegistry);
        //String url = getDriver().getCurrentUrl()+"#!/licenses";
        //getDriver().get(url);
    }

    public void goToDisqualifiedPersonsRegistryPage() throws InterruptedException {
        getElementClick(registryItem);
        getElementClick(disqualifiedPersonsRegistry);
    }

    public void goToSvodLicensesRegistryPage() throws InterruptedException {
        getElementClick(registryItem);
        getElementClick(svodLicensesRegistry);
    }

}
