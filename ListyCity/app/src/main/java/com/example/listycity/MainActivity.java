package com.example.listycity;


import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Declare reference vars
    private ListView cityList;
    private Button addCityButton;
    private Button removeCityButton;
    private Button confirmCityButton;
    private RelativeLayout bottomBar; // the bar where users enter city names
    private ArrayAdapter<String> cityAdapter;
    private ArrayList<String> dataList;
    private int selectedElement = -1; // Selected list element

    /**
     * Main entry point
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find IDs
        cityList = findViewById(R.id.city_list);
        addCityButton = findViewById(R.id.add_city);
        removeCityButton = findViewById(R.id.remove_city);
        confirmCityButton = findViewById(R.id.confirm_city);
        bottomBar = findViewById(R.id.bottom_bar);

        // Set up list data
        String[] cities = {"Edmonton", "Regina", "Toronto", "Red Deer", "Airdrie", "Cold Lake"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        // Link Adapter to list
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList); // link dataList to content.xml
        cityList.setAdapter(cityAdapter);

        // Make the buttons do stuff with onClickListeners

        addCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Makes bottomBar visible so user can enter city name
                bottomBar.setVisibility(VISIBLE);
            }
        });

        removeCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCity();
            }
        });

        confirmCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to confirm city name after typing
                addCity();
                bottomBar.setVisibility(GONE);
            }
        });

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Code to select city item
                selectedElement = position;

                // Test
                String text = String.format("Selected %s", cityAdapter.getItem(selectedElement));
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Removes selected city from cityList.
     */
    private void removeCity() {
        if (selectedElement != -1) { // Some City is selected
            cityAdapter.remove(cityAdapter.getItem(selectedElement));
            String text = String.format("Deleted %s", cityAdapter.getItem(selectedElement - 1));
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            selectedElement = -1; // Deselect city

        } else { // No City is selected
            String text = "Please select a city...";
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        }
    }

    // Functions

    /**
     * Adds city to cityList
     *
     * taken from <a href="https://www.youtube.com/watch?v=i9mkAoZ8FNk">...</a>. I'll cite good later.
     */
    private void addCity() {
        // Collect user input
        EditText input = findViewById(R.id.editText);
        String cityName = input.getText().toString();

        if (!(cityName.isEmpty())) { // User entered a value
            cityAdapter.add(cityName);
            input.setText("");
        } else { // Text box is empty
            String text = "Please type in a city name...";
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        }
    }
}