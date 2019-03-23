package com.example.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        //     1 - солнце
        //    10 - дождь
        //   100 - облака
        //  1000 - молния
        // 10000 - снег
        Random rnd = new Random();
        switch (view.getId()) {
            case R.id.button:

                if (((EditText) findViewById(R.id.city)).getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please type in city name first!", Toast.LENGTH_LONG).show();
                    break;
                }

                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("CityName", ((EditText) findViewById(R.id.city)).getText().toString());
                intent.putExtra("WeatherState", WeatherTypes.values()[rnd.nextInt(WeatherTypes.values().length)]);

                // Если включен "показывать температуру"
                if (((Switch) findViewById(R.id.tempSwitch)).isChecked()) {
                    intent.putExtra("ShowTemp", true);
                    float t = rnd.nextFloat() * 100f - 50f;
                    String ts = "";
                    if (t > 0) ts = "+";
                    ts = ts + String.valueOf(Math.round(t));
                    intent.putExtra("Temperature", ts);
                } else
                    intent.putExtra("ShowTemp", false);

                // Если включен "показывать силу и направление ветра"
                if (((Switch) findViewById(R.id.windSwitch)).isChecked()) {
                    intent.putExtra("WindDirection", "NW");
                    intent.putExtra("WindSpeed", rnd.nextInt(20));
                } else
                    intent.putExtra("WindDirection", "none");

                // Если включен "показывать влажность"
                if (((Switch) findViewById(R.id.humiditySwitch)).isChecked()) {
                    intent.putExtra("Humidity", rnd.nextFloat());
                } else
                    intent.putExtra("Humidity", -1f);

                // Если включен "показывать атмосферное давление"
                if (((Switch) findViewById(R.id.pressureSwitch)).isChecked()) {
                    intent.putExtra("AirPressure", rnd.nextInt(175) + 641);
                } else
                    intent.putExtra("AirPressure", -1);

                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
