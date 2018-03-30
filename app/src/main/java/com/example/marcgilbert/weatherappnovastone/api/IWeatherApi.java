package com.example.marcgilbert.weatherappnovastone.api;

import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import io.reactivex.Single;

public interface IWeatherApi {

    Single<WeatherDataUI> getCurrentWeather(City city);

}
