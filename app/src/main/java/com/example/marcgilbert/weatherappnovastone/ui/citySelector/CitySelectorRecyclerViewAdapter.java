package com.example.marcgilbert.weatherappnovastone.ui.citySelector;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcgilbert.weatherappnovastone.R;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;
import com.example.marcgilbert.weatherappnovastone.ui.weatherDetails.WeatherDetailsFragment;

import java.util.List;

public class CitySelectorRecyclerViewAdapter extends RecyclerView.Adapter<CityCellViewModel>{

    private List<WeatherDataUI> mWeatherDataUiList;
    private OnCityClickListener mOnCityClickListener;

    public CitySelectorRecyclerViewAdapter(List<WeatherDataUI> weatherDataUiList, OnCityClickListener onCityClickListener) {
        mWeatherDataUiList = weatherDataUiList;
        mOnCityClickListener = onCityClickListener;
    }

    @Override
    public CityCellViewModel onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_cell, parent, false);
        return new CityCellViewModel(view);
    }

    @Override
    public void onBindViewHolder(CityCellViewModel holder, int position) {
        final WeatherDataUI weatherDataUI = mWeatherDataUiList.get(position);
        holder.bind(weatherDataUI, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnCityClickListener!=null) {
                    mOnCityClickListener.onCityClicked(weatherDataUI);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWeatherDataUiList.size();
    }

    interface OnCityClickListener {

        void onCityClicked(WeatherDataUI weatherDataUI);

    }

}
