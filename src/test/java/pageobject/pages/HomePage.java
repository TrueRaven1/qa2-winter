package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private BaseFunc baseFunc;
    private final By ARTICLE_TITLE_DELFI = By.xpath(".//h1[contains(@class, 'headline__title')]");

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
}