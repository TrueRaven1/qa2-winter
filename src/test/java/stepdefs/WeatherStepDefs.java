package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Coord;
import model.Weather;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

import static java.lang.Long.*;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;
    private String country;
    private String base;
    private int visibility;
    private int dt;
    private int id;
    private String name;
    private int cod;


    @Given("city id is {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void requesting_weather_data() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("coord are:")
    public void check_coord(Map<String, Double> params) {
        assertEquals(params.get("lon"), response.getCoord().getLon(), "Wrong Lon!");
        assertEquals(params.get("lat"), response.getCoord().getLat(), "Wrong Lan!");
    }

    @Then("weather info are:")
    public void check_weather(Map<String, String> params) {
        Weather weather = response.getWeathers().get(0);
        assertEquals(parseLong(params.get("id")), weather.getId(), "Wrong Weather ID!");
        assertEquals(params.get("main"), weather.getMain(), "Wrong Weather Main!");
        assertEquals(params.get("description"), weather.getDescription(), "Wrong Weather Description!");
        assertEquals(params.get("icon"), weather.getIcon(), "Wrong Weather Icon!");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        assertEquals(base, response.getBase(), "Wrong Base!");
    }

    @Then("main info is:")
    public void check_main(Map<String, Double> main) {

    }

    @Then("visibility are: {int}")
    public void check_visibility(int visibility) {
    }

    @Then("wind info is:")
    public void check_wind(Map<String, Double> wind) {

    }

    @Then("clouds info is:")
    public void check_clouds(Map<String, Double> clouds) {

    }

    @Then("dt are: {int}")
    public void check_dt(int dt) {
    }

    @Then("system info is:")
    public void check_system(Map<String, String> system) {

    }

    @Then("id are: {int}")
    public void check_id(int id) {
    }

    @Then("name are: {string}")
    public void check_name(String name) {
    }

    @Then("cod are: {int}")
    public void check_cod(int cod) {
    }
}
