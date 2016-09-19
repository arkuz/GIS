/*package tests.uncategorized;

import lib.BaseTestClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
public class AcceptFunc extends BaseTestClass {

    String[] regions  = {
            "",
            "Адыгея",
            "Башкортостан",
            "Бурятия",
            "Алтай",
            "Дагестан",
            "Ингушетия",
            "Кабардино-Балкарская ",
            "Калмыкия",
            "Карачаево-Черкесская ",
            "Карелия",
            "Коми",
            "Марий Эл",
            "Мордовия",
            "Саха (Якутия)",
            "Северная Осетия",
            "Татарстан",
            "Тыва",
            "Удмуртская ",
            "Хакасия",
            "Чеченская ",
            "Чувашская ",
            "Алтайский край",
            "Краснодарский край",
            "Красноярский край",
            "Приморский край",
            "Ставропольский край",
            "Хабаровский край",
            "Амурская область",
            "Архангельская область",
            "Астраханская область",
            "Белгородская область",
            "Брянская область",
            "Владимирская область",
            "Волгоградская область",
            "Вологодская область",
            "Воронежская область",
            "Ивановская область",
            "Иркутская область",
            "Калининградская область",
            "Калужская область",
            "Камчатский край",
            "Кемеровская область",
            "Кировская область",
            "Костромская область",
            "Курганская область",
            "Курская область",
            "Ленинградская область",
            "Липецкая область",
            "Магаданская область",
            "Московская область",
            "Мурманская область",
            "Нижегородская обл",
            "Новгородская область",
            "Новосибирская область",
            "Омская область",
            "Оренбургская область",
            "Орловская область",
            "Пензенская область",
            "Пермский край",
            "Псковская область",
            "Ростовская область",
            "Рязанская область",
            "Самарская область",
            "Саратовская область",
            "Сахалинская область",
            "Свердловская область",
            "Смоленская область",
            "Тамбовская область",
            "Тверская область",
            "Томская область",
            "Тульская область",
            "Тюменская область",
            "Ульяновская область",
            "Челябинская обл",
            "Забайкальский край",
            "Ярославская область",
            "Москва",
            "Санкт-Петербург",
            "Еврейская автономная область",
            "Ненецкий автономный округ",
            "Ханты-Мансийский автономный округ",
            "Чукотский автономный округ",
            "Ямало-Ненецкий автономный округ",
            "Крым ",
            "Севастополь"};

    String[] numreg  = {
            "",
            "01",
            "02",
            "03",
            "04",
            "05",
            "06",
            "07",
            "08",
            "09",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31",
            "32",
            "33",
            "34",
            "35",
            "36",
            "37",
            "38",
            "39",
            "40",
            "41",
            "42",
            "43",
            "44",
            "45",
            "46",
            "47",
            "48",
            "49",
            "50",
            "51",
            "52",
            "53",
            "54",
            "55",
            "56",
            "57",
            "58",
            "59",
            "60",
            "61",
            "62",
            "63",
            "64",
            "65",
            "66",
            "67",
            "68",
            "69",
            "70",
            "71",
            "72",
            "73",
            "74",
            "75",
            "76",
            "77",
            "78",
            "79",
            "83",
            "86",
            "87",
            "89",
            "91",
            "92"};

    private WebDriver driver = getDriver();
    public static String url = "https://test:eCXn2u@z@vtc.dom.test.gosuslugi.ru:60343/sp-web/sp/login";
    private int LoginTimer = 3000;
    private int timer = 1000;


    private static final By Username = By.id("username");
    private static final By Password = By.id("password");
    private static final By LoginBtn = By.id("authnBtn");

    private static By MenuName = By.xpath("//body/div[1]/div[3]/div/horizontal-menu/nav/div/div/ul/li[6]/a[1]/span[2]");
    private static By AddBtn = By.xpath("//*[@ng-click = 'onAddButtonClick()']");
    private static By SelectOrg = By.xpath("//*[@ng-click = 'onSelectOrgButtonClick()']");

    private static By SubClear = By.xpath("//*[@id='s2id_region']/a/abbr");
    private static By OrgName = By.xpath("//*[@id='organizationName']");

    private static By SearchBtn = By.xpath("//*[@type = 'submit']");

    private static By OrgCheck = By.xpath("//input[contains(@id,'orgRadio')]");

    private static By AddRole = By.xpath("//*[@ng-click = 'addOrganizationRole()']");

    private static final By CancelBtn = By.id("loading-cancel-button");

    private static By CheckBtn = By.xpath("//*[@ng-click = 'select()']");

    private static final By OrgRole = By.xpath("//div[contains(@id,'s2id_organizationRole')]/a/span[2]/b");
    private static final By OIV_KDS = By.xpath("//div[contains(text(),'Контролирующий орган')]");
    private static final By OIV_MJF = By.xpath("//div[text()[contains(.,'ЖФ')]]");
    private static final By GJI = By.xpath("//div[text()[contains(.,'уполномоченный на осуществление государственного жилищного надзора (ГЖИ)')]]");

    private static By SaveBtn = By.xpath("//*[@ng-click = 'save()']");
    private static By Save2Btn = By.xpath("//*[@ng-click = 'onButtonSaveClick()']");
    private static By MaimLogin = By.xpath("//body/div[1]/div[3]/div/div/div/signed-status-badge/div/a");
    private static By Logout = By.xpath("//*[@ng-click = 'logout()']");

    private static final By el = By.xpath("//div[contains(@id,'select2-result-label')]");


    int startNum = 43;
    int endNum = 44;

    int waitDriver = 60;

    //String role = "ОИВ субъекта по мониторингу использования ЖФ_";
    String role = "ОИВ субъекта по контролю за долевым строительством_";

    @Test
    public void Start() throws InterruptedException, IOException {
        for(int i=startNum;i<endNum;i++) {
            driver.get(url);
            //"https://test:eCXn2u@z@vtc.dom.test.gosuslugi.ru:60343/sp-web/sp/login";
            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(Username));



            getElement(Username).sendKeys("OUS_" + numreg[i]);
            getElement(Password).sendKeys("123qweASD");
            //sleep(LoginTimer);
            //getElement(LoginBtn).click();
            click(LoginBtn);

            //sleep(5000);
            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(CancelBtn));
            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.invisibilityOfElementLocated(CancelBtn));

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(MenuName));
            //getElement(MenuName).click();
            click(MenuName);

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(AddBtn));
            //getElement(AddBtn).click();
            click(AddBtn);
/*
            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(CancelBtn));
            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.invisibilityOfElementLocated(CancelBtn));
*/
            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(SelectOrg));
           // getElement(SelectOrg).click();
            click(SelectOrg);

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(OrgName));
            getElement(OrgName).sendKeys(role + numreg[i]);

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(SubClear));
            //getElement(SubClear).click();
            click(SubClear);


            //getElement(SearchBtn).click();
            click(SearchBtn);
            sleep(timer);

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(OrgCheck));
            //getElement(OrgCheck).click();
            click(OrgCheck);

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(CheckBtn));
            //getElement(CheckBtn).click();
            click(CheckBtn);

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(AddRole));
            //getElement(AddRole).click();
            click(AddRole);

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(OrgRole));
            //getElement(OrgRole).click();
            click(OrgRole);
            sleep(timer);


            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(OIV_KDS));
            click(OIV_KDS);
