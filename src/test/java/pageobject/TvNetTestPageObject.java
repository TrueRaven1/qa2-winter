package pageobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.model.Article;
import pageobject.pages.ArticlePage;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;

public class TvNetTestPageObject {
    private final String tvNetUrl = "tvnet.lv";
    private int ArticleId = (3);

    @Test
    public void titlesAndCommentsCheck() {

        //Open browser window (maximize it)
        BaseFunc baseFunc = new BaseFunc();
        //Open home page
        baseFunc.openUrl(tvNetUrl);
        HomePage homePage = new HomePage(baseFunc);

        //Accept cookies
        homePage.acceptCookies();
        //Get 3rd article title and comments
        Article article = homePage.getArticleById(ArticleId);
        int commentCountOnHomePage = article.getCommentsCount();
        System.out.println(article.getCommentsCount());
        String titleTextOnHomePage = article.getTitle();
        System.out.println(article.getTitle());

        //Open 3rd article
        homePage.openArticleByIdTVNET(ArticleId);
        ArticlePage articlePage = new ArticlePage(baseFunc);
        //Get title
        String titleInArticle = articlePage.getTitleInArticleTVNET();
        System.out.println(titleInArticle);
        //Get comments count
        int commentCountInArticle = articlePage.getCommentCountInArticleTVNET();
        System.out.println(commentCountInArticle);
        //Compare titles
        Assertions.assertTrue(titleTextOnHomePage.startsWith(titleInArticle), "Title on Article page is different");
        //Compare comments count
        Assertions.assertEquals(commentCountOnHomePage, commentCountInArticle, "Comments count in article is different");
        //Open comment page


        //Get title

        //Get comments count

        //Compare titles

        //Compare comments count
    }
}
