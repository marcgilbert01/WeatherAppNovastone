package com.example.marcgilbert.weatherappnovastone.ui;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.marcgilbert.weatherappnovastone.R;

public class IconDisplayUtils {

    public static void loadWeatherIconFromUrl(ImageView imageViewIconWeather, String url){
        Context context = imageViewIconWeather.getContext();
        RequestOptions requestOptions = new RequestOptions()
                .fitCenter()
                .error(R.drawable.cloud)
                .transform(new RoundedCorners((int) context.getResources().getDimension(R.dimen.icon_rounded_corner_radius)));

        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade(75))
                .into(imageViewIconWeather);
    }

}
