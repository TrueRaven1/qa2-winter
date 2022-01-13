package pageobject.pages;

import org.openqa.selenium.By;

public class CommentPage {
    private BaseFunc baseFunc;
    private final By ARTICLE_TITLE_IN_COMMENTS_Delfi = By.xpath(".//h1[@class= 'article-title']");

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleInCommentPageDelfi() {
        if (!baseFunc.findElements(ARTICLE_TITLE_IN_COMMENTS_Delfi).isEmpty()) {
            return baseFunc.getText(ARTICLE_TITLE_IN_COMMENTS_Delfi);
        }
        return null;
        }

    }
