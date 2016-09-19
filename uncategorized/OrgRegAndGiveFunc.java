package tests.uncategorized;

import lib.BaseTestClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;

public class OrgRegAndGiveFunc extends BaseTestClass {

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

  private static By FactualAddr = By.xpath("//*[@ng-click = 'showFactualAddressDialog()']");
  private static By PostalAddr = By.xpath("//*[@ng-click = 'showPostalAddressDialog()']");

  private static final By Region = By.xpath("//*[@id='s2id_region']/a/span[2]/b");
  private static final By RegionSearch = By.id("s2id_autogen2_search");
  private static final By RegionSearch2 = By.xpath("//div[@id='select2-drop']//input[contains(@id,'s2id_autogen')]");
  private static final By RegionExist = By.xpath("//div[contains(@id,'select2-result-label')]");

  private static final By City = By.xpath("//*[@id='s2id_city']/a/span[2]/b");
  private static final By CityExist = By.xpath("//div[contains(@id,'select2-result-label')]");

  private static final By Street = By.xpath("//*[@id='s2id_street']/a/span[2]/b");
  private static final By StreetExist = By.xpath("//div[contains(@id,'select2-result-label')]");

  private static final By AddressBtnOk = By.xpath("//*[@ng-click = 'modalOptions.ok()']");

  private static By AddFunction = By.xpath("//*[@ng-click = 'add()']");

  private static final By OrgRole = By.xpath("//div[contains(@id,'s2id_organizationRole')]/a/span[2]/b");
  private static final By OIV_KDS = By.xpath("//div[text()[contains(.,'долевого строительства многоквартирных домов и (или) иных объектов недвижимости')]]");
  private static final By GJI = By.xpath("//div[text()[contains(.,'уполномоченный на осуществление государственного жилищного надзора (ГЖИ)')]]");
  private static final By RegionRole = By.xpath("//div[contains(@id,'s2id_autogen')]/a/span[2]/b");
  private static final By RegionRoleSearch = By.xpath("//div[@id='select2-drop']//input[contains(@id,'s2id_autogen')]");
  private static final By RegionRoleExist = By.xpath("//div[contains(@id,'select2-result-label')]");

  private static By SaveFunction = By.xpath("//*[@ng-click = 'save()']");

  private static final By OrganizationAgreement = By.xpath("//*[@ng-model = 'details.organizationAgreement']");
  private static final By Agreement = By.xpath("//*[@ng-model = 'details.agreement']");

  private static By NextBtn = By.xpath("//*[@ng-click = 'next()']");
  private static By RegBtn = By.xpath("//*[@ng-click = 'register()']");
  private static By Logout = By.xpath("//*[@ng-click = 'logout()']");
  private static By YesBtn = By.xpath("//*[@ng-click = \"yes('ok')\"]");
  private static final By CancelBtn = By.id("loading-cancel-button");

  private static By MaimLogin = By.xpath("//body/div[1]/div[3]/div/div/div/signed-status-badge/div/a");

  private static By Error = By.xpath("html/body/div[4]/div/div/div/div[1]/h4");
  private static By ErrorBtn = By.xpath("//*[@ng-click = \"close('no')\"]");

  int startNum = 33;
  int endNum = 86;

  int waitDriver = 60;

  @Test
  public void Start() throws InterruptedException, IOException {
    for(int i=startNum;i<endNum;i++) {
      driver.get(url);
      //"https://test:eCXn2u@z@vtc.dom.test.gosuslugi.ru:60343/sp-web/sp/login";
      (new WebDriverWait(driver, waitDriver))
              .until(ExpectedConditions.visibilityOfElementLocated(Username));
      getElement(Username).sendKeys("GJI_"+numreg[i]);
      getElement(Password).sendKeys("123qweASD");
      sleep(LoginTimer);
      getElement(LoginBtn).click();

      (new WebDriverWait(driver, waitDriver))
              .until(ExpectedConditions.visibilityOfElementLocated(FactualAddr));
      addAddress(FactualAddr, RegionSearch2, regions[i]);
      addAddress(PostalAddr, RegionSearch2, regions[i]);

      sleep(timer);
      getElement(AddFunction).click();
      sleep(timer);
      getElement(OrgRole).click();
      sleep(timer);
      getElement(GJI).click();
      sleep(timer);
      getElement(RegionRole).click();
      sleep(timer);
      getElement(RegionRoleSearch).sendKeys(regions[i]);
      sleep(timer);
      getElement(RegionRoleExist).click();
      sleep(timer);
      getElement(SaveFunction).click();
      sleep(timer);
      getElement(OrganizationAgreement).click();
      sleep(timer);
      getElement(NextBtn).click();
      sleep(timer);
      getElement(Agreement).click();
      sleep(timer);


      getElement(RegBtn).click();
      sleep(timer);

      String s = getElement(Error).getText();

      if(s.equals("Ошибка")){
        File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" + screenshot.getName();

        FileUtils.copyFile(screenshot, new File(path));
        System.out.println("№ "+Integer.toString(i)+" --- "+numreg[i]+' '+regions[i]+" ("+path+") ERROR!!!!!");
        getElement(YesBtn).click();
        (new WebDriverWait(driver, waitDriver))
                .until(ExpectedConditions.visibilityOfElementLocated(Logout));
        getElement(Logout).click();
        sleep(timer);
        getElement(ErrorBtn).click();

      }
      else{
        getElement(YesBtn).click();
        System.out.println("№ "+Integer.toString(i)+" --- "+numreg[i]+' '+regions[i]+" OK!");

        sleep(5000);
        (new WebDriverWait(driver, waitDriver))
                .until(ExpectedConditions.invisibilityOfElementLocated(CancelBtn));

        (new WebDriverWait(driver, waitDriver))
                .until(ExpectedConditions.visibilityOfElementLocated(Logout));
        getElement(Logout).click();
      }

      (new WebDriverWait(driver, waitDriver))
              .until(ExpectedConditions.visibilityOfElementLocated(MaimLogin));

      (new WebDriverWait(driver, waitDriver))
              .until(ExpectedConditions.invisibilityOfElementLocated(CancelBtn));

      (new WebDriverWait(driver, waitDriver))
              .until(ExpectedConditions.visibilityOfElementLocated(MaimLogin));


      //assertEquals("", getElement("").getAttribute("title"));

    }
  }

  // получить элемент по локатору
  public WebElement getElement(By locator) {
    return driver.findElement(locator);
  }

  private void addAddress(By locator, By RegionSearch, String region) throws InterruptedException {
    // выбор региона
    sleep(timer);
    getElement(FactualAddr).click();
    sleep(timer);
    getElement(Region).click();
    sleep(timer);
    getElement(RegionSearch).sendKeys(region);
    sleep(timer);
    getElement(RegionExist).click();

    //выбор города
    sleep(timer);
    getElement(City).click();
    sleep(timer);
    getElement(CityExist).click();

    //выбор улицы
    sleep(timer);
    getElement(Street).click();
    sleep(timer);
    getElement(StreetExist).click();

    //Нажимаем ОК на фактическом адресе
    sleep(timer);
    getElement(AddressBtnOk).click();
  }
}
