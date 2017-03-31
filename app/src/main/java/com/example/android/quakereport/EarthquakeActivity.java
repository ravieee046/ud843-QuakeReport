/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake("7.2","88km N of Yelizovo, Russia","1454124312220 ms"));
        earthquakes.add(new Earthquake("6.1","94km SSE of Taron, Papua New Guinea","1453777820750 ms"));
        earthquakes.add(new Earthquake("6.3","50km NNE of Al Hoceima, Morocco","1453695722730 ms"));
        earthquakes.add(new Earthquake("7.1","86km E of Old Iliamna, Alaska","1453631430230 ms"));
        earthquakes.add(new Earthquake("6.6","215km SW of Tomatlan, Mexico","1453399617650 ms"));
        earthquakes.add(new Earthquake("6.7","52km SE of Shizunai, Japan","1452741933640 ms"));
        earthquakes.add(new Earthquake("6.1","12km WNW of Charagua, Bolivia","1452741928270 ms"));
        earthquakes.add(new Earthquake("6.2","74km NW of Rumoi, Japan","1452532083920 ms"));
        earthquakes.add(new Earthquake("6.5","227km SE of Sarangani, Philippines","1452530285900 ms"));
        earthquakes.add(new Earthquake("6","Pacific-Antarctic Ridge","1451986454620 ms"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(
                this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}