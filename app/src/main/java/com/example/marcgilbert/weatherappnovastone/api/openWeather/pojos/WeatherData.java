package com.example.marcgilbert.weatherappnovastone.api.openWeather.pojos;


public class WeatherData {

    private String id;

    private String dt;

    private Clouds clouds;

    private Coord coord;

    private Wind wind;

    private String cod;

    private String visibility;

    private Sys sys;

    private String name;

    private String base;

    private Weather[] weather;

    private Main main;


    public String getId() {
        return id;
    }

    public String getDt() {
        return dt;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Coord getCoord() {
        return coord;
    }

    public Wind getWind() {
        return wind;
    }

    public String getCod() {
        return cod;
    }

    public String getVisibility() {
        return visibility;
    }

    public Sys getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }

    public String getBase() {
        return base;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }
}