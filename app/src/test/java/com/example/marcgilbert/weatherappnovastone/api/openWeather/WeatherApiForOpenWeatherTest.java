package com.example.marcgilbert.weatherappnovastone.api.openWeather;

import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class WeatherApiForOpenWeatherTest {

    WeatherApiForOpenWeather mWeatherApiForOpenWeather;
    List<City> mCityList;

    @Before
    public void setUp() throws Exception {
        mWeatherApiForOpenWeather = new WeatherApiForOpenWeather();
    }

    @Test
    public void testGetCurrentWeatherFor_givenAListOfCountries() throws IOException {
        mCityList = new ArrayList<>();
        mCityList.add(City.BERLIN);
        mCityList.add(City.DUBLIN);

        Map<City, WeatherDataUI> map = mWeatherApiForOpenWeather.getCurrentWeatherFor(mCityList).blockingGet();

        assertThat(map, is(notNullValue()));
        assertThat(map.size(), is(2));
        assertThat(map.get(City.BERLIN).getTempInCelcius(), is(notNullValue()));
        assertThat(map.get(City.DUBLIN).getWindInKmPerHr(), is(notNullValue()));
    }

}
