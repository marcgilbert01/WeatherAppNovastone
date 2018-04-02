package com.example.marcgilbert.weatherappnovastone.ui.citySelector;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcgilbert.weatherappnovastone.R;
import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 */
public class CitySelectorFragment extends Fragment implements CitySelectorContract.View{

    private static final String ARG_CITY_LIST = "ARG_CITY_LIST";

    private ArrayList mCityList;
    private CitySelectorContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private CitySelectorFragmentListener mListener;

    public CitySelectorFragment() {
        // Required empty public constructor
    }

    public static CitySelectorFragment newInstance(List<City> cityList) {
        CitySelectorFragment fragment = new CitySelectorFragment();
        Bundle args = new Bundle();
        ArrayList<City> arrayList = new ArrayList(cityList);
        args.putSerializable(ARG_CITY_LIST, arrayList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCityList = (ArrayList) getArguments().getSerializable(ARG_CITY_LIST);
        }
        mPresenter = new CitySelectorPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city_selector, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onViewStart(mCityList);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onViewStop();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CitySelectorFragmentListener) {
            mListener = (CitySelectorFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement"+CitySelectorFragmentListener.class.getSimpleName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void displayWeatherOverviewList(List<WeatherDataUI> weatherDataUIList) {
        mRecyclerView.setAdapter(
                new CitySelectorRecyclerViewAdapter(weatherDataUIList, new CitySelectorRecyclerViewAdapter.OnCityClickListener() {
                    @Override
                    public void onCityClicked(WeatherDataUI weatherDataUI) {
                        mPresenter.onCountrySelected(weatherDataUI);
                    }
                }));
    }

    @Override
    public void setSelectedCity(WeatherDataUI weatherDataUI) {
        mListener.onCitySelected(weatherDataUI);
    }

    public interface CitySelectorFragmentListener {

        void onCitySelected(WeatherDataUI weatherDataUI);

    }
}
