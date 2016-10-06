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
    // для проверки, когда в сведениях по домам присутствуют объекты, для перехода к карте
    //private By licenseCard = By.xpath("//ef-rls-sprz-item-och//a/span[contains(text(),'026000232 от 23.09.2015')]");
    private By searchBtn = By.xpath("//a[@ng-click='actions.search()']");


    public void goToLicenseRlsPage() throws InterruptedException {
        getElementClick(searchBtn);
        getElementClick(licenseCard);
    }
}
