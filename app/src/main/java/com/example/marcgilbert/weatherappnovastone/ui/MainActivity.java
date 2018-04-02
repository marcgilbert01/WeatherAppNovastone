package com.example.marcgilbert.weatherappnovastone.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.marcgilbert.weatherappnovastone.R;
import com.example.marcgilbert.weatherappnovastone.api.City;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPresenter = new MainPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onFlowStart();
    }

    @Override
    public void showWeatherOverviewCityList(List<City> cityList) {

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
