package gazeta.pages;

import Helpers.Settings;
import org.openqa.selenium.By;

import static Helpers.Locators.CompanyListURL;
import static Helpers.Locators.NewsList_ShowMore_btn;
import static gazeta.components.PageElement.Click;

public class CompanyPage_page extends Settings{

    private static String[][] data = new String[30][2];

    public static String[][] getLinks() throws Exception {
        browser.get(CompanyListURL);

        Click(NewsList_ShowMore_btn);
        Click(NewsList_ShowMore_btn);

        for (int i = 0; i < 30; i++) {
            data[i][0] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/p[1]/a/strong")).getText();
            data[i][1] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/p[1]/a")).getAttribute("href");
        }

        return data;
    }

}
