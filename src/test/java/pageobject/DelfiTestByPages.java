package pageobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.pages.ArticlePage;
import pageobject.pages.BaseFunc;
import pageobject.pages.CommentPage;
import pageobject.pages.HomePage;

public class DelfiTestByPages {
    private final String HOME_PAGE_URL = "delfi.lv";
    private int articleId = 7;

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
        String titleText = homePage.getTitleOnDelfi(articleId);
        //Print to console
        System.out.println(titleText);
        //Open 1rd article
        homePage.openArticleByIdDelfi(articleId);
        ArticlePage articlePage = new ArticlePage(baseFunc);
        //Get title
        String titleTextInArticle = articlePage.getTitleInArticleDelfi();
        //Print to console
        System.out.println(titleTextInArticle);
        //Compare titles
        Assertions.assertTrue(titleText.startsWith(titleTextInArticle),"Titles are not the same");
        //Go to comment page
        articlePage.openCommentPageByLocator(articleId);
        CommentPage commentPage = new CommentPage(baseFunc);
        //compare titles
        String titleTextInComments = commentPage.getTitleInCommentPageDelfi();
        System.out.println(titleTextInComments);
        Assertions.assertTrue(titleText.startsWith(titleTextInComments),"Titles are not the same");
        //// get to console all titles
        homePage.getTitlesOnDelfi();

        baseFunc.closeBrowser();
    }

    }



