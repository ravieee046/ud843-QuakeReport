package com.example.android.quakereport;

public class Earthquake {
    private String mMagnitude;
    private String mPlace;
    private String mDate;

    public Earthquake(String mMagnitude, String mPlace, String mDate) {
        this.mMagnitude = mMagnitude;
        this.mPlace = mPlace;
        this.mDate = mDate;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getDate() {
        return mDate;
    }
}
