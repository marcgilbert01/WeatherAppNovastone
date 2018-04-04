package com.example.marcgilbert.weatherappnovastone.ui;

import java.io.Serializable;

public class WeatherDataUI implements Serializable{

    private String mName;
    private String mTempInCelcius;
    private String mMinTemp;
    private String mMaxTemp;
    private String mWindInKmPerHr;
    private String mWeatherIconUrl;
    private String mWeatherTitle;
    private String mWeatherDescription;

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

    public String getMinTemp() {
        return mMinTemp;
    }

    public void setMinTemp(String minTemp) {
        mMinTemp = minTemp;
    }

    public String getMaxTemp() {
        return mMaxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        mMaxTemp = maxTemp;
    }

    public String getWeatherIconUrl() {
        return mWeatherIconUrl;
    }

    public void setWeatherIconUrl(String weatherIconUrl) {
        mWeatherIconUrl = weatherIconUrl;
    }

    public String getWeatherTitle() {
        return mWeatherTitle;
    }

    public void setWeatherTitle(String weatherTitle) {
        mWeatherTitle = weatherTitle;
    }

    public String getWeatherDescription() {
        return mWeatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        mWeatherDescription = weatherDescription;
    }
}
