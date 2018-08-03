import gazeta.HomePage_test;
import gazeta.pages.ArticleList_page;
import gazeta.tests.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;



public class main {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(
                HomePage_test.class
        );

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}

