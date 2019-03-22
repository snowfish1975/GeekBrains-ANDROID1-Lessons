package com.example.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView cityName = findViewById(R.id.cityName);
        String cityNamePassed = getIntent().getExtras().getString("CityName");
        cityName.setText(cityNamePassed);

        ImageView weatherState = findViewById(R.id.weatherState);

        // Читаем индекс погоды:
        // 1 - солнце
        // 10 - дождь
        // 100 - облака
        // 1000 - молния
        // 10000 - снег
        int weatherIndex = getIntent().getExtras().getInt("WeatherState");
        switch (weatherIndex) {
            case     1: { weatherState.setImageResource(R.drawable.sun); break; }
            case   100: { weatherState.setImageResource(R.drawable.cloud); break; }
            case   101: { weatherState.setImageResource(R.drawable.suncloud); break; }
            case   110: { weatherState.setImageResource(R.drawable.cloudrain); break; }
            case   111: { weatherState.setImageResource(R.drawable.suncloudrain); break; }
            case  1100: { weatherState.setImageResource(R.drawable.cloudlightning); break; }
            case  1110: { weatherState.setImageResource(R.drawable.cloudrainlightning); break; }
            case 10100: { weatherState.setImageResource(R.drawable.cloudsnow); break; }
            case 10110: { weatherState.setImageResource(R.drawable.cloudrainsnow); break; }
        }

        // если нужо отображать температуру
        boolean showTemp = getIntent().getExtras().getBoolean("ShowTemp");
        TextView temp = findViewById(R.id.temp);
        if (showTemp) {
            temp.setText(getIntent().getExtras().getString("Temperature") + " °C");
        } else
            temp.setVisibility(View.GONE);

        // если нужно отображать давление
        int pressure = getIntent().getExtras().getInt("AirPressure");
        TextView pres = findViewById(R.id.pressure);
        if (pressure>0) {
            pres.setText("Атмосферное давление " + pressure + " мм рт.ст." );
        } else
            pres.setVisibility(View.GONE);

        // если нужно отображать ветер
        String windDir = getIntent().getExtras().getString("WindDirection");
        TextView wind = findViewById(R.id.wind);
        if (windDir.equals("none")) {
            wind.setVisibility(View.GONE);
        } else {
            wind.setText("Направление ветра: " + windDir + ", " + String.valueOf(getIntent().getExtras().getInt("WindSpeed")) + " метров в сек" );
        }

        // если нужно отображать влажность
        Float humidity = getIntent().getExtras().getFloat("Humidity");
        TextView hum = findViewById(R.id.humidity);
        if (humidity<0) {
            hum.setVisibility(View.GONE);
        } else {
            hum.setText("Относительная влажность " + Math.round(humidity * 100) + "%");
        }


    }

}
