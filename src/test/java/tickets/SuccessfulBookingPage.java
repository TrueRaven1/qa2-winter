package tickets;

import org.openqa.selenium.By;
import pageobject.pages.BaseFunc;

public class SuccessfulBookingPage {
    private final String SUCCESS_MESSAGE_TXT = "Thank You for flying with us!";
    private final By SUCCESS_MESSAGE = By.xpath(".//div[@class = 'finalTxt']");

    private final BaseFunc baseFunc;

    public SuccessfulBookingPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean isSuccessMessagePresents() {
        if (baseFunc.findElement(SUCCESS_MESSAGE).getText().equals(SUCCESS_MESSAGE_TXT)) {
            return true;
        }
        else {
            return false;
        }
    }
}
