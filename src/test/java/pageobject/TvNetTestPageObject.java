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
    private int ArticleId = (4);
    private final BaseFunc baseFunc = new BaseFunc();

    @Test
    public void titlesAndCommentsCheck() {

        baseFunc.openUrl(tvNetUrl);
        HomePage homePage = new HomePage(baseFunc);

        homePage.acceptCookies();
        Article article = homePage.getArticleById(ArticleId);
        String titleTextOnHomePage = article.getTitle();
        System.out.println(article.getTitle());
        int commentCountOnHomePage = article.getCommentsCount();
        System.out.println(article.getCommentsCount());

        homePage.openArticleByIdTVNET(ArticleId);
        ArticlePage articlePage = new ArticlePage(baseFunc);

        String titleInArticle = articlePage.getTitleInArticleTVNET();
        System.out.println(titleInArticle);
        int commentCountInArticle = articlePage.getCommentCountInArticleTVNET();
        System.out.println(commentCountInArticle);
        Assertions.assertTrue(titleTextOnHomePage.startsWith(titleInArticle), "Title on article page is different");
        Assertions.assertEquals(commentCountOnHomePage, commentCountInArticle, "Comments count in article page is different");

        articlePage.openCommentPageTVNET();
        CommentPage commentPage = new CommentPage(baseFunc);

        if (commentPage.getTitleInCommentPageTVNET() != null) {
            String titleTextInCommentPage = commentPage.getTitleInCommentPageTVNET();
            System.out.println(titleTextInCommentPage);
            Assertions.assertTrue(titleTextOnHomePage.startsWith(titleTextInCommentPage), "Title on comment page is different");
        }
        int commentsCountInCommentPage = commentPage.getCommentsCountOnCommentPage();
        System.out.println(commentsCountInCommentPage);

        Assertions.assertEquals(commentCountOnHomePage, commentsCountInCommentPage, "Comments count on comment page is different");
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
