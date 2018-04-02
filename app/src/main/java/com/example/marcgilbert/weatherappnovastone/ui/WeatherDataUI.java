package com.example.marcgilbert.weatherappnovastone.ui;

public class WeatherDataUI {

    private String mName;
    private String mTempInCelcius;
    private String mWindInKmPerHr;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getTempInCelcius() {
        return mTempInCelcius;
    }

    public void setTempInCelcius(String tempInCelcius) {
        mTempInCelcius = tempInCelcius;
    }

    public String getWindInKmPerHr() {
        return mWindInKmPerHr;
    }

    public void setWindInKmPerHr(String windInKmPerHr) {
        mWindInKmPerHr = windInKmPerHr;
    }
}
