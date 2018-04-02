package com.example.marcgilbert.weatherappnovastone.ui.citySelector;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcgilbert.weatherappnovastone.R;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import java.util.List;

public class CitySelectorRecyclerViewAdapter extends RecyclerView.Adapter<CityCellViewModel>{

    private List<WeatherDataUI> mWeatherDataUiList;

    public CitySelectorRecyclerViewAdapter(List<WeatherDataUI> weatherDataUiList) {
        mWeatherDataUiList = weatherDataUiList;
    }

    @Override
    public CityCellViewModel onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_cell, parent, false);
        return new CityCellViewModel(view);
    }

    @Override
    public void onBindViewHolder(CityCellViewModel holder, int position) {
        holder.bind(mWeatherDataUiList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeatherDataUiList.size();
    }
}
