package pageobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageobject.pages.ArticlePage;
import pageobject.pages.BaseFunc;
import pageobject.pages.CommentPage;
import pageobject.pages.HomePage;

import java.util.List;

public class DelfiTestByPages {
    private final String HOME_PAGE_URL = "delfi.lv";
    private int articleId = 0;
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
        String titleText = homePage.getTitleOnDelfi(articleId);
        System.out.println(titleText);
        homePage.openArticleByIdDelfi(articleId);
        ArticlePage articlePage = new ArticlePage(baseFunc);
        String titleTextInArticle = articlePage.getTitleInArticleDelfi();
        System.out.println(titleTextInArticle);
        Assertions.assertTrue(titleText.startsWith(titleTextInArticle), "Titles are not the same");
        articlePage.openCommentPageByLocator();
        CommentPage commentPage = new CommentPage(baseFunc);
        if (commentPage.getTitleInCommentPageDelfi() != null) {
            String titleTextInComments = commentPage.getTitleInCommentPageDelfi();
            System.out.println(titleTextInComments);
            Assertions.assertTrue(titleText.startsWith(titleTextInComments), "Titles are not the same on comment page");

        }
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}



