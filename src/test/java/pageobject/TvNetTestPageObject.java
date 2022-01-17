package pageobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.model.Article;
import pageobject.pages.ArticlePage;
import pageobject.pages.BaseFunc;
import pageobject.pages.CommentPage;
import pageobject.pages.HomePage;

public class TvNetTestPageObject {
    private final String tvNetUrl = "tvnet.lv";
    private int ArticleId = (3);
    private final BaseFunc baseFunc = new BaseFunc();

    @Test
    public void titlesAndCommentsCheck() {

        //Open browser window (maximize it)

        //Open home page
        baseFunc.openUrl(tvNetUrl);
        HomePage homePage = new HomePage(baseFunc);

        //Accept cookies
        homePage.acceptCookies();
        //Get 3rd article title and comments
        Article article = homePage.getArticleById(ArticleId);
        String titleTextOnHomePage = article.getTitle();
        System.out.println(article.getTitle());
        int commentCountOnHomePage = article.getCommentsCount();
        System.out.println(article.getCommentsCount());

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
        Assertions.assertTrue(titleTextOnHomePage.startsWith(titleInArticle), "Title on article page is different");
        //Compare comments count
        Assertions.assertEquals(commentCountOnHomePage, commentCountInArticle, "Comments count in article page is different");
        //Open comment page
        articlePage.openCommentPageTVNET();
        CommentPage commentPage = new CommentPage(baseFunc);

        //Get title
        String titleTextInCommentPage = commentPage.getTitleInCommentPageTVNET();
        System.out.println(titleTextInCommentPage);
        //Get comments count
        int commentsCountInCommentPage = commentPage.getCommentsCountOnCommentPage();
        System.out.println(commentsCountInCommentPage);
        //Compare titles
        Assertions.assertTrue(titleTextOnHomePage.startsWith(titleTextInCommentPage),"Title on comment page is different");
        //Compare comments count
        Assertions.assertEquals(commentCountOnHomePage, commentsCountInCommentPage, "Comments count on comment page is different");
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
