package com.example.marcgilbert.weatherappnovastone.api.openWeather.retrofit;


import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.pojos.WeatherData;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.pojos.WeatherDataList;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

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
        Response<WeatherData> response = mWeatherService.getCurrentWeatherFor( "London", "metric","06a1fe7ee329a75c9b23561cc9f17903").execute();
        WeatherData weatherData = response.body();

        assertThat(weatherData, is(notNullValue()));
        assertThat(weatherData.getName(), equalTo("London"));
        assertThat(weatherData.getMain().getTemp(), is(notNullValue()));
        // TODO check all needed weather data
    }

    @Test
    public void test_getCurrentWeatherDataListFromOpenWeather() throws IOException {
        Response<WeatherDataList> response = mWeatherService.getCurrentWeatherListFor( "2950159,2964574", "metric","06a1fe7ee329a75c9b23561cc9f17903").execute();
        List<WeatherData> weatherDataList = response.body().getList();

        assertThat(weatherDataList, is(notNullValue()));
        assertThat(weatherDataList.size(), is(2));
        assertThat(weatherDataList.get(0).getName(), equalTo("Berlin"));
        assertThat(weatherDataList.get(1).getName(), equalTo("Dublin"));
        // TODO check all needed weather data
    }



}