/*
            List<WebElement> list = driver.findElements(el);
            for(i=0;i<list.size();i++){
                System.out.println(Integer.toString(i)+list.get(i).getText());
            }
            WebElement elem = list.get(list.size()-2);
            elem.click();
*/

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(SaveBtn));
            //getElement(SaveBtn).click();
            click(SaveBtn);
           // sleep(30000);

            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(Save2Btn));
            //getElement(Save2Btn).click();
            click(Save2Btn);

            File screenshot = ((TakesScreenshot) driver).
                    getScreenshotAs(OutputType.FILE);
            String path = "./target/screenshots1/" + screenshot.getName();
            FileUtils.copyFile(screenshot, new File(path));
            System.out.println("№ " + Integer.toString(i) + " --- " + role+numreg[i] + ' ' + regions[i] + " OK!");

/*
            (new WebDriverWait(driver, waitDriver))
                    .until(ExpectedConditions.visibilityOfElementLocated(Logout));
            getElement(Logout).click();
*/


            click(Logout);

            click(MaimLogin);


        }
    }

    // получить элемент по локатору
    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) throws InterruptedException {
        WebElement myDynamicElement = waitForClickabilityOfElement(locator);
        int i = 0;
        while (i < 20) {
            try {
                myDynamicElement.click();
                return;
            }
            catch (WebDriverException e){
                i++;
                sleep(1000);
                continue;
            }
        }
    }

    public WebElement waitForClickabilityOfElement(By locator) {
        WebElement element = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

}
