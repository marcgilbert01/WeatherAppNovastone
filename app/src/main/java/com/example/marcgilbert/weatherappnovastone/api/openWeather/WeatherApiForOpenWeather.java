package com.example.marcgilbert.weatherappnovastone.api.openWeather;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.api.IWeatherApi;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.pojos.WeatherData;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.pojos.WeatherDataList;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.retrofit.RetrofitClient;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.retrofit.WeatherService;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import io.reactivex.Single;
import retrofit2.Response;

public class WeatherApiForOpenWeather implements IWeatherApi {

    private static final String OPEN_WEATHER_API_KEY = "06a1fe7ee329a75c9b23561cc9f17903";
    private static final String OPEN_WEATHER_BASE_URL = "http://api.openweathermap.org";
    private static final String UNITS = "metric";

    private Map<City,String> mOpenWeatherCityIdMap = new HashMap<>();

    public WeatherApiForOpenWeather() {
        mOpenWeatherCityIdMap.put(City.LONDON, "2643743");
        mOpenWeatherCityIdMap.put(City.PARIS, "2968815");
        mOpenWeatherCityIdMap.put(City.BERLIN, "2950159");
        mOpenWeatherCityIdMap.put(City.DUBLIN, "2964574");
        mOpenWeatherCityIdMap.put(City.EDINBURGH, "2650225");
        mOpenWeatherCityIdMap.put(City.LOS_ANGELES, "5368361");
        mOpenWeatherCityIdMap.put(City.MADRID, "6359304");
        mOpenWeatherCityIdMap.put(City.ROME, "3169070");
        mOpenWeatherCityIdMap.put(City.NEW_YORK, "5128638");
        mOpenWeatherCityIdMap.put(City.TOKYO, "1850147");
    }

    @Override
    public Single<WeatherDataUI> getCurrentWeatherFor(final City city) {
        return Single.fromCallable(new Callable<WeatherDataUI>() {
            @Override
            public WeatherDataUI call() throws Exception {
                WeatherData weatherData = getCurrentWeatherForOneCity(city);
                WeatherDataUI weatherDataUI = new WeatherDataUI();
                weatherDataUI.setTempInCelcius(weatherData.getMain().getTemp());
                weatherDataUI.setWindInKmPerHr(weatherData.getWind().getSpeed());

                return weatherDataUI;
            }
        });
    }

    @Override
    public Single<Map<City, WeatherDataUI>> getCurrentWeatherFor(final List<City> cityList) {
        return Single.fromCallable(new Callable<Map<City, WeatherDataUI>>() {
            @Override
            public Map<City, WeatherDataUI> call() throws Exception {
                List<WeatherData> weatherDataList = getCurrentWeatherForMultipleCities(cityList);
                if (weatherDataList!=null) {
                    return mapWeatherList(cityList, weatherDataList);
                }
                return null;
            }
        });
    }

    private Map<City, WeatherDataUI> mapWeatherList(List<City> cityList, List<WeatherData> weatherDataList) {
        // TODO improve mapping in case of long list of countries
        Map<City, WeatherDataUI> weatherDataUIMap = new HashMap<>();
        for(City city : cityList){
            for(WeatherData weatherData: weatherDataList) {
                if (weatherData.getId().equals(mOpenWeatherCityIdMap.get(city))) {
                    weatherDataUIMap.put(city, buildWeatherDataUi(weatherData));
                }
            }
        }

        return weatherDataUIMap;
    }

    private WeatherDataUI buildWeatherDataUi(WeatherData weatherData){
        WeatherDataUI weatherDataUI = new WeatherDataUI();
        weatherDataUI.setName(weatherData.getName());
        weatherDataUI.setTempInCelcius(weatherData.getMain().getTemp());
        weatherDataUI.setWindInKmPerHr(weatherData.getWind().getSpeed());

        return weatherDataUI;
    }

    @Nullable
    private WeatherData getCurrentWeatherForOneCity(City city) throws IOException {
        String cityId = mOpenWeatherCityIdMap.get(city);
        if (cityId!=null) {
            WeatherService weatherService = RetrofitClient.getClient(OPEN_WEATHER_BASE_URL).create(WeatherService.class);
            Response<WeatherData> response = weatherService.getCurrentWeatherFor(cityId, UNITS, OPEN_WEATHER_API_KEY).execute();
            return response.body();
        }
        return null;
    }

    @Nullable
    private List<WeatherData> getCurrentWeatherForMultipleCities(@NonNull List<City> cityList) throws IOException {
        String cityListParam = createMultipleCityParam(cityList);
        if (cityListParam!=null) {
            WeatherService weatherService = RetrofitClient.getClient(OPEN_WEATHER_BASE_URL).create(WeatherService.class);
            Response<WeatherDataList> response = weatherService.getCurrentWeatherListFor(cityListParam, UNITS, OPEN_WEATHER_API_KEY).execute();
            WeatherDataList weatherDataList = response.body();
            return weatherDataList.getList();
        }
        return null;
    }

    private String createMultipleCityParam(@NonNull List<City> cityList){
        StringBuilder stringBuilder = new StringBuilder();
        for(City city: cityList) {
            String cityId = mOpenWeatherCityIdMap.get(city);
            if (cityId!=null) {
                stringBuilder.append(cityId + ",");
            }
        }
        String parameter = stringBuilder.toString();
        parameter = parameter.substring(0, parameter.length()-1);

        return parameter;
    }
}

