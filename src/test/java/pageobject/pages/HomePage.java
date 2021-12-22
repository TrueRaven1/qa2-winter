package pageobject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.model.Article;

import java.util.List;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE_TITLE_DELFI = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private By ARTICLE = By.tagName("article");
    private By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_COOKIES_BTN);
    }

    public List<WebElement> getTitlesOnDelfi() {

        return baseFunc.findElements(ARTICLE_TITLE_DELFI);

    }

    public String getTitleOnDelfi(int id) {
        return baseFunc.getText(ARTICLE_TITLE_DELFI, id);
    }

    public ArticlePage openArticleByIdDelfi(int id) {
        WebElement articleToClick = baseFunc.findElements(ARTICLE_TITLE_DELFI).get(id);
        baseFunc.clickByWebElement(articleToClick);
        return new ArticlePage(baseFunc);
    }

    public Article getArticleById(int articleNr) {
        List<WebElement> articlesElements = baseFunc.findElements(ARTICLE);
        Assertions.assertFalse(articlesElements.isEmpty(), "There are no articles!");

        WebElement currentArticle = articlesElements.get(articleNr - 1);
        return mapArticle(currentArticle);
    }

    // WebeElement -> Article
    private Article mapArticle(WebElement we) {
        Article article = new Article();

        List<WebElement> counters = baseFunc.findElements(we, COMMENTS_COUNT);
        Assertions.assertTrue(counters.size() <= 1, "There is more than 1 counter!");

        if (counters.isEmpty()) {
            article.setCommentsCount(0);
        } else {
//            WebElement counter = counters.get(0); // -> (36) :: WebElement
            article.setCommentsCount(counters.get(0));
        }

        return article;
    }
}