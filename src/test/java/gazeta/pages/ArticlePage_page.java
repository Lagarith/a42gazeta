package gazeta.pages;

import Helpers.Settings;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static Helpers.Locators.NewsListURL;
import static Helpers.Locators.NewsList_ShowMore_btn;
import static Helpers.PageElement.Click;

public class ArticlePage_page extends Settings {

    private static String[][] data = new String[30][2];

    public static String[][] getLinks() throws Exception {
        browser.get(NewsListURL);

        Click(NewsList_ShowMore_btn);
        Click(NewsList_ShowMore_btn);

        for (int i = 0; i < 30; i++) {
            data[i][0] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/p[1]/a/strong")).getText();
            data[i][1] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/p[1]/a")).getAttribute("href");
        }

        return data;
    }

}
