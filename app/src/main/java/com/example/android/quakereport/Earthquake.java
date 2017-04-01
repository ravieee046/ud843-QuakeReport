package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {
    private Double mMagnitude;
    private String mLocation;
    private String mDate;
    private String mTime;
    private long   mUnixTime; //It is in milli second from 1st Jan 1970 mid night.
    private String mUrl;

    public Earthquake(Double mMagnitude, String mLocation, long mUnixTime, String mUrl) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mUnixTime = mUnixTime;
        this.mUrl = mUrl;

        //It sets Date and Time in proper format from Unix time.
        setDateAndTimeFormat();
    }
    private void setDateAndTimeFormat(){
        Date date = new Date(this.mUnixTime);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        this.mDate = dateFormatter.format(date);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        this.mTime = timeFormatter.format(date);
    }

    public Double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

    public String getTime() {
        return mTime;
    }

    public String getUrl() {
        return mUrl;
    }
}
