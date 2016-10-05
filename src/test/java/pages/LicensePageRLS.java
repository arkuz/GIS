package pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Arkuz on 24.09.2016.
 */
public class LicensePageRLS extends BasePage {

    public LicensePageRLS(WebDriver driver){
        super(driver);
    }

    // Вкладки "Информация о регистрации лицензии"
    public By licenseBusinessDocs = By.xpath("//div[@class='tab-base ng-isolate-scope']//li/a[text()='Документы лицензионного дела']");
    public By licenseRegistrationActiveTab = By.xpath("//div[@class='tab-base ng-isolate-scope']/ul/li[contains(@class,'active')]/a");
    public By licenseBusinessDocsCardHeader = By.xpath("//div[@class='register-card__header clearfix']");
    public By licenseBusinessDocsCardIsAbsent = By.xpath("//h1[text()= 'Отсутствуют результаты поиска']");
    public By editLicenseBusinessDocName = By.xpath("//input[@ng-model='searchParameters.nameDoc']");
    public By buttonLicenseBusinessDocSearch = By.xpath("//button[@type='submit']");

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

    // Переход к вкладке "Документы лицензионного дела"
    public void clickLicenseBusinessDocsTab() throws InterruptedException {
        getElementClick(licenseBusinessDocs);
    }

    // Документы лицензионного дела существуют
    public boolean licenseBusinessDocsExist() {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(licenseBusinessDocsCardHeader,1);
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    // Документы лицензионного дела не прикреплены
    public boolean licenseBusinessDocsIsAbsent() {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(licenseBusinessDocsCardIsAbsent,1);
            return true;
        }
        catch (TimeoutException  e){
            return false;
        }
    }

    // Проверяем, что документы лицензионного дела существуют или появляется сообщение - "Отсутствуют результаты поиска"
    public boolean verifyLicenseBusinessDocsResults() {
        if(licenseBusinessDocsExist() || licenseBusinessDocsIsAbsent()){
            return true;
        }
        return false;
    }
}
