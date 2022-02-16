package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobject.pages.BaseFunc;
import tickets.HomePage;
import tickets.PersonalInfoPage;

import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private String from;
    private String to;
    private Map<String, String> personalInfo;

    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private PersonalInfoPage infoPage;

    @Given("airports {string} and {string}")
    public void set_airports(String from, String to){
        this.from = from;
        this.to = to;
    }

    @Given("personal info is:")
    public void set_personal_info(Map<String, String> params) {
        personalInfo = params;
    }

    @Given("home page opened")
    public void open_home_page(){
        baseFunc.openUrl("http://qaguru.lv:8089/tickets/");
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports(){
        homePage.selectAirports(from, to);
    }

    @When("pressing GoGoGo button")
    public void press_go_button() {
        homePage.pressGoBtn();
        infoPage = new PersonalInfoPage(baseFunc);
    }

    @When("we are filling in personal info")
    public void fill_personal_info_form() {

    }

    @Then("selected airports appears")
    public void check_selected_airports() {
        List<String> selectedAirports = infoPage.getSelectedAirports();
        Assertions.assertEquals(from, selectedAirports.get(0), "Wrong ...from");
        Assertions.assertEquals(to, selectedAirports.get(1), "Wrong .... to");
    }
}
