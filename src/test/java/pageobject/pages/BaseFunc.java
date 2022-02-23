package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BaseFunc {
    private WebDriver browser;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        wait = new WebDriverWait(browser, Duration.ofSeconds(10));
    }

    public void openUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        browser.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findElements(WebElement parent, By child) {
        return parent.findElements(child);
    }

    public void clickByWebElement(WebElement we) {
        wait.until(ExpectedConditions.elementToBeClickable(we)).click();
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public String getText(By locator, int id) {
        List<WebElement> elements = findElements(locator);
        return elements.get(id).getText();
    }

    public void closeBrowser() {
        browser.close();
    }

    public void select(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    public void selectByVisibleText(By locator, String text){
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(text);
    }

    public void type(By locator, String text) {
        WebElement inputField = findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void type(By locator, int text) {
        type(locator, String.valueOf(text));
    }
}