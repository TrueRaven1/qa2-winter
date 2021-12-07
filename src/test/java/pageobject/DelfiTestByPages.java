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
    private int articleId = 3;
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void titlesCheck() {
        //Open browser window (maximize it)
//        BaseFunc baseFunc = new BaseFunc();
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
        Assertions.assertTrue(titleText.startsWith(titleTextInArticle), "Titles are not the same");
        //Go to comment page
        articlePage.openCommentPageByLocator(articleId);
        CommentPage commentPage = new CommentPage(baseFunc);
        //compare titles
        if (!commentPage.getTitleInCommentPageDelfi().startsWith(" no comments ")) {
            String titleTextInComments = commentPage.getTitleInCommentPageDelfi();
            System.out.println(titleTextInComments);
            Assertions.assertTrue(titleText.startsWith(titleTextInComments), "Titles are not the same on comment page");
        }
        System.out.println("--------Printing all titles------------");
        // get to console all titles
        List<WebElement> titles = homePage.getTitlesOnDelfi();

                int i = 0;
        for (WebElement element : titles) {
            System.out.println("Title " + i + ":" + element.getText());
            i++;
        }

//        int i = 0;
//        for (WebElement element : titles) {
//            String text = element.getText();
//            if (!text.isEmpty()) {
//                element.getText();
//            }
//            System.out.println("Title " + i + ":" + text);
//            i++;
//        }



//        for (int i = 0; i < titles.size(); i++){
//            if (titles.size() > i){
//                System.out.println(titles.get(i).getText());
//            }
//            System.out.println(titles.get(i).getText());

//            if (comments.size() > i) {
//                System.out.println(titles.get(i).getText() + " :: " + comments.get(i).getText());
//            } else {
//                System.out.println(titles.get(i).getText() + " ------ ");
//            }
//        }




    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}



