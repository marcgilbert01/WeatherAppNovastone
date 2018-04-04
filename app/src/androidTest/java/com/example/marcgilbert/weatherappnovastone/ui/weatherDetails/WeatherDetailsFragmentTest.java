package com.example.marcgilbert.weatherappnovastone.ui.weatherDetails;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.marcgilbert.weatherappnovastone.R;
import com.example.marcgilbert.weatherappnovastone.api.openWeather.pojos.Main;
import com.example.marcgilbert.weatherappnovastone.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class WeatherDetailsFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class,false,true);

    @Test
    public void onLondonSelected_thenDisplayLondonWeatherDetails(){

        // click on london
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("London")),
                        click())
                );

        // check that weather for london is displayed
        onView(withId(R.id.cityName)).check(matches(allOf(
                        isCompletelyDisplayed(),
                        withText("London")))
        );
        onView(withId(R.id.currentTemperature)).check(matches(allOf(
                isCompletelyDisplayed()
        )));
        // TODO check the other views :)
    }
}
