package com.example.marcgilbert.weatherappnovastone.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.marcgilbert.weatherappnovastone.R;
import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.ui.citySelector.CitySelectorFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, CitySelectorFragment.CitySelectorFragmentListener{

    private MainContract.Presenter mPresenter;
    private MainNavigator mNavigator;
    private FragmentManager.FragmentLifecycleCallbacks mFragmentLifecycleCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");

        mFragmentLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentResumed(FragmentManager fm, Fragment fragment) {
                super.onFragmentResumed(fm, fragment);
                mPresenter.onNewScreenDisplayed(fragment.getTag());
            }
        };
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(mFragmentLifecycleCallbacks,true);
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
    public void showWeatherDetails(WeatherDataUI weatherDataUI) {
        mNavigator.navigateToWeatherDetailsScreen(weatherDataUI);
    }

    @Override
    public void displayTitleForCityListScreen() {
        getSupportActionBar().setTitle(getString(R.string.city_list_title));
    }

    @Override
    public void displayTitleForCity(int cityTitle) {

    }

    @Override
    public void navigateBack() {
        if (!getSupportFragmentManager().popBackStackImmediate()) {
            finish();
        }
        // this activity only use fragment to display something so if no more fragment close it
        if (getSupportFragmentManager().getBackStackEntryCount() <= 0) {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                navigateBack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navigateBack();
    }

    @Override
    public void onCitySelected(WeatherDataUI weatherDataUI) {
        mPresenter.onCitySelected(weatherDataUI);
    }
}
