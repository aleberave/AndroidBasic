package com.example.lesson5hw.fragments;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lesson5hw.R;
import com.example.lesson5hw.activities.SecondActivity;
import com.example.lesson5hw.activities.ThirdActivity;

import java.util.ArrayList;

public class StartSecondActivity implements View.OnClickListener {

    public static final String TEXT = "TEXT";
    public static final String THIRD = "THIRD";
    private final Activity sourceActivity;
    private ArrayList<String> list;

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

            parsel.checkBoxTemperature = CitiesListFragment.cbt;
            parsel.checkBoxWind = CitiesListFragment.cbw;
            parsel.switchAtmospherePressure = CitiesListFragment.sap;

            Intent intent = new Intent(v.getContext(), SecondActivity.class);
            intent.putExtra(TEXT, parsel);


            if (list == null) {
                list = new ArrayList<>(6);
                list.add(parsel.text);
            } else {
                list.add(parsel.text);
            }

            sourceActivity.startActivityForResult(intent, CitiesListFragment.REQUEST_CODE);
        }
    }

    public void onClickToThird(View v) {
        Intent intent = new Intent(v.getContext(), ThirdActivity.class);
        intent.putStringArrayListExtra(THIRD, list);
        sourceActivity.startActivity(intent);
    }
}
