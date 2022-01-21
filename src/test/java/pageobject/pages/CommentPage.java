package pageobject.pages;

import org.openqa.selenium.By;

public class CommentPage {
    private BaseFunc baseFunc;
    private final By ARTICLE_TITLE_IN_COMMENTS_DELFI = By.xpath(".//h1[@class= 'article-title']");
    private final By COMMENTS_COUNT_COMMENT_PAGE_DELFI = By.xpath(".//div[@class = 'comment-content']");
    private final By ARTICLE_TITLE_IN_COMMENTS_TVNET = By.xpath(".//h1[@class= 'article-headline']");
    private final By COMMENTS_COUNT_COMMENT_PAGE_TVNET = By.xpath(".//li[@class = 'article-comment']");

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleInCommentPageDelfi() {
        if (!baseFunc.findElements(ARTICLE_TITLE_IN_COMMENTS_DELFI).isEmpty()) {
            return baseFunc.getText(ARTICLE_TITLE_IN_COMMENTS_DELFI);
        }
        return null;
    }

    public int getCommentCountOnCommentPageDelfi() {
        return baseFunc.findElements(COMMENTS_COUNT_COMMENT_PAGE_DELFI).size();
    }

    public String getTitleInCommentPageTVNET() {
        if (!baseFunc.findElements(ARTICLE_TITLE_IN_COMMENTS_TVNET).isEmpty()) {
            return baseFunc.getText(ARTICLE_TITLE_IN_COMMENTS_TVNET);
        }
        return null;
    }

    public int getCommentsCountOnCommentPage() {
        return baseFunc.findElements(COMMENTS_COUNT_COMMENT_PAGE_TVNET).size();
    }

}
