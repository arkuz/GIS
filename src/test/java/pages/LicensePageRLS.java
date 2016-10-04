package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public void clickLicenseBusinessDocsTab() throws InterruptedException {
        getElementClick(licenseBusinessDocs);
    }


}
