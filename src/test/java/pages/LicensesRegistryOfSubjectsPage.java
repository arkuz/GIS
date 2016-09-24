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

    public By licenseCard = By.xpath("//ef-rls-sprz-item-och//a[@class='register-card__header-title title-link']");


}
