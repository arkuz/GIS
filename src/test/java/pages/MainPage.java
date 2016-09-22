package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Arkuz on 15.09.2016.
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver){
        super(driver);
    }
    //locators
    public By usefulLinksBtn = By.xpath("//useful-resources//a[@href='#!/useful-links']");
    public By consumersLink = By.xpath("//a[@href='#!/audience/consumers']");
    public By suppliersLink = By.xpath("//a[@href='#!/audience/suppliers']");
    public By authoritiesLink = By.xpath("//a[@href='#!/audience/authorities']");
    public By usefulLinksUnit = By.xpath("//ul[@class='useful-resources__list-items']/li");
    public By kodexLink = By.xpath("//recent-docs//a[text()='ЖИЛИЩНЫЙ КОДЕКС РФ']");

    // проверка количества полезных ссылок <=7
    public boolean verifyUsefulLinksCount(){
        if(getElements(usefulLinksUnit).size()<=7){
            return true;
        } else return false;
    }

    // проверка наличия элементов с иконками
    public boolean verifyUsefulLinksIcon(){
        int flag = 1;
        String attr = "useful-resources__list-i-icon useful-resources__icon-link";
        List<WebElement> bc = getElements(usefulLinksUnit);
        for(int i=0;i<bc.size();i++) {
            if(bc.get(i).findElement(By.xpath(".//a/span")).getAttribute("class").equals(attr)){
                flag = flag * 1;
            } else flag = 0;
        }
        if(flag==1){
            return true;
        }else return false;
    }

    // проверка наличия элементов c названиями (ссылками)
    public boolean verifyUsefulLinksName(){
        int flag = 1;
        String attr = "link.title";
        List<WebElement> bc = getElements(usefulLinksUnit);
        for(int i=0;i<bc.size();i++) {
            if(bc.get(i).findElement(By.xpath(".//a[@ng-bind='link.title']")).getAttribute("ng-bind").equals(attr)){
                flag = flag * 1;
            }else flag = 0;
        }
        if(flag==1){
            return true;
        }else return false;
    }

    // проверка наличия элементов c описаниями
    public boolean verifyUsefulLinksDescription(){
        int flag = 1;
        String attr = "link.desc";
        List<WebElement> bc = getElements(usefulLinksUnit);
        for(int i=0;i<bc.size();i++) {
            if(bc.get(i).findElement(By.xpath(".//p[@ng-bind='link.desc']")).getAttribute("ng-bind").equals(attr)){
                flag = flag * 1;
            }else flag = 0;
        }
        if(flag==1){
            return true;
        }else return false;
    }
}
