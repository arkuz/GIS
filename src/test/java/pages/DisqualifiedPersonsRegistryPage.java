package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Arkuz on 12.10.2016.
 */
public class DisqualifiedPersonsRegistryPage extends BasePage {

    public DisqualifiedPersonsRegistryPage(WebDriver driver){
        super(driver);
    }

    private By disqualifiedPersonsSearchResultsH1IsAbsent = By.xpath("//div[@class='container app-content-new ng-scope']/h1[contains(text(),'Отсутствуют результаты поиска')]");
    private By disqualifiedPersonCardHeaderLink = By.xpath("//div[@class='register-card__header clearfix']//a[@class='register-card__link cnt-link']");
    private By backToRegistryLink = By.xpath("//a[@ng-click='actions.backToRegistry()']");
    private By disqualifiedPersonsHeader = By.xpath("//div[@ng-if='pageTitle']/h1[contains(text(),'Реестр дисквалифицированных лиц')]");
    //для проверки варианта с карточками
    private By deleteStatusInfo = By.xpath("//*[@id='s2id_autogen2']/ul/li[1]/a");
    private By searchBtn = By.xpath("//ef-bp-form/div/form/div[2]/div/div[2]/button");



    // Отсутствуют результаты поиска.
    public boolean disqualifiedPersonsSearchResultsIsAbsent() {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(disqualifiedPersonsSearchResultsH1IsAbsent,2);
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    // Результаты поиска существуют
    public boolean disqualifiedPersonsExist() throws InterruptedException {
        try{
            WebElement we = WAIT.waitForVisibilityOfElement(disqualifiedPersonCardHeaderLink,2);

            getElementClick(disqualifiedPersonCardHeaderLink);
            getElementClick(backToRegistryLink);
            WebElement we1 = WAIT.waitForVisibilityOfElement(disqualifiedPersonsHeader,2);
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    // Проверяем, что существуют дисквалифицированные лица или появляется сообщение - "Отсутствуют результаты поиска"
    public boolean verifyDisqualifiedPersonsResults() throws InterruptedException {

        if(disqualifiedPersonsExist() || disqualifiedPersonsSearchResultsIsAbsent()){
            return true;
        }
        return false;
    }

    public void searchDisqualifiedPersons() throws InterruptedException {
        //для проверки варианта с карточками
        //getElementClick(searchBtn);
        //getElementClick(deleteStatusInfo);
        getElementClick(searchBtn);
    }
}
