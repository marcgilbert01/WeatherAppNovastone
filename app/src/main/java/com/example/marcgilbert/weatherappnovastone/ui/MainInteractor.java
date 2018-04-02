package com.example.marcgilbert.weatherappnovastone.ui;


import com.example.marcgilbert.weatherappnovastone.api.City;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainInteractor implements MainContract.Interactor{

    @Override
    public List<City> getCityList() {

        return new ArrayList<>(Arrays.asList(City.values()));
    }
}
