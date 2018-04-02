package com.example.marcgilbert.weatherappnovastone.ui.citySelector;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcgilbert.weatherappnovastone.R;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

public class CityCellViewModel extends RecyclerView.ViewHolder{

    private TextView mTextViewCityName;
    private ImageView mImageViewIconWeather;
    private TextView mTextViewCurrentTemperature;

    public CityCellViewModel(View itemView) {
        super(itemView);
        mTextViewCityName = itemView.findViewById(R.id.cityName);
        mImageViewIconWeather = itemView.findViewById(R.id.weatherIcon);
        mTextViewCurrentTemperature = itemView.findViewById(R.id.currentTemperature);
    }

    public void bind(WeatherDataUI weatherDataUI){
        mTextViewCityName.setText(weatherDataUI.getName());
        // TODO to be done with glide or picasso  etc ...
        mImageViewIconWeather.setImageResource(R.drawable.cloud);
        mTextViewCurrentTemperature.setText(weatherDataUI.getTempInCelcius());
    }

}
