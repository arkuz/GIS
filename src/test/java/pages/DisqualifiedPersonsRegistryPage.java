package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Arkuz on 12.10.2016.
 */
public class DisqualifiedPersonsRegistryPage extends BasePage {

    public DisqualifiedPersonsRegistryPage(WebDriver driver){
        super(driver);
    }

    public By licenseBusinessDocsSearchResultsH1IsAbsent = By.xpath("//ef-rlsoch-przkld/h1[contains(text(),'Отсутствуют результаты поиска')]");
}
