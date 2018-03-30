package com.example.marcgilbert.weatherappnovastone.api;


public enum City {

    LONDON("London"),
    PARIS("Paris");

    private String mValue;

    City(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }
}
