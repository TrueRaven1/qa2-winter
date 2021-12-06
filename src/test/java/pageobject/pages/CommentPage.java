package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommentPage {
    private BaseFunc baseFunc;
    private final By ARTICLE_TITLE_IN_COMMENTS_Delfi = By.xpath(".//h1[@class= 'article-title']");

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleInCommentPageDelfi() {
        List<WebElement> dynamicElement = baseFunc.findElements(ARTICLE_TITLE_IN_COMMENTS_Delfi);
        if (dynamicElement.size() != 0) {
            return baseFunc.getText(ARTICLE_TITLE_IN_COMMENTS_Delfi);
        }
        return null;
    }
}