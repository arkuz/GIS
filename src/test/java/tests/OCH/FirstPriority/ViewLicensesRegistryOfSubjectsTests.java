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


    private static LicensesRegistryOfSubjectsPage LICENSE_REGISTRY_SUBJECTS_PAGE;
    private static  LicensePageRLS LICENSE_RLS_PAGE;
    private static MenuPage MENU_PAGE;


    @BeforeClass
    public static void beforeClassMethod() {
        MENU_PAGE = new MenuPage(webDriver);
        LICENSE_REGISTRY_SUBJECTS_PAGE = new LicensesRegistryOfSubjectsPage(webDriver);
        LICENSE_RLS_PAGE =  new LicensePageRLS(webDriver);

    }

    @Test(description = "LIC_27 Просмотр карточки лицензии в открытой части РЛС")
    public void testViewLicenseCardInOpenPartRLS() throws InterruptedException {

        MENU_PAGE.goToLicenseRegistrySubjectsPage();
        LICENSE_REGISTRY_SUBJECTS_PAGE.goToLicenseRlsPage();

        Assert.assertEquals(LICENSE_RLS_PAGE.verifyGeneralInformationTabActive(),true);

        LICENSE_RLS_PAGE.clickLicenseBusinessDocsTab();
        Assert.assertEquals(LICENSE_RLS_PAGE.verifyLicenseBusinessDocsTabActive(),true);

    }


}
