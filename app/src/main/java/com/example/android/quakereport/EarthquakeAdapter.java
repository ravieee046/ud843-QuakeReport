package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context,0,earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Earthquake} object located at this position in the list
        Earthquake earthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the magnitude from the current Earthquake object and
        // set this text on the magnitude TextView
        magnitudeTextView.setText(earthquake.getMagnitude());

        // Find the TextView in the list_item.xml layout with the ID place
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place);
        // Get the version number from the current Earthquake object and
        // set this text on the place TextView
        placeTextView.setText(earthquake.getPlace());

        // Find the TextView in the list_item.xml layout with the ID date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Get the date from the current Earthquake object and
        // set the date to date TextView
        dateTextView.setText(earthquake.getDate());

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}