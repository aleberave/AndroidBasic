package com.example.lesson5hw;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment();
    }

    private void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        CitiesListFragment citiesListFragment = (CitiesListFragment) fragmentManager.findFragmentByTag(CitiesListFragment.TAG);
        if (citiesListFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putString("", "");
            citiesListFragment = CitiesListFragment.init(bundle);
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, citiesListFragment, CitiesListFragment.TAG);
        transaction.commitAllowingStateLoss();
    }
}

