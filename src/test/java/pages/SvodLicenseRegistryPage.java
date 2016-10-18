package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Arkuz on 12.10.2016.
 */
public class SvodLicenseRegistryPage extends BasePage {

    private static LicensePageRLS LICENSE_RLS_PAGE;

    public SvodLicenseRegistryPage(WebDriver driver){
        super(driver);
        LICENSE_RLS_PAGE =  new LicensePageRLS(driver);
    }


    private By searchBtn = By.xpath("//a[@ng-click='actions.search()']");
    private By licenseSearchResultsH1IsAbsent = By.xpath("//div[@class='container app-content-new ng-scope']/h1[contains(text(),'Отсутствуют результаты поиска')]");
    private By licenseCardHeaderLink = By.xpath("//div[@class='register-card__header clearfix']//a[@class='register-card__header-title title-link']");
    private By showCardBtn = By.xpath("//a[@ng-click='actions.showCard()']");
    private By backToRegistryLink = By.xpath("//span[@ng-click='actions.backToRegistry()']");
    private By disqualifiedPersonsHeader = By.xpath("");

    public void searchLicense() throws InterruptedException {
        getElementClick(searchBtn);
    }

    /*---------------------------------------------------------*/

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

            // Переход в карточку лиценщзии, а затем в карточку в реестре субъектов
            getElementClick(licenseCardHeaderLink);
            getElementClick(showCardBtn);
            // Проверка работоспособности вкладок и возврат в Реестр лицензий субъекта
            if(LICENSE_RLS_PAGE.verifyGeneralInformationTabActive()){
                LICENSE_RLS_PAGE.clickLicenseBusinessDocsTab();
            } if(LICENSE_RLS_PAGE.verifyLicenseBusinessDocsTabActive()){
                LICENSE_RLS_PAGE.clicklicenseInformationOfHousesTab();
                } if(LICENSE_RLS_PAGE.verifyLicenseInformationOfHousesTabActive()){
                     LICENSE_RLS_PAGE.clickLicenseGeneralInfoTab();
                     getElementClick(backToRegistryLink);
                     LICENSE_RLS_PAGE.waitLicenseRegistrySubjectsPage();
                }

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
