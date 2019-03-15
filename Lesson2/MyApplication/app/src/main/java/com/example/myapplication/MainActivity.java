package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "WeatherApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Приложение вошло в режим создания - метод onCreate()");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Приложение готовится к запуску - метод onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Приложение останавливается - метод onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Приложение полностью удаляется из памяти - метод onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Приложение приостанавливается - метод onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Приложение продолжает работу - метод onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Приложение перезапускается - метод onRestart()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Приложение сохраняет свое состояние - метод onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "Приложение восстанавливает свое состояние - метод onRestoreInstanceState()");
    }
}
