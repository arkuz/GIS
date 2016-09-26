package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Arkuz on 24.09.2016.
 */
public class LicensesRegistryOfSubjectsPage extends BasePage {

    public LicensesRegistryOfSubjectsPage(WebDriver driver){
        super(driver);
    }

    private By licenseCard = By.xpath("//ef-rls-sprz-item-och//a[@class='register-card__header-title title-link']");
    private By searchBtn = By.xpath("//a[@ng-click='actions.search()']");


    public void goToLicenseRlsPage() throws InterruptedException {
        getElementClick(searchBtn);
        getElementClick(licenseCard);
    }
}
