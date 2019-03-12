package com.example.lesson5hw.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson5hw.R;
import com.example.lesson5hw.recycle.DataSourceBuilder;

public class DataCityFragment extends Fragment {

    public static final String DATA = "data";

    public static final String TAG = DataCityFragment.class.getSimpleName();

    private TextView printNameTown;
    private TextView temperature;
    private TextView wind;
    private TextView atmospherePressure;
    private Button newSearch;

    public static DataCityFragment init(Bundle bundle) {
        DataCityFragment dataCityFragment = new DataCityFragment();
        dataCityFragment.setArguments(bundle);
        return dataCityFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second_activity, container, false);

        setRetainInstance(true);

        printNameTown = v.findViewById(R.id.printNameTown);
        temperature = v.findViewById(R.id.temperature);
        wind = v.findViewById(R.id.wind);
        atmospherePressure = v.findViewById(R.id.atmospherePressure);
        newSearch = v.findViewById(R.id.backToActivityOne);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Parsel parsel = getActivity().getIntent().getExtras().getParcelable(StartSecondActivity.TEXT);

        printNameTown.setText(getResources().getString(R.string.printNameTown) + ": " + parsel.text);

        if (parsel.checkBoxTemperature) {
            temperature.setText(getResources().getString(R.string.temperature) + ": 20 " + getResources().getString(R.string.temperature_degrees));
        }
        if (parsel.checkBoxWind) {
            wind.setText(getResources().getString(R.string.wind) + ": 2 " + getResources().getString(R.string.wind_speed));
        }
        if (parsel.switchAtmospherePressure) {
            atmospherePressure.setText(getResources().getString(R.string.atmosphere_pressure) + ": 751.3 " + getResources().getString(R.string.atmosphere_pressure_measure));
        }

        newSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(v);
            }
        });
    }

    public void onClickButton(View view) {

        switch (view.getId()) {
            case R.id.backToActivityOne:
                Parsel parsel = new Parsel();
                parsel.text = "";
                parsel.checkBoxTemperature = false;
                parsel.checkBoxWind = false;
                parsel.switchAtmospherePressure = false;
                Intent intentResult = new Intent();
                intentResult.putExtra(CitiesListFragment.TEXT, parsel.text);
                intentResult.putExtra(CitiesListFragment.BOOL_CBT, parsel.checkBoxTemperature);
                intentResult.putExtra(CitiesListFragment.BOOL_CBW, parsel.checkBoxWind);
                intentResult.putExtra(CitiesListFragment.BOOL_SAP, parsel.switchAtmospherePressure);
                Bundle bundle = new Bundle();
                bundle.putParcelable(DATA, intentResult);
                ((Activity) view.getContext()).setResult(Activity.RESULT_OK, intentResult);
                ((Activity) view.getContext()).finish();
                break;
        }
    }
}
