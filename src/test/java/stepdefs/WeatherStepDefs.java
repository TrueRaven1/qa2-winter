package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.bs.I;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import model.Coord;
import model.Weather;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

import static java.lang.Integer.*;
import static java.lang.Long.*;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

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
    public void check_main(Map<String, Float> params) {
        assertEquals(params.get("temp"), response.getMain().getTemp(), "Wrong Main Temp");
        assertEquals(params.get("pressure"), response.getMain().getPressure(), "Wrong Main Preasure");
        assertEquals(params.get("humidity"), response.getMain().getHumidity(), "Wrong Main Humidity");
        assertEquals(params.get("min_temp"), response.getMain().getTemp_min(), "Wrong Main Min temp");
        assertEquals(params.get("max_temp"), response.getMain().getTemp_max(), "Wrong Main Max Temp");
    }

    @Then("visibility are: {int}")
    public void check_visibility(int visibility) {
        assertEquals(visibility, response.getVisibility(), "Wrong Visibility!");
    }

    @Then("wind info is:")
    public void check_wind(Map<String, Float> params) {
        assertEquals(params.get("speed"), response.getWind().getSpeed(), "Wrong Wind Speed!");
        assertEquals(params.get("deg"), response.getWind().getDeg(), "Wrong Wind Deg!");
    }

    @Then("clouds info is:")
    public void check_clouds(Map<String, Double> params) {
        assertEquals(params.get("all"), response.getClouds().getAll(), "Wrong Clouds All!");
    }

    @Then("dt are: {int}")
    public void check_dt(int dt) {
        assertEquals(dt, response.getDt(), "Wrong Dt!");
    }

    @Then("system info is:")
    public void check_system(Map<String, String> params) {
        assertEquals(parseInt(params.get("type")), response.getSys().getType(), "Wrong System Type!");
        assertEquals(parseInt(params.get("id")), response.getSys().getId(), "Wrong System Id!");
        assertEquals(Float.parseFloat(params.get("message")), response.getSys().getMessage(), "Wrong System Message!");
        assertEquals(params.get("country"), response.getSys().getCountry(), "Wrong System Country!");
        assertEquals(parseInt(params.get("sunrise")), response.getSys().getSunrise(), "Wrong System Sunrise!");
        assertEquals(parseInt(params.get("sunset")), response.getSys().getSunset(), "Wrong System Sunset!");
    }

    @Then("id are: {int}")
    public void check_id(int id) {
        assertEquals(id, response.getId(), "Wrong Id!");
    }

    @Then("name are: {string}")
    public void check_name(String name) {
        assertEquals(name, response.getName(), "Wrong Name!");
    }

    @Then("cod are: {int}")
    public void check_cod(int cod) {
        assertEquals(cod, response.getCod(), "Wrong Cod!");
    }
}
