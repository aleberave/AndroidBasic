package com.example.lesson3hw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public static final String TEXT = "text";
    public static final String BOOL_CBT = "bool_cbt";
    public static final String BOOL_CBW = "bool_cbw";
    public static final String BOOL_SAP = "bool_sap";
    public static final int REQUEST_CODE = 10;

    public static boolean SAP = false;
    public static boolean CBT = false;
    public static boolean CBW = false;

    Button button;
    CheckBox checkBoxTemperature;
    CheckBox checkBoxWind;
    Switch switchAtmospherePressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.search);
        button.setOnClickListener(new StartSecondActivity(this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            EditText num = findViewById(R.id.writeNameTown);
            num.setText(data.getStringExtra(TEXT));
            CBT = Boolean.parseBoolean(data.getStringExtra(BOOL_CBT));
            CBW = Boolean.parseBoolean(data.getStringExtra(BOOL_CBW));
            SAP = Boolean.parseBoolean(data.getStringExtra(BOOL_SAP));

            checkBoxTemperature = findViewById(R.id.checkBoxTemperature);
            checkBoxTemperature.setChecked(CBT);

            checkBoxWind = findViewById(R.id.checkBoxWind);
            checkBoxWind.setChecked(CBW);

            switchAtmospherePressure = findViewById(R.id.switchAtmospherePressure);
            switchAtmospherePressure.setChecked(SAP);
        }
    }

    public void onClickBox(View view) {
        boolean checkedBox = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBoxTemperature:
                if (checkedBox) {
                    CBT = true;
                } else {
                    CBT = false;
                }
                break;
            case R.id.checkBoxWind:
                if (checkedBox) {
                    CBW = true;
                } else {
                    CBW = false;
                }
                break;
        }
    }

    public void onClickSwitch(View view) {
        boolean checkedSwitch = ((Switch) view).isChecked();
        switch (view.getId()) {
            case R.id.switchAtmospherePressure:
                if (checkedSwitch) {
                    SAP = true;
                } else {
                    SAP = false;
                }
                break;
        }
    }

    }
