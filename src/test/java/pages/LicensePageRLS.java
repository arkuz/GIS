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
    public By licenseRegistrationInfoTabs = By.xpath("//div[@class='tab-base ng-isolate-scope']/ul");
    public By licenseBusinessDocs = By.xpath("//div[@class='tab-base ng-isolate-scope']//li/a[text()='Документы лицензионного дела']");


    // проверка, что активная вкладка - "Общие сведения"
    public boolean verifyLicenseRegistrationInfoTabsActive(){
        int flag = 1;
        String attr = "ng-isolate-scope active";
        String attr1 = "Общие сведения";
        List<WebElement> bc = getElements(licenseRegistrationInfoTabs);
        for(int i=0;i<bc.size();i++) {
            if (bc.get(i).findElement(By.xpath(".//li")).getAttribute("class").equals(attr) &&
                    bc.get(i).findElement(By.xpath(".//li/a")).getText().equals(attr1)) {
                return true;
            }
        }
        return false;
    }

    public void clickLicenseBusinessDocsTab() {
        getElement(licenseBusinessDocs);
    }

}
