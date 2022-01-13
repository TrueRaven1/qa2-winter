package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Coord;

import java.util.Map;

public class WeatherStepDefs {
    private String city;
    private String country;
    private String base;

    @Given("city name is {string}")
    public void city_name_is(String city) {
        this.city = city;
    }

    @And("country is {string}")
    public void country_name(String country) {
        this.country = country;
    }

    @When("we are requesting weather data")
    public void requesting_weather_data() {
    }

    @Then("coord are:")
    public void coord_are(Map<String,Double> coord){
    }

    @And("weather info are:")
    public void weather_info_are(Map<String,String> weather){

    }

    @And("base is {string}")
    public void base_is(String base){
        this.base = base;
    }
}
