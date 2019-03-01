package com.example.lesson4hw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView printNameTown;
    private TextView temperature;
    private TextView wind;
    private TextView atmospherePressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Parsel parsel = (Parsel) getIntent().getExtras().getSerializable(StartSecondActivity.TEXT);

        printNameTown = findViewById(R.id.printNameTown);
        temperature = findViewById(R.id.temperature);
        wind = findViewById(R.id.wind);
        atmospherePressure = findViewById(R.id.atmospherePressure);

        printNameTown.setText(getResources().getString(R.string.printNameTown) + ": " + parsel.text);
        if (parsel.checkBoxTemperature) {
            temperature.setText(getResources().getString(R.string.temperature) + ": 20 " + getResources().getString(R.string.temperature_degrees));
        }
        if (parsel.checkBoxWind) {
            wind.setText(getResources().getString(R.string.wind) + ": 2 " + getResources().getString(R.string.wind_speed));
        }
        if(parsel.switchAtmospherePressure){
            atmospherePressure.setText(getResources().getString(R.string.atmosphere_pressure) + ": 751.3 " + getResources().getString(R.string.atmosphere_pressure_measure));
        }
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.backToActivityOne:
                Parsel parsel = new Parsel();
                parsel.text = "";
                parsel.checkBoxTemperature = false;
                parsel.checkBoxWind = false;
                parsel.switchAtmospherePressure = false;
                Intent intentResult = new Intent();
                intentResult.putExtra(MainActivity.TEXT, parsel.text);
                intentResult.putExtra(MainActivity.BOOL_CBT, parsel.checkBoxTemperature);
                intentResult.putExtra(MainActivity.BOOL_CBW, parsel.checkBoxWind);
                intentResult.putExtra(MainActivity.BOOL_SAP, parsel.switchAtmospherePressure);
                setResult(Activity.RESULT_OK, intentResult);
                finish();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
