package tests.OCH.ViewPortalMainPage;

import lib.BaseTestClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MainPage;
import pages.ViewUsefulLinksPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by Arkuz on 14.09.2016.
 */
public class ViewPortalMainPageTests extends BaseTestClass{

    private static MainPage MAIN_PAGE;
    private static ViewUsefulLinksPage VIEW_USEFUL_LINK_PAGE;

    @BeforeClass
    public static void beforeClassMethod() {
        MAIN_PAGE = new MainPage(webDriver);
        VIEW_USEFUL_LINK_PAGE = new ViewUsefulLinksPage(webDriver);
    }

    @Test(description = "OCH_9 Просмотр полезных ссылок")
    public void testViewUsefulLinks() throws InterruptedException {

        MAIN_PAGE.getElementClick(MAIN_PAGE.usefulLinksBtn);
        assertEquals(VIEW_USEFUL_LINK_PAGE.verifyBreadcrumbs(),true);
        Thread.sleep(1000);
    }

}
