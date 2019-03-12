package com.example.lesson5hw.fragments;

import android.os.Parcel;
import android.os.Parcelable;


public class Parsel implements Parcelable {

    public String text;
    public boolean checkBoxTemperature;
    public boolean checkBoxWind;
    public boolean switchAtmospherePressure;

    public Parsel() {}

    protected Parsel(Parcel in) {
        text = in.readString();
        checkBoxTemperature = in.readByte() != 0;
        checkBoxWind = in.readByte() != 0;
        switchAtmospherePressure = in.readByte() != 0;
    }

    public static final Creator<Parsel> CREATOR = new Creator<Parsel>() {
        @Override
        public Parsel createFromParcel(Parcel in) {
            return new Parsel(in);
        }

        @Override
        public Parsel[] newArray(int size) {
            return new Parsel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeByte((byte) (checkBoxTemperature ? 1 : 0));
        dest.writeByte((byte) (checkBoxWind ? 1 : 0));
        dest.writeByte((byte) (switchAtmospherePressure ? 1 : 0));
    }
}