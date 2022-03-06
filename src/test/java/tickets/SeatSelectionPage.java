package tickets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;

public class SeatSelectionPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By SEAT_NR = By.xpath(".//div[@class = 'line']");
    private final By BOOK_BTN = By.id("book3");

    private BaseFunc baseFunc;

    public SeatSelectionPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSeat(int seatNr) {
        baseFunc.waitUntilElementsCountAtLeast(SEAT, 10);
        for (WebElement we : baseFunc.findElements(SEAT)) {
            if (Integer.parseInt(we.getText()) == seatNr) {
                we.click();
                break;
            }
        }
    }

    public int getSelectedSeatNr() {
        return Integer.parseInt(baseFunc.findElement(SEAT_NR).getText().split(": ")[1]);
    }

    public void book() {
        baseFunc.click(BOOK_BTN);
    }
}
