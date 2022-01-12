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
import java.util.List;


public class FirstDelfiTest {
    private WebDriver browser;
    private final String HOME_PAGE_URL = "http://delfi.lv";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ADVERTISING_CLOSE = By.xpath(".//div[@class = 'Adform-closeButton']");
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_TITLE_IN_ARTICLE = By.xpath(".//h1[@class='text-size-22 text-size-md-30 d-inline']");
    private final By COMMENT_COUNT_IN_ARTICLE = By.xpath(".//a[contains(@class , 'text-size-19')]");
    private final By ARTICLE_TITLE_IN_COMMENTS = By.xpath(".//h1[@class= 'article-title']");

    @Test
    public void titleCheck() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();

        browser.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        browser.switchTo().frame("frontTarget");
        wait.until(ExpectedConditions.elementToBeClickable(ADVERTISING_CLOSE));
        browser.findElement(ADVERTISING_CLOSE).click();
        browser.switchTo().defaultContent();

        List<WebElement> titles = browser.findElements(ARTICLE_TITLE);
        System.out.println("Title text from main page:" + " " + titles.get(0).getText());
        String titleText = titles.get(0).getText();
        //Thread.sleep used because Frame not closed momentarily, and it head time to receive click.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(ARTICLE_TITLE));
        browser.findElements(ARTICLE_TITLE).get(0).click();
        String titleTextInArticle = browser.findElement(ARTICLE_TITLE_IN_ARTICLE).getText();
        System.out.println("Title text from article page:" + " " + titleTextInArticle);
        Assertions.assertTrue(titleText.startsWith(titleTextInArticle), "Incorrect title");

        List<WebElement> dynamicElement = browser.findElements(COMMENT_COUNT_IN_ARTICLE);
        if (dynamicElement.size() != 0) {
            browser.findElement(COMMENT_COUNT_IN_ARTICLE).click();
            String titleTextInComments = browser.findElement(ARTICLE_TITLE_IN_COMMENTS).getText();
            System.out.println("Title text from comment page:" + " " + titleTextInComments);
            Assertions.assertTrue(titleText.startsWith(titleTextInComments), "Incorrect text");
        } else {
            System.out.println("No comments in this article");
        }
    }

    @Test
    public void titlesToConsole() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> titles = browser.findElements(ARTICLE_TITLE);

        int i = 0;
        for (WebElement element : titles) {
            if (!element.getText().isEmpty()) {
                System.out.println("Title " + i + ":" + element.getText());
                     }
                i++;
        }
    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}
