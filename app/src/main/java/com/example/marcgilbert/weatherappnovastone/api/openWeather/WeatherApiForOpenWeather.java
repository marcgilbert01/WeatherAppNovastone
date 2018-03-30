package com.example.marcgilbert.weatherappnovastone.api.openWeather;


import android.util.Log;

import com.example.marcgilbert.weatherappnovastone.BuildConfig;
import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.api.IWeatherApi;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.pojos.WeatherData;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.retrofit.RetrofitClient;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.retrofit.WeatherService;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.Callable;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherApiForOpenWeather implements IWeatherApi {

    private static final String OPEN_WEATHER_API_KEY = "06a1fe7ee329a75c9b23561cc9f17903";
    private static final String OPEN_WEATHER_BASE_URL = "http://api.openweathermap.org";
    private static final String UNITS = "metric";

    @Override
    public Single<WeatherDataUI> getCurrentWeather(final City city) {
        return Single.fromCallable(new Callable<WeatherDataUI>() {
            @Override
            public WeatherDataUI call() throws Exception {
                WeatherData weatherData = getCurrentWeather(city.getValue());
                WeatherDataUI weatherDataUI = new WeatherDataUI();
                weatherDataUI.setTempInCelcius(weatherData.getMain().getTemp());
                weatherDataUI.setWindInKmPerHr(weatherData.getWind().getSpeed());

                return weatherDataUI;
            }
        });
    }

    private WeatherData getCurrentWeather(String city) throws IOException {
        WeatherService weatherService = RetrofitClient.getClient(OPEN_WEATHER_BASE_URL).create(WeatherService.class);
        Response<WeatherData> response = weatherService.getCurrentWeatherFor(city, UNITS, OPEN_WEATHER_API_KEY).execute();

        return response.body();
    }
}

