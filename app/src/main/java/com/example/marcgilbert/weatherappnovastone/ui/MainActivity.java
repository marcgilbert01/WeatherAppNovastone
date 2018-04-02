package com.example.marcgilbert.weatherappnovastone.ui;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.marcgilbert.weatherappnovastone.R;
import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.ui.citySelector.CitySelectorFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, CitySelectorFragment.CitySelectorFragmentListener{

    private MainContract.Presenter mPresenter;
    private MainNavigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPresenter = new MainPresenter(this);
        mNavigator = new MainNavigator(this, R.id.fragmentContainer);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onFlowStart();
    }

    @Override
    public void showWeatherOverviewCityList(List<City> cityList) {
        mNavigator.navigateToCountryListScreen(cityList);
    }

    @Override
    public void showWeatherDetails(City city) {

    }

    @Override
    public void displayTitleForCityListScreen() {

    }

    @Override
    public void displayTitleForCity(int cityTitle) {

    }
}
