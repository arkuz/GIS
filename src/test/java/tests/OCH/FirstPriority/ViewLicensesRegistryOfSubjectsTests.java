package tests.OCH.FirstPriority;

import lib.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import static java.lang.Thread.sleep;

/**
 * Created by Arkuz on 24.09.2016.
 */
public class ViewLicensesRegistryOfSubjectsTests extends BaseTestClass {

    //Группа тестов : Реестр лицензий субъекта РФ

    private static MenuPage MENU_PAGE;
    private static LicensesRegistryOfSubjectsPage LICENSE_REGISTRY_SUBJECTS;
    private static  LicensePageRLS LICENSE_RLS_PAGE;


    @BeforeClass
    public static void beforeClassMethod() {
        MENU_PAGE = new MenuPage(webDriver);
        LICENSE_REGISTRY_SUBJECTS = new LicensesRegistryOfSubjectsPage(webDriver);
        LICENSE_RLS_PAGE =  new LicensePageRLS(webDriver);

    }

    @Test(description = "LIC_27 Просмотр карточки лицензии в открытой части РЛС")
    public void testViewLicenseCardInOpenPartRLS() throws InterruptedException {

        MENU_PAGE.getElementClick(MENU_PAGE.registryItem);
        MENU_PAGE.getElementClick(MENU_PAGE.licensesRegistry);
        LICENSE_REGISTRY_SUBJECTS.getElementClick(LICENSE_REGISTRY_SUBJECTS.licenseCard);

        Assert.assertEquals(LICENSE_RLS_PAGE.verifyLicenseRegistrationInfoTabsActive(),true);

        LICENSE_RLS_PAGE.getElementClick(LICENSE_RLS_PAGE.licenseBusinessDocs);

        sleep(2000);


    }
}
