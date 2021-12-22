package pageobject;

import org.junit.jupiter.api.Test;
import pageobject.model.Article;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;

public class ArticleTests {
    private final String HOME_PAGE_URL = "tvnet.lv";

    @Test
    public void titleAndCommentsCountCheck() {
        //Open browser window (maximize it)
        BaseFunc baseFunc = new BaseFunc();

        //Open home page
        baseFunc.openUrl(HOME_PAGE_URL);
        HomePage homePage = new HomePage(baseFunc);

        //Accept cookies
        homePage.acceptCookies();

        //Get 3rd article title
        Article article = homePage.getArticleById(1);
        System.out.println(article.getCommentsCount());


        //Open 3rd article

        //Get title

        //Get comments count

        //Compare titles

        //Compare comments count

        //...
    }
}
