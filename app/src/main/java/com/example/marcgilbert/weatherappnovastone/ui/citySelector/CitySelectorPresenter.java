package com.example.marcgilbert.weatherappnovastone.ui.citySelector;


import android.util.Log;

import com.example.marcgilbert.weatherappnovastone.BuildConfig;
import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.WeatherApiForOpenWeather;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CitySelectorPresenter implements CitySelectorContract.Presenter{

    private final String TAG = CitySelectorContract.class.getSimpleName();

    private CitySelectorContract.View mView;
    private CitySelectorContract.Interactor mInteractor;
    private CompositeDisposable mSubscriptions = new CompositeDisposable();

    public CitySelectorPresenter(CitySelectorContract.View view) {
        this(view,new CitySelectorInteractor(new WeatherApiForOpenWeather()));
    }

    public CitySelectorPresenter(CitySelectorContract.View view, CitySelectorContract.Interactor interactor) {
        mView = view;
        mInteractor = interactor;
    }

    @Override
    public void onViewStart(List<City> cityList) {
        // TODO add progress spinner
        mSubscriptions.add(
            mInteractor.getWeatherDataUi(cityList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<WeatherDataUI>>() {
                    @Override
                    public void accept(List<WeatherDataUI> weatherDataUIList) throws Exception {
                        mView.displayWeatherOverviewList(weatherDataUIList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (BuildConfig.DEBUG) {
                            Log.d(TAG, "Error getting weather data", throwable);
                        }
                    }
                })
        );

    }

    @Override
    public void onViewStop() {
        mSubscriptions.clear();
    }

    @Override
    public void onCountrySelected(City city) {

    }
}
