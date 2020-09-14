package org.launchcode.movingduringthepandemic.models;

public class CovidData {

    private String state;
    private Integer positiveIncrease;
    private Integer positive;
    private Integer date;

    public CovidData(String state, Integer positiveIncrease, Integer positive, Integer date) {
        this.state = state;
        this.positiveIncrease = positiveIncrease;
        this.positive = positive;
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPositiveIncrease() {
        return positiveIncrease;
    }

    public void setPositiveIncrease(Integer positiveIncrease) {
        this.positiveIncrease = positiveIncrease;
    }

    public Integer getPositive() {
        return positive;
    }

    public void setPositive(Integer positive) {
        this.positive = positive;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
