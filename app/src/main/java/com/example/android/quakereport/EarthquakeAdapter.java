package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();
    private static final String STRING_SEPERATOR = " of ";

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
                    R.layout.earthquake_list_item, parent, false);
        }

        // Find the TextView in the earthquake_list_item.xmlst_item.xml layout with the ID magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the magnitude from the current Earthquake object and
        // set this text on the magnitude TextView

        // Get the {@link Earthquake} object located at this position in the list
        Earthquake earthquake = getItem(position);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        magnitudeTextView.setText(new DecimalFormat("0.0").format(earthquake.getMagnitude()));

        String originalLocation = earthquake.getLocation();
        String offsetLocation;
        String primaryLocation;

        if(originalLocation.contains(STRING_SEPERATOR)){
            String[] temp = originalLocation.split(" of ");
            offsetLocation = temp[0]+STRING_SEPERATOR;
            primaryLocation = temp[1];
        }else{
            offsetLocation = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;

        }

        // Find the TextView in the earthquake_list_iteme_list_item.xml layout with the ID location
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        // Get the version number from the current Earthquake object and
        // set this text on the location TextView
        locationOffsetTextView.setText(offsetLocation);

        TextView primaryLocationTextView = (TextView)listItemView.findViewById(R.id.primary_location);
        primaryLocationTextView.setText(primaryLocation);

        // Find the TextView in the earthquake_list_item.xmlst_item.xml layout with the ID date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Get the date from the current Earthquake object and
        // set the date to date TextView
        dateTextView.setText(earthquake.getDate());

        TextView timeTextView = (TextView)listItemView.findViewById(R.id.time);
        timeTextView.setText(earthquake.getTime());

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

    private int getMagnitudeColor(double magnitude){
        int color;
        switch ((int) Math.floor(magnitude)){
            case 0:
            case 1:
                color = R.color.magnitude1;
                break;
            case 2:
                color = R.color.magnitude2;
                break;
            case 3:
                color = R.color.magnitude3;
                break;
            case 4:
                color = R.color.magnitude4;
                break;
            case 5:
                color = R.color.magnitude5;
                break;
            case 6:
                color = R.color.magnitude6;
                break;
            case 7:
                color = R.color.magnitude7;
                break;
            case 8:
                color = R.color.magnitude8;
                break;
            case 9:
                color = R.color.magnitude9;
                break;
            default:
                color = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), color);
    }
}