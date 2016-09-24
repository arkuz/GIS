package tests.OCH.FirstPriority;

import lib.BaseTestClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Arkuz on 24.09.2016.
 */
public class LicensesRegistryOfSubjectsTests extends BaseTestClass {

    //Группа тестов : Реестр лицензий субъекта РФ

    private static MenuPage MENU_PAGE;


    @BeforeClass
    public static void beforeClassMethod() {
        MENU_PAGE = new MenuPage(webDriver);

    }

    @Test(description = "LIC_27 Просмотр карточки лицензии в открытой части РЛС")
    public void testViewLicenseCardInOpenPartRLS() throws InterruptedException {
        //Заходим на тест с главной страницы
        MENU_PAGE.getElementClick(MENU_PAGE.registryItem);
        MENU_PAGE.getElementClick(MENU_PAGE.licensesRegistry);


    }
}
