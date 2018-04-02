package com.example.marcgilbert.weatherappnovastone.ui.citySelector;


import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import java.util.List;

import io.reactivex.Single;

public class CitySelectorContract {

    interface View {

        void displayWeatherOverviewList(List<WeatherDataUI> weatherDataUIList);

        void setSelectedCity(WeatherDataUI weatherDataUI);
    }

    interface Presenter {

        void onViewStart(List<City> cityList);

        void onViewStop();

        void onCountrySelected(City city);
    }

    interface Interactor {

        Single<List<WeatherDataUI>> getWeatherDataUi(List<City> cityList);
    }

}
