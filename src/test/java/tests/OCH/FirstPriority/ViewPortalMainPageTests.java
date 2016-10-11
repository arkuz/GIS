package tests.OCH.FirstPriority;

import lib.BaseTestClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GosbarPage;
import pages.MainPage;
import pages.SiteMapPage;
import pages.ViewUsefulLinksPage;

import java.util.Set;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

/**
 * Created by Arkuz on 14.09.2016.
 */
public class ViewPortalMainPageTests extends BaseTestClass{

    //Группа тестов : Просмотр главной страницы портала ГИС ЖКХ + Футер

    private static MainPage MAIN_PAGE;
    private static ViewUsefulLinksPage VIEW_USEFUL_LINK_PAGE;
    private static GosbarPage GOSBAR_PAGE;
    private static SiteMapPage SITE_MAP_PAGE;

    @BeforeClass
    public static void beforeClassMethod() {
        MAIN_PAGE = new MainPage(webDriver);
        VIEW_USEFUL_LINK_PAGE = new ViewUsefulLinksPage(webDriver);
        GOSBAR_PAGE = new GosbarPage(webDriver);
        SITE_MAP_PAGE = new SiteMapPage(webDriver);
    }

    @Test(description = "OCH_9 Просмотр полезных ссылок")
    public void testViewUsefulLinks() throws InterruptedException {
        //Заходим на тест с главной страницы
        MAIN_PAGE.clickUsefulLinks();
        viewUsefulLinksMethod();

        ///Заходим на тест через госбар
        GOSBAR_PAGE.clickSiteMap();
        SITE_MAP_PAGE.clickUsefulLinks();
        viewUsefulLinksMethod();

    }

    @Test(description = "OCH_50 Просмотр списка ссылок с внутренних страниц портала ГИС ЖКХ")
    public void testViewUsefulLinksWithInnerPages() throws InterruptedException {

        //Просмотр блока полезных ссылок с потребителей
        MAIN_PAGE.viewConsumersLink();
        ViewUsefulLinksWithInnerPagesMethod();

        //Просмотр блока полезных ссылок с поставщиков
        MAIN_PAGE.viewSuppliersLink();
        ViewUsefulLinksWithInnerPagesMethod();

        //Просмотр блока полезных ссылок с органов власти
        MAIN_PAGE.viewAuthoritiesLink();
        ViewUsefulLinksWithInnerPagesMethod();
    }

    @Test(description = "OCH_49 Проверка наличия ЖИЛИЩНОГО КОДЕКСА РФ")
    public void testSaveKodexFile() throws InterruptedException {

        String path = "C:\\Users\\Arkuz\\Downloads\\Жилищный кодекс.pdf";
        assertEquals(MAIN_PAGE.checkDownloadKodexFile(path),true);
    }


    // основная часть теста testViewUsefulLinks()
    private void viewUsefulLinksMethod() throws InterruptedException {

        assertEquals(VIEW_USEFUL_LINK_PAGE.verifyBreadcrumbs(),true);
        assertEquals(VIEW_USEFUL_LINK_PAGE.verifyItemLinkLength(),true);

        Set<String> oldWindowHandler = VIEW_USEFUL_LINK_PAGE.getWindowsSet();
        VIEW_USEFUL_LINK_PAGE.getElementClick(VIEW_USEFUL_LINK_PAGE.itemLinkFirst);
        VIEW_USEFUL_LINK_PAGE.getNewWindow(oldWindowHandler);

        assertEquals(VIEW_USEFUL_LINK_PAGE.getElementText(VIEW_USEFUL_LINK_PAGE.personalAccountLink),
                VIEW_USEFUL_LINK_PAGE.str_personalAccountLink);

        VIEW_USEFUL_LINK_PAGE.closeCurrentWindow();
        VIEW_USEFUL_LINK_PAGE.getMainWindow(oldWindowHandler);
    }

    // основная часть теста testViewUsefulLinksWithInnerPages()
    private void ViewUsefulLinksWithInnerPagesMethod() {
        assertEquals(MAIN_PAGE.verifyUsefulLinksCount(),true);
        assertEquals(MAIN_PAGE.verifyUsefulLinksIcon(),true);
        assertEquals(MAIN_PAGE.verifyUsefulLinksName(),true);
        assertEquals(MAIN_PAGE.verifyUsefulLinksDescription(),true);
    }
}
