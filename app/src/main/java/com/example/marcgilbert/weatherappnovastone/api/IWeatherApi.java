package com.example.marcgilbert.weatherappnovastone.api;

import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;

public interface IWeatherApi {

    Single<WeatherDataUI> getCurrentWeatherFor(City city);

    Single<Map<City, WeatherDataUI>> getCurrentWeatherFor(List<City> cityList);

}
