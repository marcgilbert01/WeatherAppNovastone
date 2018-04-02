package com.example.marcgilbert.weatherappnovastone.ui.citySelector;


import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.api.IWeatherApi;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;

public class CitySelectorInteractor implements CitySelectorContract.Interactor{

    private IWeatherApi mWeatherApi;

    public CitySelectorInteractor(IWeatherApi weatherApi) {
        mWeatherApi = weatherApi;
    }

    @Override
    public Single<List<WeatherDataUI>> getWeatherDataUi(final List<City> cityList) {
        return Single.create(new SingleOnSubscribe<List<WeatherDataUI>>() {
            @Override
            public void subscribe(final SingleEmitter<List<WeatherDataUI>> emitter) throws Exception {
                mWeatherApi.getCurrentWeatherFor(cityList)
                        .subscribe(new Consumer<Map<City, WeatherDataUI>>() {
                                       @Override
                                       public void accept(Map<City, WeatherDataUI> cityWeatherDataUIMap) throws Exception {
                                           List<WeatherDataUI> weatherDataUIList = new ArrayList<>(cityWeatherDataUIMap.values());
                                           emitter.onSuccess(weatherDataUIList);
                                       }
                                   }, new Consumer<Throwable>() {
                                       @Override
                                       public void accept(Throwable throwable) throws Exception {
                                            if (!emitter.isDisposed()){
                                                emitter.onError(throwable);
                                            }
                                       }
                                   }
                        );

            }
        });
    }
}
