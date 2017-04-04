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
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();
    private static final String STRING_SEPERATOR = " of ";

    public EarthquakeAdapter(Context context,List<Earthquake> earthquakes) {
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

        // Get the {@link Earthquake} object located at this position in the list
        Earthquake earthquake = getItem(position);

        // Find the TextView in the earthquake_list_item.xml layout with the ID magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);

        // Get the magnitude and color from the current Earthquake object
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // set this text on the magnitude TextView
        magnitudeTextView.setText(new DecimalFormat("0.0").format(earthquake.getMagnitude()));

        //Get original Location which gives complete location.
        String originalLocation = earthquake.getLocation();

        //Parse the original location in two parts as offset and primary location.
        String[] parsedLocation = parseLocation(originalLocation);
        String offsetLocation = parsedLocation[0];
        String primaryLocation = parsedLocation[1];

        // Find the TextView in the earthquake_list_iteme_list_item.xml layout with id of both the
        // primary and offset location.
        // Get the version number from the current Earthquake object and
        // set this text on the locationOffset TextView and primaryLocation TextView.
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetTextView.setText(offsetLocation);
        TextView primaryLocationTextView = (TextView)listItemView.findViewById(R.id.primary_location);
        primaryLocationTextView.setText(primaryLocation);

        // Find the TextView in the earthquake_list_item.xmlst_item.xml layout with the ID date
        // and time
        // Get the date and time from the current Earthquake object and
        // set the date to date TextView and time to time TextView.
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(earthquake.getDate());
        TextView timeTextView = (TextView)listItemView.findViewById(R.id.time);
        timeTextView.setText(earthquake.getTime());

        // Return the whole list item layout.
        // so that it can be shown in the ListView
        return listItemView;
    }

    private String[] parseLocation(String originalLocation){
        String[] parsedLocation = new String[2];
        if(originalLocation.contains(STRING_SEPERATOR)){
            String[] splitString = originalLocation.split(" of ");
            parsedLocation[0] = splitString[0]+STRING_SEPERATOR;
            parsedLocation[1] = splitString[1];
        }else{
            parsedLocation[0] = getContext().getString(R.string.near_the);
            parsedLocation[1] = originalLocation;
        }
        return parsedLocation;
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