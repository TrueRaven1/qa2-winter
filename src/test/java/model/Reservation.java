package model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
        this.name = name;
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
