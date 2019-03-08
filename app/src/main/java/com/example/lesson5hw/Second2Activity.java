package com.example.lesson5hw;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class Second2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setFragment();
    }

    private void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DataCityFragment dataCityFragment = (DataCityFragment) fragmentManager.findFragmentByTag(DataCityFragment.TAG);
        if (dataCityFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putString("", "");
            dataCityFragment = DataCityFragment.init(bundle);
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container2, dataCityFragment, DataCityFragment.TAG);
        transaction.commitAllowingStateLoss();
    }
}
