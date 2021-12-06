package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePage {
    private final By ARTICLE_TITLE_IN_ARTICLE_DELFI = By.xpath(".//h1[@class='text-size-22 text-size-md-30 d-inline']");
    private BaseFunc baseFunc;
    private final By COMMENT_COUNT_IN_ARTICLE = By.xpath(".//a[contains(@class , 'text-size-19')]");

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleInArticleDelfi() {
        return baseFunc.getText(ARTICLE_TITLE_IN_ARTICLE_DELFI);
    }

//    List<WebElement> dynamicElement = baseFunc.findElements(COMMENT_COUNT_IN_ARTICLE);

    public CommentPage openCommentPageByLocator(int id) {
        List<WebElement> dynamicElement = baseFunc.findElements(COMMENT_COUNT_IN_ARTICLE);
        if (dynamicElement.size() != 0) {
            baseFunc.click(COMMENT_COUNT_IN_ARTICLE);
            return new CommentPage(baseFunc);
        } else {
            System.out.println("No comments in this article");
        }
        return null;
    }
}

