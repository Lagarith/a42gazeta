package gazeta.tests;

import Helpers.Settings;
import gazeta.pages.PhotoReportPage_page;
import gazeta.pages.ProjectPage_page;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Dimension;

import static gazeta.components.PageElement.LoadPageAndVerify;
import static junit.framework.Assert.assertTrue;
import com.automation.remarks.video.annotations.Video;
//import com.automation.remarks.video.junit.VideoRule;
import com.automation.remarks.junit.VideoRule;


/** ProjectPage_test */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectPage_test extends Settings{

    private static String[][] data = new String[15][2];

    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
        data = ProjectPage_page.getLinks();
    }



    @Test
    public void a_OpenProjectListPage_test() throws Exception {
        for (String[] item:data) {
            LoadPageAndVerify(item[1]);
            System.out.println(item[1]);
        }
    }



    @Rule
    public VideoRule videoRule = new VideoRule();

    @Test
    @Video(name = "second_test")
    public void videoTest() throws Exception {
        browser.get("https://www.google.ru/");
        Thread.sleep(3000);
        assertTrue(false);
    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }

}
