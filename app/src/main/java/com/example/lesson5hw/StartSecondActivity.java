package com.example.lesson5hw;

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
        EditText writeNameTown = sourceActivity.findViewById(R.id.editTextWriteNameTown);
        if (writeNameTown.getText().length() == 0) {
            Toast.makeText(v.getContext(), "Введите название города", Toast.LENGTH_SHORT).show();
        } else {
            Parsel parsel = new Parsel();
            parsel.text = writeNameTown.getText().toString();

            parsel.checkBoxTemperature = CitiesListFragment.CBT;
            parsel.checkBoxWind = CitiesListFragment.CBW;
            parsel.switchAtmospherePressure = CitiesListFragment.SAP;

            Intent intent = new Intent(v.getContext(), Second2Activity.class);
            intent.putExtra(TEXT, parsel);

            sourceActivity.startActivityForResult(intent, CitiesListFragment.REQUEST_CODE);
        }
    }
}
