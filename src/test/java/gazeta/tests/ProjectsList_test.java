package gazeta.tests; /** gazeta.tests.ProjectsList_test */

import Helpers.Settings;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;

import static Helpers.Locators.*;
import static gazeta.components.PageElement.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectsList_test extends Settings {

    public String[] errors_articles;

    public void openAndResave(int i) throws Exception {

        //PUSH EDIT BUTTON
        browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[3]/table/tbody/tr[" + i + "]/td[4]/div/a/button")).click();

        //SLEEP
        Thread.sleep(4000);

        //SAVE
        browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div[2]/div/button[1]")).click();

        //SLEEP
        Thread.sleep(2000);

        //IS OK?
        try {
            browser.findElement(By.xpath("//*[contains(text(), 'Изменения сохранены.')]"));
        } catch (Exception e) {
            System.out.println("Error:" + browser.getCurrentUrl());
        }

        System.out.println(i);

        browser.navigate().back();
        Thread.sleep(2000);

    }



    public void nextPage() throws Exception {
        browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/div/div/button[2]")).click();
    }



    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
    }



    @Test
    public void a_NewsList_load_test() throws Exception {
        LoadPageAndVerify(ProjectListURL);
    }



    @Test
    public void reSave_equip() throws Exception {

        //AUTH
        browser.get("http://kemavtodor.l.atwinta.ru/manager");
        browser.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
        browser.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("azxcvfgt");
        browser.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();

        Thread.sleep(5000);

        for (int i = 1; i < 31; i++) {

            //GET CAR LIST PAGE
            browser.get("http://kemavtodor.l.atwinta.ru/admin/#/machinery");
            Thread.sleep(2000);

            browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/div/div/ul/li[2]")).click();
            Thread.sleep(2000);

            try {
                browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[3]/table/tbody/tr[" + i + "]/td[4]/div/a/button")).isDisplayed();
            } catch (Exception e) {
                break;
            }

            //if (browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[3]/table/tbody/tr[" + i + "]/td[4]/div/a/button")).isDisplayed()) {

                //GO TO CAR EDIT PAGE
                browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[3]/table/tbody/tr[" + i + "]/td[4]/div/a/button")).click();
                Thread.sleep(3000);

                //TAKE CAR ARTICLE
                String article = browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div/div[2]/div[1]/div[2]/div/div/input")).getAttribute("value");
                System.out.println("Car article: " + article);

                //GO TO EQUIP LIST PAGE
                browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div/div[1]/div/div[1]/div/div[5]")).click();
                Thread.sleep(3000);

                for (int j = 1; j < 31; j++) {
                    try {
                        browser.findElement(By.xpath("//*[@id=\"equipment\"]/div[1]/div[3]/table/tbody/tr[" + j + "]/td[4]/div/a/button")).isDisplayed();
                    } catch (Exception e) {
                        break;
                    }
                    //if (browser.findElement(By.xpath("//*[@id=\"equipment\"]/div[1]/div[3]/table/tbody/tr[" + j + "]/td[4]/div/a/button")).isDisplayed()) {

                        //GO TO EQUIP PAGE
                        browser.findElement(By.xpath("//*[@id=\"equipment\"]/div[1]/div[3]/table/tbody/tr[" + j + "]/td[4]/div/a/button")).click();
                        Thread.sleep(3000);

                        //GET CURRENT EQUIP KEYS
                        String equp_keys = browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[4]/div/div/input")).getAttribute("value");
                        System.out.println("Equip keys: " + equp_keys);

                        //TRIM KEYS FOR KEYS ARRAY
                        String equip_car_keys[] = equp_keys.split(",");

                        //COMPARE ARTICLE AND KEYS
                        boolean add_status = true;
                        for (String equip_car_key : equip_car_keys) {
                            if (equip_car_key.equals(article)) add_status = false;
                        }

                        //ADD ARTICLE IN KEYS
                        if (add_status) browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[4]/div/div/input")).sendKeys("," + article);
                        Thread.sleep(2000);

                        //SAVE RESULTS
                        browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div[2]/div/button[1]")).click();
                        Thread.sleep(2000);

                        //IS OKAY?
                        try {
                            browser.findElement(By.xpath("//*[contains(text(), 'Изменения сохранены')]"));
                        } catch (Exception e) {
//                            errors_articles[index] = browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/input")).getAttribute("value");
//                            index++;
                            System.out.println("Double article:" + browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/input")).getAttribute("value"));
                        }

                        Thread.sleep(2000);

                        //GO BACK PAGE
                        browser.navigate().back();
                        Thread.sleep(2000);

                        //GO TO EQUIP LIST PAGE
                        browser.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div/div[1]/div/div[1]/div/div[5]")).click();
                        Thread.sleep(2000);
                    }
                }
            }

        // CAR LIST
        //*[@id="app"]/div[2]/div/div/div[2]/div[3]/table/tbody/tr[1]/td[4]/div/a/button
        //*[@id="app"]/div[2]/div/div/div[2]/div[3]/table/tbody/tr[30]/td[4]/div/a/button
        // CAR EQUIP LIST
        //*[@id="equipment"]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div/a/button
        //*[@id="equipment"]/div[1]/div[3]/table/tbody/tr[13]/td[4]/div/a/button
        //*[@id="equipment"]/div[1]/div[3]/table/tbody/tr[2]/td[4]/div/a/button

        /*for (String error_article:errors_articles) {
            System.out.println("\n" + error_article);
        }*/



    @Test
    public void add_new_tech() throws Exception {

    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }
}
