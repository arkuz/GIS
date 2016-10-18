package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Arkuz on 12.10.2016.
 */
public class SvodLicenseRegistryPage extends BasePage {

    public SvodLicenseRegistryPage(WebDriver driver){
        super(driver);
    }

    private By searchBtn = By.xpath("//a[@ng-click='actions.search()']");
    private By licenseSearchResultsH1IsAbsent = By.xpath("//div[@class='container app-content-new ng-scope']/h1[contains(text(),'Отсутствуют результаты поиска')]");
    private By licenseCardHeaderLink = By.xpath("//div[@class='register-card__header clearfix']//a[@class='register-card__header-title title-link']");
    private By showCardBtn = By.xpath("//a[@ng-click='actions.showCard()']");

    public void searchLicense() throws InterruptedException {
        getElementClick(searchBtn);
    }

    /*---------------------------------------------------------*/


    private By backToRegistryLink = By.xpath("//a[@ng-click='actions.backToRegistry()']");
    private By disqualifiedPersonsHeader = By.xpath("//div[@ng-if='pageTitle']/h1[contains(text(),'Реестр дисквалифицированных лиц')]");
    //для проверки варианта с карточками
    private By deleteStatusInfo = By.xpath("//*[@id='s2id_autogen2']/ul/li[1]/a");


    // Отсутствуют результаты поиска.
    public boolean licenseSearchResultsIsAbsent() {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(licenseSearchResultsH1IsAbsent,2);
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    // Результаты поиска существуют
    public boolean licenseSearchResultsIsExist() throws InterruptedException {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(licenseCardHeaderLink,2);

            getElementClick(licenseCardHeaderLink);
            getElementClick(showCardBtn);

           // WebElement we1 = WAIT.waitForVisibilityOfElement(disqualifiedPersonsHeader,2);
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    // Проверяем, что существуют дисквалифицированные лица или появляется сообщение - "Отсутствуют результаты поиска"
    public boolean verifyLicenseSearchResults() throws InterruptedException {

        if(licenseSearchResultsIsExist() || licenseSearchResultsIsAbsent()){
            return true;
        }
        return false;
    }
    /*---------------------------------------------------------*/

}
