package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePage {
    private BaseFunc baseFunc;
    private final By ARTICLE_TITLE_IN_ARTICLE_DELFI = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    private final By COMMENT_COUNT_IN_ARTICLE_DELFI = By.xpath(".//a[contains(@class , 'text-size-19')]");
    private final By ARTICLE_TITLE_IN_ARTICLE_TVNET = By.xpath(".//h1 [contains (@class, 'headline')]");
    private final By COMMENT_COUNT_IN_ARTICLE_TVNET = By.xpath(".//span [contains (@class, 'count')]");

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleInArticleDelfi() {
        return baseFunc.getText(ARTICLE_TITLE_IN_ARTICLE_DELFI);
    }

    int commentsCountInArticleDelfi = 0;

    public int getCommentsCountInArticleDelfi() {

        if (!baseFunc.findElements(COMMENT_COUNT_IN_ARTICLE_DELFI).isEmpty()) {
            String commentsToParseInArticle = baseFunc.findElement(COMMENT_COUNT_IN_ARTICLE_DELFI).getText();
            commentsToParseInArticle = commentsToParseInArticle.substring(1, commentsToParseInArticle.length() - 1);
            commentsCountInArticleDelfi = Integer.parseInt(commentsToParseInArticle);
        }
        return commentsCountInArticleDelfi;
    }

    public Object openCommentPageByLocator() {
        List<WebElement> dynamicElement = baseFunc.findElements(COMMENT_COUNT_IN_ARTICLE_DELFI);
        if (dynamicElement.size() != 0) {
            baseFunc.click(COMMENT_COUNT_IN_ARTICLE_DELFI);
            return new CommentPage(baseFunc);
        } else {
            System.out.println("No comments in this article");
        }
        return baseFunc;
    }

    public String getTitleInArticleTVNET() {
        return baseFunc.getText(ARTICLE_TITLE_IN_ARTICLE_TVNET);
    }

    int commentsCountInArticleTVNET = 0;

    public int getCommentCountInArticleTVNET() {

        if (!baseFunc.findElements(COMMENT_COUNT_IN_ARTICLE_TVNET).isEmpty()) {
            String commentsToParseInArticle = baseFunc.findElement(COMMENT_COUNT_IN_ARTICLE_TVNET).getText();
            commentsCountInArticleTVNET = Integer.parseInt(commentsToParseInArticle);
        }
        return commentsCountInArticleTVNET;
    }

    public Object openCommentPageTVNET() {
        List<WebElement> dynamicElement = baseFunc.findElements(COMMENT_COUNT_IN_ARTICLE_TVNET);
        if (dynamicElement.size() != 0) {
            baseFunc.click(COMMENT_COUNT_IN_ARTICLE_TVNET);
            return new CommentPage(baseFunc);
        } else {
            System.out.println("No comments in this article");
            return null;
        }
    }

}

