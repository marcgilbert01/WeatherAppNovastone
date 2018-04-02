package com.example.marcgilbert.weatherappnovastone.ui;


import android.support.annotation.VisibleForTesting;

import com.example.marcgilbert.weatherappnovastone.api.City;

import java.util.List;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mView;
    private MainContract.Interactor mInteractor;

    public MainPresenter(MainContract.View view) {
        this(view, new MainInteractor());
    }

    public MainPresenter(MainContract.View view, MainContract.Interactor interactor) {
        mView = view;
        mInteractor = interactor;
    }

    @Override
    public void onFlowStart() {
        List<City> cityList = mInteractor.getCityList();
        if (cityList!=null) {
            mView.showWeatherOverviewCityList(cityList);
        }
    }

    @Override
    public void onFlowStop() {

    }

    @Override
    public void onCountrySelected() {

    }

    @Override
    public void onNewScreenDisplayed() {

    }

}
