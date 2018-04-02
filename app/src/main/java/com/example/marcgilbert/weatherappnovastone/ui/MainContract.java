package com.example.marcgilbert.weatherappnovastone.ui;


import android.support.annotation.StringRes;

import com.example.marcgilbert.weatherappnovastone.api.City;

import java.util.List;

public interface MainContract {

    interface View {

        void showWeatherOverviewCityList(List<City> cityList);

        void showWeatherDetails(City city);

        void displayTitleForCityListScreen();

        void displayTitleForCity(@StringRes int cityTitle);
    }

    interface Presenter {

        void onFlowStart();

        void onFlowStop();

        void onCountrySelected();

        void onNewScreenDisplayed();
    }

    interface Interactor {

        List<City> getCityList();

    }
}
