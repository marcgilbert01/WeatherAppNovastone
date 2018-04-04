package com.example.marcgilbert.weatherappnovastone.ui.weatherDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcgilbert.weatherappnovastone.R;
import com.example.marcgilbert.weatherappnovastone.ui.IconDisplayUtils;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

/**
 * this fragment is passive for now so we don't need a presenter
 * When we will get data the weather forecast from the backend
 * we should add  a presenter and interactor
 *
 */
public class WeatherDetailsFragment extends Fragment {

    private static final String ARG_WEATHER_DATA = "ARG_WEATHER_DATA";

    private WeatherDataUI mWeatherDataUI;

    private OnFragmentInteractionListener mListener;

    public WeatherDetailsFragment() {
        // Required empty public constructor
    }

    public static WeatherDetailsFragment newInstance(WeatherDataUI weatherDataUI) {
        WeatherDetailsFragment fragment = new WeatherDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_WEATHER_DATA, weatherDataUI);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mWeatherDataUI = (WeatherDataUI) getArguments().getSerializable(ARG_WEATHER_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather_details, container, false);
        TextView textViewCity = view.findViewById(R.id.cityName);
        textViewCity.setText(mWeatherDataUI.getName());
        TextView textViewCurrentTemperature = view.findViewById(R.id.currentTemperature);
        textViewCurrentTemperature.setText(mWeatherDataUI.getTempInCelcius());
        TextView textViewMinTemp = view.findViewById(R.id.minTemperature);
        textViewMinTemp.setText(mWeatherDataUI.getMinTemp());
        TextView textViewMaxTemp = view.findViewById(R.id.maxTemperature);
        textViewMaxTemp.setText(mWeatherDataUI.getMaxTemp());
        TextView textViewWindSpeed = view.findViewById(R.id.windSpeed);
        textViewWindSpeed.setText(mWeatherDataUI.getWindInKmPerHr());
        ImageView imageViewIconWeather = view.findViewById(R.id.weatherIcon);
        IconDisplayUtils.loadWeatherIconFromUrl(imageViewIconWeather, mWeatherDataUI.getWeatherIconUrl());

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

    }
}
