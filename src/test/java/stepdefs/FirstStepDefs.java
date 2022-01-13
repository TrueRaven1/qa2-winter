package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstStepDefs {
    private String text;

    @Given("text: {string}")
    public void set_text(String text) {
        this.text = text;
    }

    @When("text is printed")
    public void print_text() {
        System.out.println(text);
    }

    @Then("print: {string}")
    public void print_additional_text(String text) {
        System.out.println(text);
    }
}
