package com.example.marcgilbert.weatherappnovastone.ui.citySelector;

import com.example.marcgilbert.weatherappnovastone.api.City;
import com.example.marcgilbert.weatherappnovastone.RxImmediateSchedulerRule;
import com.example.marcgilbert.weatherappnovastone.ui.WeatherDataUI;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CitySelectorPresenterTest {

    @Rule
    public RxImmediateSchedulerRule schedulers = new RxImmediateSchedulerRule();
    @Mock
    private CitySelectorContract.View mView;
    @Mock
    private CitySelectorContract.Interactor mInteractor;

    private CitySelectorContract.Presenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mPresenter = new CitySelectorPresenter(mView, mInteractor);
    }

    @Test
    public void onViewStart_thenDisplayCityList(){
        List<City> cityList = new ArrayList<>();
        List<WeatherDataUI> weatherDataUIList = new ArrayList<>();
        when(mInteractor.getWeatherDataUi(cityList)).thenReturn(Single.just(weatherDataUIList));

        mPresenter.onViewStart(cityList);

        verify(mInteractor).getWeatherDataUi(cityList);
        verify(mView).displayWeatherOverviewList(weatherDataUIList);
        verifyNoMoreInteractions(mView);
        verifyNoMoreInteractions(mInteractor);
    }

}
