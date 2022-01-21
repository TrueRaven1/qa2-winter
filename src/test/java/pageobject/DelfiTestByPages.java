package pageobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageobject.model.Article;
import pageobject.pages.ArticlePage;
import pageobject.pages.BaseFunc;
import pageobject.pages.CommentPage;
import pageobject.pages.HomePage;

import java.util.List;

public class DelfiTestByPages {
    private final String HOME_PAGE_URL = "delfi.lv";
    private int articleId = (1);
    private final BaseFunc baseFunc = new BaseFunc();

    @Test
    public void titlesCheck() {
        baseFunc.openUrl(HOME_PAGE_URL);
        HomePage homePage = new HomePage(baseFunc);

        List<WebElement> titles = homePage.getTitlesOnDelfi();
        for (WebElement title : titles)
            if (!title.getText().isEmpty()) {
                System.out.println(title.getText());
            }
        System.out.println("--------Printed all titles------------");

        homePage.acceptCookies();
        Article article = homePage.getArticleByIdDelfi(articleId);
        String articleTitleOnHomePage = article.getTitle();
        System.out.println(articleTitleOnHomePage);
        int commentCountOnHomePage = article.getCommentsCount();
        System.out.println(commentCountOnHomePage);

        homePage.openArticleByIdDelfi(articleId);
        ArticlePage articlePage = new ArticlePage(baseFunc);

        String titleTextInArticle = articlePage.getTitleInArticleDelfi();
        System.out.println(titleTextInArticle);
        int commentCountOnArticlePage = articlePage.getCommentsCountInArticleDelfi();
        System.out.println(commentCountOnArticlePage);
        Assertions.assertTrue(articleTitleOnHomePage.startsWith(titleTextInArticle), "Titles are not the same");
        Assertions.assertEquals(commentCountOnHomePage, commentCountOnArticlePage, "Comments count in article page is different");

        articlePage.openCommentPageByLocator();
        CommentPage commentPage = new CommentPage(baseFunc);
        if (commentPage.getTitleInCommentPageDelfi() != null) {
            String titleTextInComments = commentPage.getTitleInCommentPageDelfi();
            System.out.println(titleTextInComments);
            Assertions.assertTrue(articleTitleOnHomePage.startsWith(titleTextInComments), "Titles are not the same on comment page");
            int commentCountOnCommentPage = commentPage.getCommentCountOnCommentPageDelfi();
            System.out.println(commentCountOnCommentPage);
            Assertions.assertEquals(commentCountOnHomePage, commentCountOnCommentPage);
        }
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}



