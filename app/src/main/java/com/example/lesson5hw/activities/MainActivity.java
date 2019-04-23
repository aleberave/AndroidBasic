package com.example.lesson5hw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lesson5hw.R;
import com.example.lesson5hw.fragments.CitiesListFragment;

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
        Bundle bundle = new Bundle();
        if (citiesListFragment == null) {
            bundle.putString("", "");
            citiesListFragment = CitiesListFragment.init(bundle);
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, citiesListFragment, CitiesListFragment.TAG);
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CitiesListFragment citiesListFragment = (CitiesListFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        citiesListFragment.onActivityResult(requestCode, resultCode, data);
    }
}

