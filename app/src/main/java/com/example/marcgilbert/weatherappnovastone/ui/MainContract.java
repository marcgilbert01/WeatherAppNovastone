package com.example.marcgilbert.weatherappnovastone.ui;


import android.support.annotation.StringRes;

import com.example.marcgilbert.weatherappnovastone.api.City;

import java.util.List;

public interface MainContract {

    interface View {

        void showWeatherOverviewCityList(List<City> cityList);

        void showWeatherDetails(WeatherDataUI weatherDataUI);

        void displayTitleForCityListScreen();

        void displayTitleForCity(@StringRes int cityTitle);

        void navigateBack();
    }

    interface Presenter {

        void onFlowStart();

        void onFlowStop();

        void onCitySelected(WeatherDataUI weatherDataUI);

        void onNewScreenDisplayed(String screenTag);

        void onUserNavigatingBack();
    }

    interface Interactor {

        List<City> getCityList();

    }
}
