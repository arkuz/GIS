package pages;

import lib.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

/**
 * Created by Arkuz on 14.09.2016.
 */
public class ViewUsefulLinksPage extends BasePage{

    public ViewUsefulLinksPage(WebDriver driver){
        super(driver);
    }

    //locators
    public By usefulLinksH1 = By.xpath("//h1[@ng-bind='pageTitle']");
    public By breadcrumbs = By.xpath("//form-header//li");
    public By itemLink = By.xpath("//useful-link-item//a");
    public By itemLinkFirst = By.xpath("//useful-link-item//a[contains(text(),'Сайт государственных услуг')]");
    // локатор на личный кабинет на главной странице www.gosuslugi.ru
    public By personalAccountLink = By.xpath("//*[@id='header']//a[contains(text(),'Личный кабинет')]");

    //expected results
    public String str_usefulLinks = "Полезные ссылки";
    public String str_personalAccountLink = "Личный кабинет";

    //helpMethods

    // проверка хлебных крошек, все пункты кроме последнего ссылки, последний - текст
    public boolean verifyBreadcrumbs(){
        int flag = 1;
        List<WebElement> bc = webDriver.findElements(breadcrumbs);
        for(int i=0;i<bc.size()-1;i++) {
            if(bc.get(i).findElement(By.xpath("./a")).getAttribute("ng-if").equals("$first")){
                flag = flag * 1;
            } else flag = 0;
        }

        if(bc.get(bc.size()-1).findElement(By.xpath("./span")).getAttribute("ng-if").equals("$last")){
            flag = flag * 1;
        }else flag = 0;

        if(flag==1){
            return true;
        }else return false;
    }

    // проверка длины текста в полезных ссылках, <= 100
    public boolean verifyItemLinkLength() {
        int flag = 1;
        List<WebElement> bc = webDriver.findElements(itemLink);
        for (int i = 0; i < bc.size() - 1; i++) {
            if(bc.get(i).getText().length()<=100){
                flag = flag * 1;
            } else flag = 0;
        }
        if(flag==1){
            return true;
        }else return false;
    }

}

