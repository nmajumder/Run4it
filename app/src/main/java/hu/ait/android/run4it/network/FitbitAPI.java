package hu.ait.android.run4it.network;

import hu.ait.android.run4it.data.AccessToken;
import hu.ait.android.run4it.data.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jwatto01 on 5/18/16.
 */
public interface FitbitAPI {
    @GET("")
    Call<AccessToken> getAccessToken();
/*
    @Get(AuthorizationResult)
    @GET("user")
    Call<User> getUser(@Query("q") String city,
                                   @Query("units") String units,
                                   @Query("appid") String key);

    Call<UserResult> getUser(@Header("Authorization") string Token)

    Call<AuthorizationResult>
}*/
}


Call<WeatherResult> weatherQuery = weatherAPI.getWeather(cityName,getString(R.string.units),
        getString(R.string.APIkey));


weatherQuery.enqueue(new Callback<WeatherResult>() {
@Override
public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {

        // here we need to tell the different fragments
        EventBus.getDefault().post(response.body());
        if(response.body().getBase() != null) {

        tvCurrentTime.setText(DateFormat.getTimeInstance().format
        (response.body().getDt() * (long) 1000));
        } else{
        Toast.makeText(DetailsActivity.this, R.string.invalid_city
        , Toast.LENGTH_SHORT).show();

        finish();
        }
        }

@Override
public void onFailure(Call<WeatherResult> call, Throwable t) {
        tvCityName.setText(getString(R.string.error)+t.getMessage());

        }
        });