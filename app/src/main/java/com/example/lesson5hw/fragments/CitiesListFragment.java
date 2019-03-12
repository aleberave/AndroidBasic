package com.example.lesson5hw.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import com.example.lesson5hw.R;
import com.example.lesson5hw.activities.ThirdActivity;

public class CitiesListFragment extends Fragment {

    public static final String TAG = CitiesListFragment.class.getSimpleName();

    public static final String TEXT = "text";
    public static final String BOOL_CBT = "bool_cbt";
    public static final String BOOL_CBW = "bool_cbw";
    public static final String BOOL_SAP = "bool_sap";
    public static final int REQUEST_CODE = 10;

    public static boolean sap = false;
    public static boolean cbt = false;
    public static boolean cbw = false;

    private EditText editTextWriteNameTown;
    private CheckBox checkBoxTemperature;
    private CheckBox checkBoxWind;
    private Switch switchAtmospherePressure;
    private Button buttonSearch;
    private Button buttonStorySearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_activity, container, false);

        setRetainInstance(true);

        editTextWriteNameTown = v.findViewById(R.id.editTextWriteNameTown);
        checkBoxTemperature = v.findViewById(R.id.checkBoxTemperature);
        checkBoxWind = v.findViewById(R.id.checkBoxWind);
        switchAtmospherePressure = v.findViewById(R.id.switchAtmospherePressure);
        buttonSearch = v.findViewById(R.id.buttonSearch);
        buttonStorySearch = v.findViewById(R.id.buttonStorySearch);
        return v;
    }

    public static CitiesListFragment init(Bundle bundle) {
        CitiesListFragment citiesListFragment = new CitiesListFragment();
        citiesListFragment.setArguments(bundle);
        return citiesListFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
    }

    private void setViews(@NonNull View v) {
        checkBoxTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBox(v);
            }
        });
        checkBoxWind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBox(v);
            }
        });
        switchAtmospherePressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSwitch(v);
            }
        });
        buttonSearch.setOnClickListener(new StartSecondActivity(getActivity()));
        buttonStorySearch.setOnClickListener(listener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == getActivity().RESULT_OK) {
            editTextWriteNameTown.setText(data.getStringExtra(TEXT));
            cbt = Boolean.parseBoolean(data.getStringExtra(BOOL_CBT));
            cbw = Boolean.parseBoolean(data.getStringExtra(BOOL_CBW));
            sap = Boolean.parseBoolean(data.getStringExtra(BOOL_SAP));
            checkBoxTemperature.setChecked(cbt);
            checkBoxWind.setChecked(cbw);
            switchAtmospherePressure.setChecked(sap);
        }
    }

    public void onClickBox(View view) {
        boolean checkedBox = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBoxTemperature:
                if (checkedBox) {
                    cbt = true;
                } else {
                    cbt = false;
                }
                break;
            case R.id.checkBoxWind:
                if (checkedBox) {
                    cbw = true;
                } else {
                    cbw = false;
                }
                break;
        }
    }

    public void onClickSwitch(View view) {
        boolean checkedSwitch = ((Switch) view).isChecked();
        switch (view.getId()) {
            case R.id.switchAtmospherePressure:
                if (checkedSwitch) {
                    sap = true;
                } else {
                    sap = false;
                }
                break;
        }
    }

    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), ThirdActivity.class);
            startActivity(intent);
        }
    };
}
