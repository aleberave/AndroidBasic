package com.example.lesson3hw;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartSecondActivity implements View.OnClickListener {

    public static final String TEXT = "TEXT";
    private final Activity sourceActivity;

    public StartSecondActivity(Activity sourceActivity) {
        this.sourceActivity = sourceActivity;
    }

    @Override
    public void onClick(View v) {
        EditText writeNameTown = sourceActivity.findViewById(R.id.writeNameTown);
        if (writeNameTown.getText().length() == 0) {
            Toast.makeText(sourceActivity.getApplicationContext(), "Введите название города", Toast.LENGTH_SHORT).show();
        } else {
            Parsel parsel = new Parsel();
            parsel.text = writeNameTown.getText().toString();

            parsel.checkBoxTemperature = MainActivity.CBT;
            parsel.checkBoxWind = MainActivity.CBW;
            parsel.switchAtmospherePressure = MainActivity.SAP;

            Intent intent = new Intent(sourceActivity, SecondActivity.class);
            intent.putExtra(TEXT, parsel);

            sourceActivity.startActivityForResult(intent, MainActivity.REQUEST_CODE);
        }
    }

}
