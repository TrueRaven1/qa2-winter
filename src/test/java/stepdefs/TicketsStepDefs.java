package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Reservation;
import org.junit.jupiter.api.Assertions;
import pageobject.pages.BaseFunc;
import requesters.ReservationsRequester;
import tickets.HomePage;
import tickets.PersonalInfoPage;
import tickets.SeatSelectionPage;
import tickets.SuccessfulBookingPage;

import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private String from;
    private String to;
    private int seatNr;
    private Map<String, String> personalInfo;
    private List<Reservation> response;

    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private PersonalInfoPage infoPage;
    private SeatSelectionPage seatSelectionPage;
    private SuccessfulBookingPage successfulBookingPage;

    @Given("airports {string} and {string}")
    public void set_airports(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Given("seat number is {int}")
    public void set_seat_nr(int seatNr) {
        this.seatNr = seatNr;
    }

    @Given("personal info is:")
    public void set_personal_info(Map<String, String> params) {


        if (params.get("first_name").equals("random")) {

        }

        personalInfo = params;
    }

    @Given("home page opened")
    public void open_home_page() {
        baseFunc.openUrl("http://qaguru.lv:8089/tickets/");
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(from, to);
    }

    @When("pressing GoGoGo button")
    public void press_go_button() {
        homePage.pressGoBtn();
        infoPage = new PersonalInfoPage(baseFunc);
    }

    @When("we are filling in personal info")
    public void fill_personal_info_form() {
        infoPage.fillInPersonalInfoForm(personalInfo);
    }

    @When("we are submitting form")
    public void submit_personal_info_form() {
        infoPage.submitForm();
    }

    @When("we are pressing Book btn")
    public void press_book_btn() {
        infoPage.book();
        seatSelectionPage = new SeatSelectionPage(baseFunc);
    }

    @When("selecting seat")
    public void select_seat() {
        seatSelectionPage.selectSeat(seatNr);
    }

    @When("we are making final book")
    public void final_book() {
        seatSelectionPage.book();
        successfulBookingPage = new SuccessfulBookingPage(baseFunc);
    }

    @When("we are requesting all reservations")
    public void request_reservations() throws JsonProcessingException {
        ReservationsRequester requester = new ReservationsRequester();
        response = requester.getReservations();
    }

    @Then("selected airports appears")
    public void check_selected_airports() {
        List<String> selectedAirports = infoPage.getSelectedAirports();
        Assertions.assertEquals(from, selectedAirports.get(0), "Wrong ...from");
        Assertions.assertEquals(to, selectedAirports.get(1), "Wrong .... to");
    }

    @Then("passenger name is show")
    public void check_passenger_name() {
        Assertions.assertEquals(personalInfo.get("first_name"), infoPage.getPassengerName(), "Wrong ...");
    }

    @Then("correct seat selected")
    public void check_seat_nr() {
        Assertions.assertEquals(seatNr, seatSelectionPage.getSelectedSeatNr(), "Wrong seat nr");
    }

    @Then("successful message appears")
    public void check_success_msg() {
        Assertions.assertTrue(successfulBookingPage.isSuccessMessagePresents(), "There is no success message");
    }

    @Then("reservation exist in the list with correct data")
    public void check_current_reservation() {

    }
}
