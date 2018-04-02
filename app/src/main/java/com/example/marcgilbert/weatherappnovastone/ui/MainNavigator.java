package com.example.marcgilbert.weatherappnovastone.ui;


import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.ui.citySelector.CitySelectorFragment;

import java.util.List;

public class MainNavigator {

    public static final String SCREEN_TAG_CITY_LIST = "SCREEN_TAG_CITY_LIST";
    public static final String SCREEN_TAG_WEATHER_DETAILS = "SCREEN_TAG_WEATHER_DETAILS";

    private AppCompatActivity mActivity;
    private @IdRes int mFragmentContainerId;

    public MainNavigator(AppCompatActivity activity, int fragmentContainerId) {
        mActivity = activity;
        mFragmentContainerId = fragmentContainerId;
    }

    public void navigateToCountryListScreen(List<City> cityList){
        CitySelectorFragment fragment = CitySelectorFragment.newInstance(cityList);
        showFragment(fragment, SCREEN_TAG_CITY_LIST);
    }

    public void navigateToWeatherDetailsScreen(WeatherDataUI weatherDataUI){

    }

    private void showFragment(Fragment fragment, String tag){
        FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(mFragmentContainerId, fragment, tag);
        fragmentTransaction.commit();
    }

}
