package homeworks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TvNetHomeWork {
    private final String HOME_PAGE_URL = "http://tvnet.lv";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By ARTICLE_COMMENT_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");
    private final By ARTICLE_TITLE_IN_ARTICLE = By.xpath(".//h1[contains(@class, 'headline')]");
    private final By COMMENT_COUNT_IN_ARTICLE = By.xpath(".//span[contains(@class, 'item--count')]");
    private WebDriver browser;

    @Test
    public void titlesAndCommentsCheck() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();

        browser.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        WebElement currentArticle = browser.findElements(ARTICLE_TITLE).get(4);
        String titleText = currentArticle.getText();
        System.out.println(titleText);
        wait.until(ExpectedConditions.elementToBeClickable(ARTICLE_TITLE));

        int commentCount = 0;
        if (!currentArticle.findElements(ARTICLE_COMMENT_COUNT).isEmpty()) {
            String commentsToParse = currentArticle.findElement(ARTICLE_COMMENT_COUNT).getText();
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1);
            commentCount = Integer.parseInt(commentsToParse);
            System.out.println(commentCount);
        }

        currentArticle.click();

        String titleTextInArticle = browser.findElement(ARTICLE_TITLE_IN_ARTICLE).getText();
        System.out.println(titleTextInArticle);
        Assertions.assertTrue(titleText.startsWith(titleTextInArticle), "Incorrect title");

        int commentCountInArticle = 0;
        if (!browser.findElements(COMMENT_COUNT_IN_ARTICLE).isEmpty()) {
            String commentsToParseInArticle = browser.findElements(COMMENT_COUNT_IN_ARTICLE).get(0).getText();
            commentCountInArticle = Integer.parseInt(commentsToParseInArticle);
            System.out.println(commentCountInArticle);
        }
        Assertions.assertEquals(commentCount,commentCountInArticle, "Wrong comments count");

//        if (!browser.findElements(COMMENT_COUNT_IN_ARTICLE).isEmpty()){
//            browser.findElements(COMMENT_COUNT_IN_ARTICLE).get(0).click();
//        }

    }
    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}
