package tests.OCH.FirstPriority;

import lib.BaseTestClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

/**
 * Created by Arkuz on 24.09.2016.
 */
public class ViewLicensesRegistryOfSubjectsTests extends BaseTestClass {

    //Группа тестов : Реестр лицензий субъекта РФ

    private static LicensesRegistryOfSubjectsPage LICENSE_REGISTRY_SUBJECTS_PAGE;
    private static LicensePageRLS LICENSE_RLS_PAGE;
    private static MenuPage MENU_PAGE;
    private static DisqualifiedPersonsRegistryPage DISQUALIFIED_PERSONS_REGISTRY_PAGE;
    private static SvodLicenseRegistryPage SVOD_LICENSE_REGISTRY_PAGE;


    @BeforeClass
    public static void beforeClassMethod() {
        MENU_PAGE = new MenuPage(webDriver);
        LICENSE_REGISTRY_SUBJECTS_PAGE = new LicensesRegistryOfSubjectsPage(webDriver);
        LICENSE_RLS_PAGE =  new LicensePageRLS(webDriver);
        DISQUALIFIED_PERSONS_REGISTRY_PAGE = new DisqualifiedPersonsRegistryPage(webDriver);
        SVOD_LICENSE_REGISTRY_PAGE = new SvodLicenseRegistryPage(webDriver);
    }

    @Test(description = "LIC_27 Просмотр карточки лицензии в открытой части РЛС")
    public void testViewLicenseCardInOpenPartRLS() throws InterruptedException {

        MENU_PAGE.goToLicenseRegistrySubjectsPage();
        LICENSE_REGISTRY_SUBJECTS_PAGE.goToLicenseRlsPage();
        assertEquals(LICENSE_RLS_PAGE.verifyGeneralInformationTabActive(),true);

        LICENSE_RLS_PAGE.clickLicenseBusinessDocsTab();
        assertEquals(LICENSE_RLS_PAGE.verifyLicenseBusinessDocsTabActive(),true);

        LICENSE_RLS_PAGE.searchLicenseBusinessDoc();
        assertEquals(LICENSE_RLS_PAGE.verifyLicenseBusinessDocsResults(),true);

        LICENSE_RLS_PAGE.clicklicenseInformationOfHousesTab();
        assertEquals(LICENSE_RLS_PAGE.verifyLicenseInformationOfHousesTabActive(),true);

        LICENSE_RLS_PAGE.searchInformationOfHouses();
        assertEquals(LICENSE_RLS_PAGE.verifyLicenseInformationOfHousesResults(),true);

    }

    @Test(description = "LIC_25 Просмотр карточки сведений о дисквалифицированном лице в открытой части реестра дискв.лиц")
    public void testViewDisqualifiedPersonsCardInOpenPart() throws InterruptedException {

        MENU_PAGE.goToDisqualifiedPersonsRegistryPage();
        DISQUALIFIED_PERSONS_REGISTRY_PAGE.searchDisqualifiedPersons();
        assertEquals(DISQUALIFIED_PERSONS_REGISTRY_PAGE.verifyDisqualifiedPersonsResults(),true);


    }

    @Test(description = "LIC_29 Просмотр карточки лицензии в сводном федеральном реестре лицензий")
    public void testViewLicenseCardInSvodLicensesRegistry() throws InterruptedException {

        MENU_PAGE.goToSvodLicensesRegistryPage();
        SVOD_LICENSE_REGISTRY_PAGE.searchLicense();
        assertEquals(SVOD_LICENSE_REGISTRY_PAGE.verifyLicenseSearchResults(),true);


    }


}
