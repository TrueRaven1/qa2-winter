package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.RandomStringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation {
    private int id;
    private String name;
    private String surname;

    @JsonProperty("afrom")
    private String from;

    @JsonProperty("ato")
    private String to;

    @JsonProperty("bugs")
    private int bagCount;

    private String discount;
    private int children;

    @JsonProperty("flight")
    private int flightDay;


    private String fullFlightDay;

    @JsonProperty("adults")
    private int adultCount;

    private int seat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("random")) {
            this.name = RandomStringUtils.randomAlphabetic(15);
        } else {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getBagCount() {
        return bagCount;
    }

    public void setBagCount(int bagCount) {
        this.bagCount = bagCount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getFlightDay() {
        return flightDay;
    }

    public void setFlightDay(int flightDay) {
        this.flightDay = flightDay;
    }

    public String getFullFlightDay() {
        return fullFlightDay;
    }

    public void setFullFlightDay(String fullFlightDay) {
        this.fullFlightDay = fullFlightDay;
        this.flightDay = Integer.parseInt(fullFlightDay.split("-")[0]);
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
