package tests.OCH.ViewPortalMainPage;

import lib.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MainPage;
import pages.ViewUsefulLinksPage;

import java.util.Set;

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
        assertEquals(VIEW_USEFUL_LINK_PAGE.verifyItemLinkLength(),true);

        Set<String> oldWindowHandler = VIEW_USEFUL_LINK_PAGE.getWindowsSet();
        VIEW_USEFUL_LINK_PAGE.getElementClick(VIEW_USEFUL_LINK_PAGE.itemLinkFirst);
        VIEW_USEFUL_LINK_PAGE.getNewWindow(oldWindowHandler);
        assertEquals(VIEW_USEFUL_LINK_PAGE.getElementText(VIEW_USEFUL_LINK_PAGE.personalAccountLink),
                VIEW_USEFUL_LINK_PAGE.str_personalAccountLink);
        VIEW_USEFUL_LINK_PAGE.closeCurrentWindow();
        VIEW_USEFUL_LINK_PAGE.getMainWindow(oldWindowHandler);
    }

}
