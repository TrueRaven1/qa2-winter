package homeworks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;

import java.util.List;

public class DelfiTestByPages {
    private final String HOME_PAGE_URL = "delfi.lv";

    @Test
    public void titlesCheck() {
        //Open browser window (maximize it)
        BaseFunc baseFunc = new BaseFunc();

        //Open home page
        baseFunc.openUrl(HOME_PAGE_URL);
        HomePage homePage = new HomePage(baseFunc);

        //Accept cookies
        homePage.acceptCookies();

        //Get 1rd article title

        List<WebElement> titles = homePage.articlesTitlesOnDelfi();
        //Print to console

        //Open 1rd article

        //Get title

        //Print to console

        //Compare titles

        //Go to comment page

        //compare titles

        //// get to console all titles
    }
}


