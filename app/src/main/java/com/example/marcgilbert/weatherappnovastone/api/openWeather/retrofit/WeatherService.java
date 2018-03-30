package com.example.marcgilbert.weatherappnovastone.api.openWeather.retrofit;


import com.example.marcgilbert.weatherappnovastone.api.openWeather.pojos.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("/data/2.5/weather?")
    Call<WeatherData> getCurrentWeatherFor(@Query("q") String city, @Query("units") String units,  @Query("APPID") String apiKey);

}
