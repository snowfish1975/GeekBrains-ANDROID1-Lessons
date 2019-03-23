package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        setContentView(R.layout.activity_second);

        TextView cityName = findViewById(R.id.cityName);
        String cityNamePassed = intent.getExtras().getString("CityName");
        cityName.setText(cityNamePassed);

        ImageView weatherState = findViewById(R.id.weatherState);

        // Читаем индекс погоды:
        WeatherTypes weatherIndex = (WeatherTypes) intent.getExtras().getSerializable("WeatherState");
        switch (weatherIndex) {
            case SUN:                  { weatherState.setImageResource(R.drawable.sun); break; }
            case CLOUD:                { weatherState.setImageResource(R.drawable.cloud); break; }
            case SUN_CLOUD:            { weatherState.setImageResource(R.drawable.suncloud); break; }
            case CLOUD_RAIN:           { weatherState.setImageResource(R.drawable.cloudrain); break; }
            case SUN_CLOUD_RAIN:       { weatherState.setImageResource(R.drawable.suncloudrain); break; }
            case CLOUD_LIGHTNING:      { weatherState.setImageResource(R.drawable.cloudlightning); break; }
            case CLOUD_RAIN_LIGHTNING: { weatherState.setImageResource(R.drawable.cloudrainlightning); break; }
            case CLOUD_SNOW:           { weatherState.setImageResource(R.drawable.cloudsnow); break; }
            case CLOUD_RAIN_SNOW:      { weatherState.setImageResource(R.drawable.cloudrainsnow); break; }
        }

        displayTemperature(intent); // если нужо отображать температуру
        displayPressure(intent);    // если нужно отображать давление
        displayWind(intent);        // если нужно отображать ветер
        displayHumidity(intent);    // если нужно отображать влажность
    }

    private void displayHumidity(Intent intent) {
        Float humidity = intent.getExtras().getFloat("Humidity");
        TextView hum = findViewById(R.id.humidity);
        if (humidity < 0)
            hum.setVisibility(View.GONE);
        else
            hum.setText("Относительная влажность " + Math.round(humidity * 100) + "%");
    }

    private void displayWind(Intent intent) {
        String windDir = intent.getExtras().getString("WindDirection");
        TextView wind = findViewById(R.id.wind);
        if (windDir.equals("none"))
            wind.setVisibility(View.GONE);
        else
            wind.setText("Направление ветра: " + windDir + ", " + String.valueOf(intent.getExtras().getInt("WindSpeed")) + " метров в сек");
    }

    private void displayPressure(Intent intent) {
        int pressure = intent.getExtras().getInt("AirPressure");
        TextView pres = findViewById(R.id.pressure);
        if (pressure > 0) {
            pres.setText("Атмосферное давление " + pressure + " мм рт.ст.");
        } else
            pres.setVisibility(View.GONE);
    }

    private void displayTemperature(Intent intent) {
        boolean showTemp = intent.getExtras().getBoolean("ShowTemp");
        TextView temp = findViewById(R.id.temp);
        if (showTemp) {
            temp.setText(intent.getExtras().getString("Temperature") + " °C");
        } else
            temp.setVisibility(View.GONE);
    }

}
