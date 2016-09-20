package tests.OCH.ViewPortalMainPage;

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
        MAIN_PAGE.getElementClick(MAIN_PAGE.usefulLinksBtn);
        viewUsefulLinksMethod();

        ///Заходим на тест через госбар
        MAIN_PAGE.getElementClick(GOSBAR_PAGE.siteMap);
        SITE_MAP_PAGE.getElementClick(SITE_MAP_PAGE.usefulLinks);
        viewUsefulLinksMethod();

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

    @Test(description = "OCH_50 Просмотр списка ссылок с внутренних страниц портала ГИС ЖКХ")
    public void testViewUsefulLinksWithInnerPages() throws InterruptedException {


    }
}
