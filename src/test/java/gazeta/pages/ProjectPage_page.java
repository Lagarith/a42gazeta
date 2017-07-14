package gazeta.pages;

/* ProjectPage_page */

import Helpers.Settings;
import org.openqa.selenium.By;

import static Helpers.Locators.PhotoListURL;
import static Helpers.Locators.PhotoList_ShowMore_btn;
import static gazeta.components.PageElement.Click;
import static gazeta.components.PageElement.Pause;

public class ProjectPage_page extends Settings{
    private static String[][] data = new String[15][2];

    public static String[][] getLinks() throws Exception {
        browser.get(PhotoListURL);

        Click(PhotoList_ShowMore_btn);
        Pause(1000);
        Click(PhotoList_ShowMore_btn);
        Pause(1000);

        for (int i = 0; i < 15; i++) {
            String xPath = "//*[@id=\"paginate-block\"]/div/div[" + i + "]/p[1]/a/strong";
            String xPath2 = "//*[@id=\"paginate-block\"]/div/div[" + i + "]/p[1]/a";

            data[i][0] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/a/div/div/span")).getText();
            data[i][1] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/a")).getAttribute("href");
            //*[@id="paginate-block"]/div/div[1]/a
        }

        return data;
    }
}
