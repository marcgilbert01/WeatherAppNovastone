package com.example.marcgilbert.weatherappnovastone.api.openWeather.retrofit;


import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.pojos.WeatherData;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import retrofit2.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class WeatherServiceTest {

    private final String URL = "http://api.openweathermap.org";
    private WeatherService mWeatherService;

    @Before
    public void setUp() throws Exception {
        mWeatherService = RetrofitClient.getClient(URL).create(WeatherService.class);
    }

    @Test
    public void test_getLondonCurrentWeatherDataFromOpenWeather() throws IOException {
        Response<WeatherData> response = mWeatherService.getCurrentWeatherFor( City.LONDON.getValue(), "metric","06a1fe7ee329a75c9b23561cc9f17903").execute();
        WeatherData weatherData = response.body();

        assertThat(weatherData, is(notNullValue()));
        assertThat(weatherData.getName(), equalTo("London"));
    }

}
