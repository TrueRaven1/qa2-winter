package tickets;

import model.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;

import java.util.ArrayList;
import java.util.List;

public class PersonalInfoPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By SELECTED_AIRPORT = By.xpath(".//span[@class = 'bTxt']");
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULTS_COUNT_INPUT = By.id("adults");
    private final By CHILDREN_COUNT_INPUT = By.id("children");
    private final By BUGS_COUNT_INPUT = By.id("bugs");
    private final By FLIGHT_SELECT = By.id("flight");
    private final By GET_PRISE_BTN = By.xpath(".//span [contains (@onclick, 'setLang')]");
    private final By PASSENGER_NAME = By.xpath(".//div[@id='response']/span");
    private final By BOOK_BTN = By.id("book2");
    private BaseFunc baseFunc;

    public PersonalInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<String> getSelectedAirports() {
        LOGGER.info("Getting selected airports");
        List<WebElement> selectedAirports = baseFunc.findElements(SELECTED_AIRPORT);

        List<String> result = new ArrayList<>();

        for (WebElement we: selectedAirports) {
            result.add(we.getText());
        }

        return result;
    }

    public void fillInPersonalInfoForm(Reservation reservation) {
        LOGGER.info("Filling in registration form");
        baseFunc.type(NAME_INPUT, reservation.getName());
        baseFunc.type(SURNAME_INPUT, reservation.getSurname());
        baseFunc.type(DISCOUNT_INPUT, reservation.getDiscount());
        baseFunc.type(ADULTS_COUNT_INPUT, reservation.getAdultCount());
        baseFunc.type(CHILDREN_COUNT_INPUT, reservation.getChildren());
        baseFunc.type(BUGS_COUNT_INPUT, reservation.getBagCount());
        baseFunc.selectByVisibleText(FLIGHT_SELECT, reservation.getFullFlightDay());

    }

    public void submitForm() {
        LOGGER.info("Submitting reservation form");
        baseFunc.click(GET_PRISE_BTN);
    }

    public String getPassengerName() {
        LOGGER.info("Getting passenger name and removing sign ! ");
        return baseFunc.findElement(PASSENGER_NAME).getText().replace("!", "");
    }

    public void book() {
        LOGGER.info("Clicking by Book button");
        baseFunc.click(BOOK_BTN);
    }
}
