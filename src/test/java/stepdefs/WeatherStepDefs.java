package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Coord;
import model.WeatherResponse;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
//    private String city;
//    private String country;
//    private String base;
//    private int visibility;
//    private int dt;
//    private int id;
//    private String name;
//    private int cod;


//    @Given("city name is {string}")
//    public void city_name_is(String city) {
//        this.city = city;
//    }
//
//    @And("country is {string}")
//    public void country_name(String country) {
//        this.country = country;
//    }

    @When("we are requesting weather data")
    public void requesting_weather_data() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        WeatherResponse response =requester.requestWeather(524901);

        System.out.println(response.getCoord().getLat());
    }

//    @Then("coord are:")
//    public void coord_are(Map<String, Double> coord) {
//    }
//
//    @And("weather info are:")
//    public void weather_info_are(Map<String, String> weather) {
//
//    }
//
//    @And("base is {string}")
//    public void base_is(String base) {
//        this.base = base;
//    }
//
//    @And("main info is:")
//    public void main_info_is(Map<String, Double> main) {
//
//    }
//
//    @And("visibility are: {int}")
//    public void visibility_are(int visibility) {
//        this.visibility = visibility;
//    }
//
//    @And("wind info is:")
//    public void wind_info_is(Map<String, Double> wind) {
//
//    }
//
//    @And("clouds info is:")
//    public void clouds_info_is(Map<String, Double> clouds) {
//
//    }
//
//    @And("dt are: {int}")
//    public void dt_are(int dt) {
//        this.dt = dt;
//    }
//
//    @And("system info is:")
//    public void system_info_is(Map<String, String> system) {
//
//    }
//
//    @And("id are: {int}")
//    public void id_are(int id) {
//        this.id = id;
//    }
//
//    @And("name are: {string}")
//    public void name_are(String name) {
//        this.name = name;
//    }
//
//    @And("cod are: {int}")
//    public void cod_are(int cod) {
//        this.cod = cod;
//    }
//
}
