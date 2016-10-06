package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

/**
 * Created by Arkuz on 24.09.2016.
 */
public class LicensePageRLS extends BasePage {

    public LicensePageRLS(WebDriver driver){
        super(driver);
    }

    // Вкладки "Информация о регистрации лицензии"
    public By licenseBusinessDocsTab = By.xpath("//div[@class='tab-base ng-isolate-scope']//li/a[text()='Документы лицензионного дела']");
    public By licenseInformationOfHousesTab = By.xpath("//div[@class='tab-base ng-isolate-scope']//li/a[text()='Сведения о домах']");
    public By licenseRegistrationActiveTab = By.xpath("//div[@class='tab-base ng-isolate-scope']/ul/li[contains(@class,'active')]/a");
    public By licenseBusinessDocsCardHeader = By.xpath("//div[@class='register-card__header clearfix']");
    //public By licenseInformationOfHousesResultsTable = By.xpath("//ef-rlsoch-prkd-res//span[contains(text(),'Адрес дома')]");
    public By licenseInformationOfHousesResultsTable = By.xpath("//ef-rlsoch-prkd-res//table//a[contains(@ui-sref,'mapSearch')]");
    public By licenseBusinessDocsSearchResultsH1IsAbsent = By.xpath("//ef-rlsoch-przkld/h1[contains(text(),'Отсутствуют результаты поиска')]");
    public By licenseInformationOfHousesSearchResultsH1IsAbsent = By.xpath("//ef-rlsoch-prkd-res//h1[contains(text(),'Отсутствуют результаты поиска')]");
    public By editLicenseBusinessDocName = By.xpath("//input[@ng-model='searchParameters.nameDoc']");
    public By buttonLicenseBusinessDocSearch = By.xpath("//button[@type='submit']");
    public By buttonInformationOfHousesSearch = By.xpath("//a[@ng-click='actions.search()']");
    public By searchObjectsOnMapIdent = By.xpath("//*[@id='search-left-column']/div");

    // Поиск сведений о домах
    public void searchInformationOfHouses() throws InterruptedException {
        getElementClick(buttonInformationOfHousesSearch);
    }

    // Поиск документов лицензионного дела
    public void searchLicenseBusinessDoc() throws InterruptedException {
        getElementSendKeys(editLicenseBusinessDocName, "");
        getElementClick(buttonLicenseBusinessDocSearch);
    }

    // проверяем, что текст активной вкладки = tabText
    public boolean verifyLicenseRegistrationInfoActiveTab(String tabText){
        if (getLicenseRegistrationInfoActiveTab().getText().equals(tabText)) {
            return true;
        }
        return false;
    }

    //получить активную вкладку
    public WebElement getLicenseRegistrationInfoActiveTab(){
        return getElement(licenseRegistrationActiveTab);
    }

    // проверка, что активная вкладка - "Общие сведения"
    public boolean verifyGeneralInformationTabActive(){
        if (verifyLicenseRegistrationInfoActiveTab("Общие сведения")){
            return true;
        }
        return  false;
    }

    // проверка, что активная вкладка - "Документы лицензионного дела"
    public boolean verifyLicenseBusinessDocsTabActive(){
        if (verifyLicenseRegistrationInfoActiveTab("Документы лицензионного дела")){
            return true;
        }
        return  false;
    }

    // проверка, что активная вкладка - "Сведения о домах"
    public boolean verifyLicenseInformationOfHousesTabActive(){
        if (verifyLicenseRegistrationInfoActiveTab("Сведения о домах")){
            return true;
        }
        return  false;
    }

    // Переход к вкладке "Сведения о домах"
    public void clicklicenseInformationOfHousesTab() throws InterruptedException {
        getElementClick(licenseInformationOfHousesTab);
    }


    // Переход к вкладке "Документы лицензионного дела"
    public void clickLicenseBusinessDocsTab() throws InterruptedException {
        getElementClick(licenseBusinessDocsTab);
    }

    // Документы лицензионного дела существуют
    public boolean licenseBusinessDocsExist() {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(licenseBusinessDocsCardHeader,2);
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    // Отсутствуют результаты поиска на вкладке "Документы лицензионного дела". h1 = Отсутствуют результаты поиска.
    public boolean licenseBusinessDocsSearchResultsIsAbsent() {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(licenseBusinessDocsSearchResultsH1IsAbsent,2);
            return true;
        }
        catch (TimeoutException  e){
            return false;
        }
    }

    // Отсутствуют результаты поиска на вкладке "Сведения о домах". h1 = Отсутствуют результаты поиска.
    public boolean licenseInformationOfHousesSearchResultsIsAbsent() {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(licenseInformationOfHousesSearchResultsH1IsAbsent,2);
            return true;
        }
        catch (TimeoutException  e){
            return false;
        }
    }

    // Проверяем, что документы лицензионного дела существуют или появляется сообщение - "Отсутствуют результаты поиска"
    public boolean verifyLicenseBusinessDocsResults() {
        if(licenseBusinessDocsExist() || licenseBusinessDocsSearchResultsIsAbsent()){
            return true;
        }
        return false;
    }

    // Таблица со сведениями о домах существует
    public boolean licenseInformationOfHousesExist() throws InterruptedException {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(licenseInformationOfHousesResultsTable,2);
            // Переход на карту объектов из таблицы
            getElementClick(licenseInformationOfHousesResultsTable);
            WebElement we1 = WAIT.waitForVisibilityOfElement(searchObjectsOnMapIdent,2);
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    // Проверяем, что Таблица со сведениями о домах существует или появляется сообщение - "Отсутствуют результаты поиска"
    public boolean verifyLicenseInformationOfHousesResults() throws InterruptedException {
        if(licenseInformationOfHousesExist() || licenseInformationOfHousesSearchResultsIsAbsent()){
            return true;
        }
        return false;
    }


}
