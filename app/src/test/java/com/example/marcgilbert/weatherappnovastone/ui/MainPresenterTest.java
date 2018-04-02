package com.example.marcgilbert.weatherappnovastone.ui;

import com.example.marcgilbert.weatherappnovastone.api.City;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainContract.View mView;
    @Mock
    private MainContract.Interactor mInteractor;

    private MainContract.Presenter mPresenter;


    @Before
    public void setUp() throws Exception {
        mPresenter = new MainPresenter(mView, mInteractor);
    }

    @Test
    public void onFlowStart_thenShowCityList(){
        List<City> cityList = new ArrayList<>();
        when(mInteractor.getCityList()).thenReturn(cityList);

        mPresenter.onFlowStart();

        verify(mView).showWeatherOverviewCityList(cityList);
        verifyNoMoreInteractions(mView);
    }

    // TODO  the other tests :)

}
