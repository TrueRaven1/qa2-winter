package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunc {
    private WebDriver browser;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    public void openUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        browser.get(url);
    }

    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    public List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }

    public WebElement findElement(By locator) {
        return browser.findElement(locator);
    }

    public List<WebElement> findElements(WebElement parent, By child) {
        return parent.findElements(child);
    }

//    public void ClickByWebElements (List<WebElement> webElements) {
//        WebDriverWait wait = new WebDriverWait(browser.findElements(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(webElements)).click();
//    }

    public void clickByWebElement(WebElement we) {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(we)).click();
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }


//    public String getText(WebElement parent, By child) {
//
//    }

    public String getText(By locator, int id) {
        List<WebElement> elements = findElements(locator);
        return elements.get(id).getText();

    }

    public void closeBrowser() {
        browser.close();
    }

}