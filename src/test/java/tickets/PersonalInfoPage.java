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

    public void fillInPersonalInfoForm(Map<String, String> params) {
        baseFunc.type(NAME_INPUT, params.get("first_name"));
        //...
        baseFunc.selectByVisibleText(FLIGHT_SELECT, params.get("flight"));
    }
}
