package tickets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonalInfoPage {
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
        List<WebElement> selectedAirports = baseFunc.findElements(SELECTED_AIRPORT);

        List<String> result = new ArrayList<>();

        for (WebElement we: selectedAirports) {
            result.add(we.getText());
        }

        return result;
    }

    public Map<String, String> fillInPersonalInfoForm(Map<String, String> params) {
        baseFunc.type(NAME_INPUT, params.get("first_name"));
        baseFunc.type(SURNAME_INPUT, params.get("last_name"));
        baseFunc.type(DISCOUNT_INPUT, params.get("discount"));
        baseFunc.type(ADULTS_COUNT_INPUT, Integer.parseInt(params.get("adults")));
        baseFunc.type(CHILDREN_COUNT_INPUT, Integer.parseInt(params.get("kids")));
        baseFunc.type(BUGS_COUNT_INPUT, Integer.parseInt(params.get("bags")));
        baseFunc.selectByVisibleText(FLIGHT_SELECT, params.get("flight"));
        return params;
    }

    public void submitForm() {
        baseFunc.click(GET_PRISE_BTN);
    }

    public String getPassengerName() {
        return baseFunc.findElement(PASSENGER_NAME).getText().replace("!", "");
    }

    public void book() {
        baseFunc.click(BOOK_BTN);
    }
}
