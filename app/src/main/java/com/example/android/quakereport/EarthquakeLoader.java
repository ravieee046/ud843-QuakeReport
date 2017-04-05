package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakeLoader.class.getSimpleName();
    private String[] mUrls;

    public EarthquakeLoader(Context context, String... mUrls) {
        super(context);
        this.mUrls = mUrls;
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrls.length<1 || mUrls[0]==null){
            return null;
        }
        // Perform the HTTP request for earthquake data and process the response.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrls[0]);
        return earthquakes;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
